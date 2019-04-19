package vn.sapo.sync.web.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.*;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;
import vn.sapo.sync.config.SapoConstants;
import vn.sapo.sync.config.SapoProperties;
import vn.sapo.sync.domain.Product;
import vn.sapo.sync.dto.Counts;
import vn.sapo.sync.dto.IdDTO;
import vn.sapo.sync.dto.Products;
import vn.sapo.sync.service.ProductService;
import vn.sapo.sync.web.errors.BadRequestAlertException;
import vn.sapo.sync.web.util.HeaderUtil;

@RestController
@RequestMapping("/admin/sync")
public class ProductResource {

    private final Logger log = LoggerFactory.getLogger(ProductResource.class);

    private static final String ENTITY_NAME = "Product";
    private static final String ENTITY_ID = "Product-Id";

    private final SapoProperties sapoProperties;

    private final ProductService productService;

    private KafkaTemplate<Object, Object> kafkaTemplate;

    public ProductResource(SapoProperties sapoProperties, ProductService productService, KafkaTemplate<Object, Object> kafkaTemplate) {
        this.sapoProperties = sapoProperties;
        this.productService = productService;
        this.kafkaTemplate = kafkaTemplate;
    }

    /**
     * GET : Đồng bộ tất cả products từ Sapo Core
     */
    @GetMapping("/products")
    public ResponseEntity<Object> syncProducts() {
        log.debug("REST request sync Products");

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders header = HeaderUtil.getHeadersToken(sapoProperties.getSecurity().getAccessToken());
        HttpEntity<Object> entity = new HttpEntity<>(header);

        ResponseEntity<Counts> resultCount;
        ResponseEntity<Products> result;
        try {
            String urlCount = SapoConstants.HTTS + sapoProperties.getSecurity().getStore() + "/admin/products/count.json";
            resultCount = restTemplate.exchange(urlCount, HttpMethod.GET, entity, Counts.class);
            Counts counts = resultCount.getBody();
            if (counts != null && counts.getIntCounts() > 0 && resultCount.getStatusCode().equals(HttpStatus.OK)) {
                String url;
                if (counts.getIntCounts() / sapoProperties.getLimit() > 0) {
                    for (int i = 0; i <= counts.getIntCounts() / sapoProperties.getLimit(); i++) {
                        url = SapoConstants.HTTS + sapoProperties.getSecurity().getStore() + "/admin/products.json?page=" + (i + 1);
                        result = restTemplate.exchange(url, HttpMethod.GET, entity, Products.class);
                        Products products = result.getBody();
                        if (!StringUtils.isEmpty(products) && !products.getLstProduct().isEmpty() && result.getStatusCode().equals(HttpStatus.OK)) {
                            productService.saveAll(products.getLstProduct());
                        }
                    }
                } else {
                    url = SapoConstants.HTTS + sapoProperties.getSecurity().getStore() + "/admin/products.json";
                    result = restTemplate.exchange(url, HttpMethod.GET, entity, Products.class);
                    Products products = result.getBody();
                    if (!StringUtils.isEmpty(products) && !products.getLstProduct().isEmpty() && result.getStatusCode().equals(HttpStatus.OK)) {
                        productService.saveAll(products.getLstProduct());
                    }
                }
                return ResponseEntity.ok().build();
            } else {
                return ResponseEntity.badRequest().build();
            }
        } catch (HttpStatusCodeException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    /**
     * POST : Lưu một product
     *
     * @param product
     */
    @PostMapping("/products/save")
    public ResponseEntity<Object> saveProduct(@RequestBody Product product) {
        log.debug("REST request to save Product : {}", product);
        if (product.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }

        this.kafkaTemplate.send("products.save", product);
        return ResponseEntity.ok()
                .headers(HeaderUtil.getHeaders(sapoProperties.getSecurity().getStore(), ENTITY_ID, product.getId(), "/products/save")).build();

//        Product result = productService.save(product);
//        return ResponseEntity.ok()
//                .headers(HeaderUtil.getHeaders(sapoProperties.getSecurity().getStore(), ENTITY_ID, result.getId(), "/products/save"))
//                .body(result);
    }

    /**
     * POST : Xoá một product
     *
     * @param idDTO
     */
    @PostMapping("/products/delete")
    public ResponseEntity<Object> updateProduct(@RequestBody IdDTO idDTO) {
        log.debug("REST request to update Product : {}", idDTO);
        if (idDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }

        this.kafkaTemplate.send("products.delete", idDTO);

//        productService.deleteById(idDTO.getId());
        return ResponseEntity.ok()
                .headers(HeaderUtil.getHeaders(sapoProperties.getSecurity().getStore(), ENTITY_ID, idDTO.getId(), "/products/delete")).build();
    }

}
