package vn.sapo.sync.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serializable;
import java.util.List;

@Document(collection = "customer")
public class Customer extends AbstractEntity implements Serializable {

    @Id
    private String id;

    @Field("email")
    private String email;

    @Field("phone")
    private String phone;

    @Field("first_name")
    @JsonProperty("first_name")
    private String firstName;

    @Field("last_name")
    @JsonProperty("last_name")
    private String lastName;

    @Field("accepts_marketing")
    @JsonProperty("accepts_marketing")
    private String acceptsMarketing;

    @Field("note")
    private String note;

    @Field("last_order_id")
    @JsonProperty("last_order_id")
    private String lastOrderId;

    @Field("last_order_name")
    @JsonProperty("last_order_name")
    private String lastOrderName;

    @Field("orders_count")
    @JsonProperty("orders_count")
    private String ordersCount;

    @Field("total_spent")
    @JsonProperty("total_spent")
    private String totalSpent;

    @Field("state")
    private String state;

    @Field("verified_email")
    @JsonProperty("verified_email")
    private String verifiedEmail;

    @Field("tags")
    private String tags;

    @Field("default_address")
    @JsonProperty("default_address")
    private Address defaultAddress;

    @Field("images")
    private List<Address> addresses;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAcceptsMarketing() {
        return acceptsMarketing;
    }

    public void setAcceptsMarketing(String acceptsMarketing) {
        this.acceptsMarketing = acceptsMarketing;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getLastOrderId() {
        return lastOrderId;
    }

    public void setLastOrderId(String lastOrderId) {
        this.lastOrderId = lastOrderId;
    }

    public String getLastOrderName() {
        return lastOrderName;
    }

    public void setLastOrderName(String lastOrderName) {
        this.lastOrderName = lastOrderName;
    }

    public String getOrdersCount() {
        return ordersCount;
    }

    public void setOrdersCount(String ordersCount) {
        this.ordersCount = ordersCount;
    }

    public String getTotalSpent() {
        return totalSpent;
    }

    public void setTotalSpent(String totalSpent) {
        this.totalSpent = totalSpent;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getVerifiedEmail() {
        return verifiedEmail;
    }

    public void setVerifiedEmail(String verifiedEmail) {
        this.verifiedEmail = verifiedEmail;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public Address getDefaultAddress() {
        return defaultAddress;
    }

    public void setDefaultAddress(Address defaultAddress) {
        this.defaultAddress = defaultAddress;
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }
}
