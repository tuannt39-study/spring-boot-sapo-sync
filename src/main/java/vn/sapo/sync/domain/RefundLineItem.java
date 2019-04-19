package vn.sapo.sync.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serializable;
import java.util.List;

@Document(collection = "refund_line_item")
public class RefundLineItem extends AbstractEntity implements Serializable {

    @Id
    private String id;

    @Field("quantity")
    private Double quantity;

    @Field("line_item_id")
    @JsonProperty("line_item_id")
    private String lineItemId;

    @Field("line_item")
    @JsonProperty("line_item")
    private List<Item> lineItem;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    public String getLineItemId() {
        return lineItemId;
    }

    public void setLineItemId(String lineItemId) {
        this.lineItemId = lineItemId;
    }

    public List<Item> getLineItem() {
        return lineItem;
    }

    public void setLineItem(List<Item> lineItem) {
        this.lineItem = lineItem;
    }
}
