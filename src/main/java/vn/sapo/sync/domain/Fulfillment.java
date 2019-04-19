package vn.sapo.sync.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serializable;
import java.util.List;

@Document(collection = "fulfillment")
public class Fulfillment extends AbstractEntity implements Serializable {

    @Id
    private String id;

    @Field("order_id")
    @JsonProperty("order_id")
    private String orderId;

    @Field("status")
    private String status;

    @Field("service")
    private String service;

    @Field("tracking_company")
    @JsonProperty("tracking_company")
    private String trackingCompany;

    @Field("tracking_number")
    @JsonProperty("tracking_number")
    private String trackingNumber;

    @Field("tracking_numbers")
    @JsonProperty("tracking_numbers")
    private String trackingNumbers;

    @Field("tracking_url")
    @JsonProperty("tracking_url")
    private String trackingUrl;

    @Field("tracking_urls")
    @JsonProperty("tracking_urls")
    private List<String> trackingUrls;

    @Field("receipt")
    private Receipt receipt;

    @Field("line_items")
    @JsonProperty("line_items")
    private List<Item> lineItems;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public String getTrackingCompany() {
        return trackingCompany;
    }

    public void setTrackingCompany(String trackingCompany) {
        this.trackingCompany = trackingCompany;
    }

    public String getTrackingNumber() {
        return trackingNumber;
    }

    public void setTrackingNumber(String trackingNumber) {
        this.trackingNumber = trackingNumber;
    }

    public String getTrackingNumbers() {
        return trackingNumbers;
    }

    public void setTrackingNumbers(String trackingNumbers) {
        this.trackingNumbers = trackingNumbers;
    }

    public String getTrackingUrl() {
        return trackingUrl;
    }

    public void setTrackingUrl(String trackingUrl) {
        this.trackingUrl = trackingUrl;
    }

    public List<String> getTrackingUrls() {
        return trackingUrls;
    }

    public void setTrackingUrls(List<String> trackingUrls) {
        this.trackingUrls = trackingUrls;
    }

    public Receipt getReceipt() {
        return receipt;
    }

    public void setReceipt(Receipt receipt) {
        this.receipt = receipt;
    }

    public List<Item> getLineItems() {
        return lineItems;
    }

    public void setLineItems(List<Item> lineItems) {
        this.lineItems = lineItems;
    }
}
