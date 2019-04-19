package vn.sapo.sync.web.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.*;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;
import vn.sapo.sync.config.SapoConstants;
import vn.sapo.sync.config.SapoProperties;
import vn.sapo.sync.dto.Counts;
import vn.sapo.sync.dto.Variants;
import vn.sapo.sync.service.VariantService;
import vn.sapo.sync.web.util.HeaderUtil;

@RestController
@RequestMapping("/admin/sync")
public class VariantResource {

    private final Logger log = LoggerFactory.getLogger(VariantResource.class);

    private final SapoProperties sapoProperties;

    private final VariantService variantService;

    public VariantResource(SapoProperties sapoProperties, VariantService variantService) {
        this.sapoProperties = sapoProperties;
        this.variantService = variantService;
    }

    /**
     * GET : Đồng bộ tất cả variants từ Sapo Core
     *
     * @param productId
     */
    @GetMapping("/variants/{productId}")
    public ResponseEntity<Object> syncVariants(@PathVariable String productId) {
        log.debug("REST request sync Variants");

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders header = HeaderUtil.getHeadersToken(sapoProperties.getSecurity().getAccessToken());
        HttpEntity<Object> entity = new HttpEntity<>(header);

        ResponseEntity<Counts> resultCount;
        ResponseEntity<Variants> result;
        try {
            String urlCount = SapoConstants.HTTS + sapoProperties.getSecurity().getStore() + "/admin/products/" + productId + "/variants/count.json";
            resultCount = restTemplate.exchange(urlCount, HttpMethod.GET, entity, Counts.class);
            Counts counts = resultCount.getBody();
            if (counts != null && counts.getIntCounts() > 0 && resultCount.getStatusCode().equals(HttpStatus.OK)) {
                String url;
                if (counts.getIntCounts() / sapoProperties.getLimit() > 0) {
                    for (int i = 0; i <= counts.getIntCounts() / sapoProperties.getLimit(); i++) {
                        url = SapoConstants.HTTS + sapoProperties.getSecurity().getStore() + "/admin/products" + productId + "/variants.json?page=" + (i + 1);
                        result = restTemplate.exchange(url, HttpMethod.GET, entity, Variants.class);
                        Variants variants = result.getBody();
                        if (!StringUtils.isEmpty(variants) && !variants.getLstVariant().isEmpty() && result.getStatusCode().equals(HttpStatus.OK)) {
                            variantService.saveAll(variants.getLstVariant());
                        }
                    }
                } else {
                    url = SapoConstants.HTTS + sapoProperties.getSecurity().getStore() + "/admin/products/" + productId + "/variants.json";
                    result = restTemplate.exchange(url, HttpMethod.GET, entity, Variants.class);
                    Variants variants = result.getBody();
                    if (!StringUtils.isEmpty(variants) && !variants.getLstVariant().isEmpty() && result.getStatusCode().equals(HttpStatus.OK)) {
                        variantService.saveAll(variants.getLstVariant());
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

}
