package vn.sapo.sync.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serializable;
import java.util.List;

@Document(collection = "item")
public class Item extends AbstractEntity implements Serializable {

    @Id
    private String id;

    @Field("fulfillable_quantity")
    @JsonProperty("fulfillable_quantity")
    private String fulfillableQuantity;

    @Field("fulfillment_status")
    @JsonProperty("fulfillment_status")
    private String fulfillmentStatus;

    @Field("grams")
    private Double grams;

    @Field("price")
    private Double price;

    @Field("product_id")
    @JsonProperty("product_id")
    private String productId;

    @Field("quantity")
    private String quantity;

    @Field("requires_shipping")
    @JsonProperty("requires_shipping")
    private boolean requiresShipping;

    @Field("sku")
    private String sku;

    @Field("title")
    private String title;

    @Field("variant_id")
    @JsonProperty("variant_id")
    private String variantId;

    @Field("variant_title")
    @JsonProperty("variant_title")
    private String variantTitle;

    @Field("vendor")
    private String vendor;

    @Field("name")
    private String name;

    @Field("gift_card")
    @JsonProperty("gift_card")
    private boolean giftCard;

    @Field("total_discount")
    @JsonProperty("total_discount")
    private Double totalDiscount;

    @Field("product_exists")
    @JsonProperty("product_exists")
    private boolean productExists;

    @Field("variant_inventory_management")
    @JsonProperty("variant_inventory_management")
    private String variantInventoryManagement;

    @Field("discount_code")
    @JsonProperty("discount_code")
    private String discountCode;

    @Field("properties")
    private List<Property> properties;

    @Field("tax_lines")
    @JsonProperty("tax_lines")
    private List<String> taxLines;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFulfillableQuantity() {
        return fulfillableQuantity;
    }

    public void setFulfillableQuantity(String fulfillableQuantity) {
        this.fulfillableQuantity = fulfillableQuantity;
    }

    public String getFulfillmentStatus() {
        return fulfillmentStatus;
    }

    public void setFulfillmentStatus(String fulfillmentStatus) {
        this.fulfillmentStatus = fulfillmentStatus;
    }

    public Double getGrams() {
        return grams;
    }

    public void setGrams(Double grams) {
        this.grams = grams;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public boolean isRequiresShipping() {
        return requiresShipping;
    }

    public void setRequiresShipping(boolean requiresShipping) {
        this.requiresShipping = requiresShipping;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getVariantId() {
        return variantId;
    }

    public void setVariantId(String variantId) {
        this.variantId = variantId;
    }

    public String getVariantTitle() {
        return variantTitle;
    }

    public void setVariantTitle(String variantTitle) {
        this.variantTitle = variantTitle;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isGiftCard() {
        return giftCard;
    }

    public void setGiftCard(boolean giftCard) {
        this.giftCard = giftCard;
    }

    public Double getTotalDiscount() {
        return totalDiscount;
    }

    public void setTotalDiscount(Double totalDiscount) {
        this.totalDiscount = totalDiscount;
    }

    public boolean isProductExists() {
        return productExists;
    }

    public void setProductExists(boolean productExists) {
        this.productExists = productExists;
    }

    public String getVariantInventoryManagement() {
        return variantInventoryManagement;
    }

    public void setVariantInventoryManagement(String variantInventoryManagement) {
        this.variantInventoryManagement = variantInventoryManagement;
    }

    public String getDiscountCode() {
        return discountCode;
    }

    public void setDiscountCode(String discountCode) {
        this.discountCode = discountCode;
    }

    public List<Property> getProperties() {
        return properties;
    }

    public void setProperties(List<Property> properties) {
        this.properties = properties;
    }

    public List<String> getTaxLines() {
        return taxLines;
    }

    public void setTaxLines(List<String> taxLines) {
        this.taxLines = taxLines;
    }
}
