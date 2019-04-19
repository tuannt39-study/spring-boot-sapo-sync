package vn.sapo.sync.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "sapo", ignoreUnknownFields = false)
public class SapoProperties {


    private Integer limit = 250;

    private final Client client = new Client();

    private final Security security = new Security();

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Client getClient() {
        return client;
    }

    public Security getSecurity() {
        return security;
    }

    public static class Client {

        private String clientId = "";
        private String clientSecret = "";

        public String getClientId() {
            return clientId;
        }

        public void setClientId(String clientId) {
            this.clientId = clientId;
        }

        public String getClientSecret() {
            return clientSecret;
        }

        public void setClientSecret(String clientSecret) {
            this.clientSecret = clientSecret;
        }
    }

    public static class Security {

        private String store = "";
        private String code = "";
        private String hmac = "";
        private String accessToken = "";

        public String getStore() {
            return store;
        }

        public void setStore(String store) {
            this.store = store;
        }

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public String getHmac() {
            return hmac;
        }

        public void setHmac(String hmac) {
            this.hmac = hmac;
        }

        public String getAccessToken() {
            return accessToken;
        }

        public void setAccessToken(String accessToken) {
            this.accessToken = accessToken;
        }
    }

}
