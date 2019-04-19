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
import vn.sapo.sync.dto.Orders;
import vn.sapo.sync.service.OrderService;
import vn.sapo.sync.web.util.HeaderUtil;

@RestController
@RequestMapping("/admin/sync")
public class OrderResource {

    private final Logger log = LoggerFactory.getLogger(OrderResource.class);

    private final SapoProperties sapoProperties;

    private final OrderService orderService;

    public OrderResource(SapoProperties sapoProperties, OrderService orderService) {
        this.sapoProperties = sapoProperties;
        this.orderService = orderService;
    }

    /**
     * GET : Đồng bộ tất cả orders từ Sapo Core
     */
    @GetMapping("/orders")
    public ResponseEntity<Object> syncOrders() {
        log.debug("REST request sync Orders");

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders header = HeaderUtil.getHeadersToken(sapoProperties.getSecurity().getAccessToken());
        HttpEntity<Object> entity = new HttpEntity<>(header);

        ResponseEntity<Counts> resultCount;
        ResponseEntity<Orders> result;
        try {
            String urlCount = SapoConstants.HTTS + sapoProperties.getSecurity().getStore() + "/admin/orders/count.json";
            resultCount = restTemplate.exchange(urlCount, HttpMethod.GET, entity, Counts.class);
            Counts counts = resultCount.getBody();
            if (counts != null && counts.getIntCounts() > 0 && resultCount.getStatusCode().equals(HttpStatus.OK)) {
                String url;
                if (counts.getIntCounts() / sapoProperties.getLimit() > 0) {
                    for (int i = 0; i <= counts.getIntCounts() / sapoProperties.getLimit(); i++) {
                        url = SapoConstants.HTTS + sapoProperties.getSecurity().getStore() + "/admin/orders.json?page=" + (i + 1);
                        result = restTemplate.exchange(url, HttpMethod.GET, entity, Orders.class);
                        Orders orders = result.getBody();
                        if (!StringUtils.isEmpty(orders) && !orders.getLstOrder().isEmpty() && result.getStatusCode().equals(HttpStatus.OK)) {
                            orderService.saveAll(orders.getLstOrder());
                        }
                    }
                } else {
                    url = SapoConstants.HTTS + sapoProperties.getSecurity().getStore() + "/admin/orders.json";
                    result = restTemplate.exchange(url, HttpMethod.GET, entity, Orders.class);
                    Orders orders = result.getBody();
                    if (!StringUtils.isEmpty(orders) && !orders.getLstOrder().isEmpty() && result.getStatusCode().equals(HttpStatus.OK)) {
                        orderService.saveAll(orders.getLstOrder());
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
