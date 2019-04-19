package vn.sapo.sync.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serializable;
import java.util.List;

@Document(collection = "shipping_line")
public class ShippingLine extends AbstractEntity implements Serializable {

    @Id
    private String id;

    @Field("title")
    private String title;

    @Field("price")
    private Double price;

    @Field("code")
    private String code;

    @Field("source")
    private String source;

    @Field("phone")
    private String phone;

    @Field("tax_lines")
    @JsonProperty("tax_lines")
    private List<String> taxLines;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public List<String> getTaxLines() {
        return taxLines;
    }

    public void setTaxLines(List<String> taxLines) {
        this.taxLines = taxLines;
    }
}
