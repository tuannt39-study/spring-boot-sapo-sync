package vn.sapo.sync.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serializable;

@Document(collection = "variant")
public class Variant extends AbstractEntity implements Serializable {

    @Id
    private String id;

    @Field("product_id")
    @JsonProperty("product_id")
    private String productId;

    @Field("image_id")
    @JsonProperty("image_id")
    private String imageId;

    @Field("barcode")
    private String barcode;

    @Field("sku")
    private String sku;

    @Field("price")
    private Double price;

    @Field("compare_at_price")
    @JsonProperty("compare_at_price")
    private Double compareAtPrice;

    @Field("option1")
    private String option1;

    @Field("option2")
    private String option2;

    @Field("option3")
    private String option3;

    @Field("taxable")
    private boolean taxable;

    @Field("inventory_management")
    @JsonProperty("inventory_management")
    private String inventoryManagement;

    @Field("inventory_policy")
    @JsonProperty("inventory_policy")
    private String inventoryPolicy;

    @Field("inventory_quantity")
    @JsonProperty("inventory_quantity")
    private Double inventoryQuantity;

    @Field("requires_shipping")
    @JsonProperty("requires_shipping")
    private boolean requiresShipping;

    @Field("weight")
    private Double weight;

    @Field("weight_unit")
    @JsonProperty("weight_unit")
    private String weightUnit;

    @Field("position")
    private Integer position;

    @Field("title")
    private String title;

    @Field("grams")
    private Double grams;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getImageId() {
        return imageId;
    }

    public void setImageId(String imageId) {
        this.imageId = imageId;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getCompareAtPrice() {
        return compareAtPrice;
    }

    public void setCompareAtPrice(Double compareAtPrice) {
        this.compareAtPrice = compareAtPrice;
    }

    public String getOption1() {
        return option1;
    }

    public void setOption1(String option1) {
        this.option1 = option1;
    }

    public String getOption2() {
        return option2;
    }

    public void setOption2(String option2) {
        this.option2 = option2;
    }

    public String getOption3() {
        return option3;
    }

    public void setOption3(String option3) {
        this.option3 = option3;
    }

    public boolean isTaxable() {
        return taxable;
    }

    public void setTaxable(boolean taxable) {
        this.taxable = taxable;
    }

    public String getInventoryManagement() {
        return inventoryManagement;
    }

    public void setInventoryManagement(String inventoryManagement) {
        this.inventoryManagement = inventoryManagement;
    }

    public String getInventoryPolicy() {
        return inventoryPolicy;
    }

    public void setInventoryPolicy(String inventoryPolicy) {
        this.inventoryPolicy = inventoryPolicy;
    }

    public Double getInventoryQuantity() {
        return inventoryQuantity;
    }

    public void setInventoryQuantity(Double inventoryQuantity) {
        this.inventoryQuantity = inventoryQuantity;
    }

    public boolean isRequiresShipping() {
        return requiresShipping;
    }

    public void setRequiresShipping(boolean requiresShipping) {
        this.requiresShipping = requiresShipping;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public String getWeightUnit() {
        return weightUnit;
    }

    public void setWeightUnit(String weightUnit) {
        this.weightUnit = weightUnit;
    }

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Double getGrams() {
        return grams;
    }

    public void setGrams(Double grams) {
        this.grams = grams;
    }
}
