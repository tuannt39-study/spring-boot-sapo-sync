package vn.sapo.sync.web.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;
import vn.sapo.sync.config.SapoConstants;
import vn.sapo.sync.config.SapoProperties;
import vn.sapo.sync.dto.IdDTO;
import vn.sapo.sync.dto.WebhookDTO;
import vn.sapo.sync.dto.Webhooks;
import vn.sapo.sync.web.util.HeaderUtil;

@RestController
@RequestMapping("/admin/sync")
public class WebhookResource {

    private final Logger log = LoggerFactory.getLogger(WebhookResource.class);

    private final SapoProperties sapoProperties;

    public WebhookResource(SapoProperties sapoProperties) {
        this.sapoProperties = sapoProperties;
    }

    /**
     * GET : Lấy danh sách tất cả các Webhook
     */
    @GetMapping("/webhooks")
    public ResponseEntity<Object> findAllWebhook() {
        log.debug("REST request get all Webhooks");

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders header = HeaderUtil.getHeadersToken(sapoProperties.getSecurity().getAccessToken());
        HttpEntity<Object> entity = new HttpEntity<>(header);

        ResponseEntity<Webhooks> result;
        try {
            String url = SapoConstants.HTTS + sapoProperties.getSecurity().getStore() + "/admin/webhooks.json";
            result = restTemplate.exchange(url, HttpMethod.GET, entity, Webhooks.class);
            return new ResponseEntity<>(result.getBody(), header, result.getStatusCode());
        } catch (HttpStatusCodeException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    /**
     * PUT : Cập nhật một Webhook
     *
     * @param webhookDTO
     */
    @PutMapping("/webhooks")
    public ResponseEntity<Object> saveWebhook(@RequestBody WebhookDTO webhookDTO) {
        log.debug("REST request to update Webhook");

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders header = HeaderUtil.getHeadersToken(sapoProperties.getSecurity().getAccessToken());
        HttpEntity<WebhookDTO> entity = new HttpEntity<>(webhookDTO, header);

        ResponseEntity<WebhookDTO> result;
        try {
            String url = SapoConstants.HTTS + sapoProperties.getSecurity().getStore() + "/admin/webhooks/" + webhookDTO.getWebhook().getId() + ".json";
            result = restTemplate.exchange(url, HttpMethod.PUT, entity, WebhookDTO.class);
            return new ResponseEntity<>(result.getBody(), header, result.getStatusCode());
        } catch (HttpStatusCodeException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    /**
     * POST : Tạo mới một Webhook
     *
     * @param webhookDTO
     */
    @PostMapping("/webhooks")
    public ResponseEntity<Object> updateWebhook(@RequestBody WebhookDTO webhookDTO) {
        log.debug("REST request to update Webhook");

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders header = HeaderUtil.getHeadersToken(sapoProperties.getSecurity().getAccessToken());
        HttpEntity<WebhookDTO> entity = new HttpEntity<>(webhookDTO, header);

        ResponseEntity<WebhookDTO> result;
        try {
            String url = SapoConstants.HTTS + sapoProperties.getSecurity().getStore() + "/admin/webhooks.json";
            result = restTemplate.exchange(url, HttpMethod.POST, entity, WebhookDTO.class);
            return new ResponseEntity<>(result.getBody(), header, result.getStatusCode());
        } catch (HttpStatusCodeException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    /**
     * DELETE : Xóa một Webhook
     *
     * @param idDTO
     */
    @DeleteMapping("/webhooks")
    public ResponseEntity<Object> deleteWebhook(@RequestBody IdDTO idDTO) {
        log.debug("REST request to delete Webhook : {}", idDTO);

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders header = HeaderUtil.getHeadersToken(sapoProperties.getSecurity().getAccessToken());
        HttpEntity<IdDTO> entity = new HttpEntity<>(idDTO, header);

        ResponseEntity<Object> result;
        try {
            String url = SapoConstants.HTTS + sapoProperties.getSecurity().getStore() + "/admin/webhooks/" + idDTO.getId() + ".json";
            result = restTemplate.exchange(url, HttpMethod.DELETE, entity, Object.class);
            return new ResponseEntity<>(result.getBody(), header, result.getStatusCode());
        } catch (HttpStatusCodeException e) {
            return ResponseEntity.badRequest().build();
        }
    }

}
