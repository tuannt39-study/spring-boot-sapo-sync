package vn.sapo.sync.web.util;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

import java.util.Arrays;

public final class HeaderUtil {

    private static final String APPLICATION_NAME = "Bizweb";

    public static HttpHeaders getBaseHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN, MediaType.ALL));
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
        return headers;
    }

    public static HttpHeaders getHeadersToken(String accessToken) {
        HttpHeaders headers = getBaseHeaders();
        headers.add("X-" + APPLICATION_NAME + "-Access-Token", accessToken);
        return headers;
    }

    public static HttpHeaders getHeaders(String store, String entity, String param, String action) {
        HttpHeaders headers = getBaseHeaders();
        headers.add("X-" + APPLICATION_NAME + "-Topic", action);
        headers.add("X-" + APPLICATION_NAME + "-" + entity, param);
        headers.add("X-" + APPLICATION_NAME + "-Shop-Domain", store);
        return headers;
    }

}
