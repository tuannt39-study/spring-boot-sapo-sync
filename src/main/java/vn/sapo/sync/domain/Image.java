package vn.sapo.sync.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serializable;
import java.util.List;

@Document(collection = "image")
public class Image extends AbstractEntity implements Serializable {

    @Id
    private String id;

    @Field("size")
    private String size;

    @Field("product_id")
    @JsonProperty("product_id")
    private String productId;

    @Field("position")
    private Integer position;

    @Field("src")
    private String src;

    @Field("alt")
    private String alt;

    @Field("filename")
    private String filename;

    @Field("width")
    private Integer width;

    @Field("height")
    private Integer height;

    @JsonProperty("variant_ids")
    private List<String> variantIds;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    public String getAlt() {
        return alt;
    }

    public void setAlt(String alt) {
        this.alt = alt;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public List<String> getVariantIds() {
        return variantIds;
    }

    public void setVariantIds(List<String> variantIds) {
        this.variantIds = variantIds;
    }
}
