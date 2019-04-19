package vn.sapo.sync.web.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;
import vn.sapo.sync.config.SapoConstants;
import vn.sapo.sync.config.SapoProperties;
import vn.sapo.sync.domain.AccessToken;
import vn.sapo.sync.dto.AccessClient;
import vn.sapo.sync.dto.Authorize;
import vn.sapo.sync.repository.AccessTokenRepository;
import vn.sapo.sync.web.util.HeaderUtil;

import java.util.Date;
import java.util.Optional;

@RestController
@RequestMapping("/admin/sync")
public class SapoSyncResource {

    private final Logger log = LoggerFactory.getLogger(SapoSyncResource.class);

    private final AccessTokenRepository accessTokenRepository;

    private final SapoProperties sapoProperties;

    public SapoSyncResource(AccessTokenRepository accessTokenRepository, SapoProperties sapoProperties) {
        this.accessTokenRepository = accessTokenRepository;
        this.sapoProperties = sapoProperties;
    }

    /**
     * POST : Lấy xác thực từ User. Hiển thị màn hình xin quyền được cung cấp bởi Sapo
     *
     * @param authorize
     */
    @PostMapping("/authorize")
    public String authorize(@RequestBody Authorize authorize) {
        log.debug("REST request to get Authorize");
        String url = SapoConstants.HTTS + authorize.getStoreName() + ".bizwebvietnam.net/admin/oauth/authorize?client_id=" + authorize.getApiKey() + "&scope=" + authorize.getScopes() + "&redirect_uri=" + authorize.getRedirectUri();
        sapoProperties.getSecurity().setStore(authorize.getStoreName());
        return "redirect:" + url;
    }

    /**
     * GET : Lấy access token từ Sapo Core
     *
     * @param accessClient
     */
    @GetMapping("/access_token")
    public ResponseEntity<Object> accessToken(@RequestBody AccessClient accessClient) {
        log.debug("REST request to get Access Token");

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders header = HeaderUtil.getBaseHeaders();
        HttpEntity<Object> entity = new HttpEntity<>(header);

        ResponseEntity<AccessToken> result;
        try {
            String url = SapoConstants.HTTS + sapoProperties.getSecurity().getStore() + "/admin/oauth/access_token" + "?client_id=" + accessClient.getClientId() + "&client_secret=" + accessClient.getClientSecret() + "&code=" + accessClient.getCode();
            result = restTemplate.exchange(url, HttpMethod.POST, entity, AccessToken.class);
            AccessToken token = result.getBody();
            if (token != null && result.getStatusCode().equals(HttpStatus.OK)) {
                Optional<AccessToken> existingAccessToken = accessTokenRepository.findById(SapoConstants.ACCESS_TOKEN);
                if (existingAccessToken.isPresent()) {
                    AccessToken accessToken = existingAccessToken.get();
                    if (token.getToken() != null) {
                        accessToken.setToken(token.getToken());
                    }
                    if (token.getScope() != null) {
                        accessToken.setScope(token.getScope());
                    }
                    accessToken.setModifiedOn(new Date());
                    accessTokenRepository.save(accessToken);
                } else {
                    AccessToken accessToken = new AccessToken();
                    accessToken.setId(SapoConstants.ACCESS_TOKEN);
                    if (token.getToken() != null) {
                        accessToken.setToken(token.getToken());
                    }
                    if (token.getScope() != null) {
                        accessToken.setScope(token.getScope());
                    }
                    accessTokenRepository.save(accessToken);
                }
                sapoProperties.getSecurity().setAccessToken(token.getToken());
                return ResponseEntity.ok().build();
            } else {
                return new ResponseEntity<>(header, result.getStatusCode());
            }
        } catch (HttpStatusCodeException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    /**
     * GET : Lấy access token từ Database
     */
    @GetMapping("/token")
    public ResponseEntity<Object> token() {
        log.debug("REST request to get Token");
        Optional<AccessToken> accessToken = accessTokenRepository.findById(SapoConstants.ACCESS_TOKEN);
        if (accessToken.isPresent()) {
            sapoProperties.getSecurity().setAccessToken(accessToken.get().getToken());
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

}
