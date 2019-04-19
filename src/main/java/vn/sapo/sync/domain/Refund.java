package vn.sapo.sync.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serializable;
import java.util.List;

@Document(collection = "refund")
public class Refund extends AbstractEntity implements Serializable {

    @Id
    private String id;

    @Field("order_id")
    @JsonProperty("order_id")
    private String orderId;

    @Field("note")
    private String note;

    @Field("restock")
    private boolean restock;

    @Field("user_id")
    @JsonProperty("user_id")
    private String userId;

    @Field("refund_line_items")
    @JsonProperty("refund_line_items")
    private List<RefundLineItem> refundLineItems;

    @Field("transactions")
    private List<Transaction> transactions;

    @Field("order_adjustments")
    @JsonProperty("order_adjustments")
    private List<String> orderAdjustments;

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

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public boolean isRestock() {
        return restock;
    }

    public void setRestock(boolean restock) {
        this.restock = restock;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public List<RefundLineItem> getRefundLineItems() {
        return refundLineItems;
    }

    public void setRefundLineItems(List<RefundLineItem> refundLineItems) {
        this.refundLineItems = refundLineItems;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }

    public List<String> getOrderAdjustments() {
        return orderAdjustments;
    }

    public void setOrderAdjustments(List<String> orderAdjustments) {
        this.orderAdjustments = orderAdjustments;
    }
}
