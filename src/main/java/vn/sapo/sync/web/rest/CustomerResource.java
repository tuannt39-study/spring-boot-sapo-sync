package vn.sapo.sync.web.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.*;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;
import vn.sapo.sync.config.SapoConstants;
import vn.sapo.sync.config.SapoProperties;
import vn.sapo.sync.dto.Counts;
import vn.sapo.sync.dto.Customers;
import vn.sapo.sync.service.CustomerService;
import vn.sapo.sync.web.util.HeaderUtil;

@RestController
@RequestMapping("/admin/sync")
public class CustomerResource {

    private final Logger log = LoggerFactory.getLogger(CustomerResource.class);

    private final SapoProperties sapoProperties;

    private final CustomerService customerService;

    public CustomerResource(SapoProperties sapoProperties, CustomerService customerService) {
        this.sapoProperties = sapoProperties;
        this.customerService = customerService;
    }

    /**
     * GET : Đồng bộ tất cả customers từ Sapo Core
     */
    @GetMapping("/customers")
    public ResponseEntity<Object> syncCustomers() {
        log.debug("REST request sync Customers");

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders header = HeaderUtil.getHeadersToken(sapoProperties.getSecurity().getAccessToken());
        HttpEntity<Object> entity = new HttpEntity<>(header);

        ResponseEntity<Counts> resultCount;
        ResponseEntity<Customers> result;
        try {
            String urlCount = SapoConstants.HTTS + sapoProperties.getSecurity().getStore() + "/admin/customers/count.json";
            resultCount = restTemplate.exchange(urlCount, HttpMethod.GET, entity, Counts.class);
            Counts counts = resultCount.getBody();
            if (counts != null && counts.getIntCounts() > 0 && resultCount.getStatusCode().equals(HttpStatus.OK)) {
                String url;
                if (counts.getIntCounts() / sapoProperties.getLimit() > 0) {
                    for (int i = 0; i <= counts.getIntCounts() / sapoProperties.getLimit(); i++) {
                        url = SapoConstants.HTTS + sapoProperties.getSecurity().getStore() + "/admin/customers.json?page=" + (i + 1);
                        result = restTemplate.exchange(url, HttpMethod.GET, entity, Customers.class);
                        Customers customers = result.getBody();
                        if (!StringUtils.isEmpty(customers) && !customers.getLstCustomer().isEmpty() && result.getStatusCode().equals(HttpStatus.OK)) {
                            customerService.saveAll(customers.getLstCustomer());
                        }
                    }
                } else {
                    url = SapoConstants.HTTS + sapoProperties.getSecurity().getStore() + "/admin/customers.json";
                    result = restTemplate.exchange(url, HttpMethod.GET, entity, Customers.class);
                    Customers customers = result.getBody();
                    if (!StringUtils.isEmpty(customers) && !customers.getLstCustomer().isEmpty() && result.getStatusCode().equals(HttpStatus.OK)) {
                        customerService.saveAll(customers.getLstCustomer());
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
