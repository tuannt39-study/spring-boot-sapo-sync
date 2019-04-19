package vn.sapo.sync.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Document(collection = "product")
public class Product extends AbstractEntity implements Serializable {

    @Id
    private String id;

    @Field("name")
    private String name;

    @Field("alias")
    private String alias;

    @Field("vendor")
    private String vendor;

    @Field("product_type")
    @JsonProperty("product_type")
    private String productType;

    @Field("meta_title")
    @JsonProperty("meta_title")
    private String metaTitle;

    @Field("meta_description")
    @JsonProperty("meta_description")
    private String metaDescription;

    @Field("summary")
    private String summary;

    @Field("published_on")
    @JsonProperty("published_on")
    private Date publishedOn;

    @Field("template_layout")
    @JsonProperty("template_layout")
    private String templateLayout;

    @Field("content")
    private String content;

    @Field("tags")
    private String tags;

    @Field("image")
    private Image image;

    @Field("images")
    private List<Image> images;

    @Field("variants")
    private List<Variant> variants;

    @Field("options")
    private List<Option> options;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public String getMetaTitle() {
        return metaTitle;
    }

    public void setMetaTitle(String metaTitle) {
        this.metaTitle = metaTitle;
    }

    public String getMetaDescription() {
        return metaDescription;
    }

    public void setMetaDescription(String metaDescription) {
        this.metaDescription = metaDescription;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public Date getPublishedOn() {
        return publishedOn;
    }

    public void setPublishedOn(Date publishedOn) {
        this.publishedOn = publishedOn;
    }

    public String getTemplateLayout() {
        return templateLayout;
    }

    public void setTemplateLayout(String templateLayout) {
        this.templateLayout = templateLayout;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public List<Image> getImages() {
        return images;
    }

    public void setImages(List<Image> images) {
        this.images = images;
    }

    public List<Variant> getVariants() {
        return variants;
    }

    public void setVariants(List<Variant> variants) {
        this.variants = variants;
    }

    public List<Option> getOptions() {
        return options;
    }

    public void setOptions(List<Option> options) {
        this.options = options;
    }

}
