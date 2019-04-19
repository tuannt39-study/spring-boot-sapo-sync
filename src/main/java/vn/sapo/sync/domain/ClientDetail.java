package vn.sapo.sync.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serializable;

@Document(collection = "client_detail")
public class ClientDetail extends AbstractEntity implements Serializable {

    @Id
    private String id;

    @Field("browser_ip")
    @JsonProperty("browser_ip")
    private String browserIp;

    @Field("accept_language")
    @JsonProperty("accept_language")
    private String acceptLanguage;

    @Field("user_agent")
    @JsonProperty("user_agent")
    private String userAgent;

    @Field("session_hash")
    @JsonProperty("session_hash")
    private String sessionHash;

    @Field("browser_width")
    @JsonProperty("browser_width")
    private String browserWidth;

    @Field("browser_height")
    @JsonProperty("browser_height")
    private String browserHeight;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBrowserIp() {
        return browserIp;
    }

    public void setBrowserIp(String browserIp) {
        this.browserIp = browserIp;
    }

    public String getAcceptLanguage() {
        return acceptLanguage;
    }

    public void setAcceptLanguage(String acceptLanguage) {
        this.acceptLanguage = acceptLanguage;
    }

    public String getUserAgent() {
        return userAgent;
    }

    public void setUserAgent(String userAgent) {
        this.userAgent = userAgent;
    }

    public String getSessionHash() {
        return sessionHash;
    }

    public void setSessionHash(String sessionHash) {
        this.sessionHash = sessionHash;
    }

    public String getBrowserWidth() {
        return browserWidth;
    }

    public void setBrowserWidth(String browserWidth) {
        this.browserWidth = browserWidth;
    }

    public String getBrowserHeight() {
        return browserHeight;
    }

    public void setBrowserHeight(String browserHeight) {
        this.browserHeight = browserHeight;
    }
}
