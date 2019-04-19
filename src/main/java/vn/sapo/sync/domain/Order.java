package vn.sapo.sync.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Document(collection = "oder")
public class Order extends AbstractEntity implements Serializable {

    @Id
    private String id;

    @Field("email")
    private String email;

    @Field("closed_on")
    @JsonProperty("closed_on")
    private String closedOn;

    @Field("number")
    private Integer number;

    @Field("note")
    private String note;

    @Field("token")
    private String token;

    @Field("gateway")
    private String gateway;

    @Field("test")
    private boolean test;

    @Field("total_price")
    @JsonProperty("total_price")
    private Double totalPrice;

    @Field("subtotal_price")
    @JsonProperty("subtotal_price")
    private Double subtotalPrice;

    @Field("total_weight")
    @JsonProperty("total_weight")
    private Double totalWeight;

    @Field("total_tax")
    @JsonProperty("total_tax")
    private Double totalTax;

    @Field("taxes_included")
    @JsonProperty("taxes_included")
    private boolean taxesIncluded;

    @Field("currency")
    private String currency;

    @Field("financial_status")
    @JsonProperty("financial_status")
    private String financialStatus;

    @Field("confirmed")
    private boolean confirmed;

    @Field("total_discounts")
    @JsonProperty("total_discounts")
    private String totalDiscounts;

    @Field("total_line_items_price")
    @JsonProperty("total_line_items_price")
    private String totalLineItemsPrice;

    @Field("cart_token")
    @JsonProperty("cart_token")
    private String cartToken;

    @Field("buyer_accepts_marketing")
    @JsonProperty("buyer_accepts_marketing")
    private String buyerAcceptsMarketing;

    @Field("name")
    private String name;

    @Field("referring_site")
    @JsonProperty("referring_site")
    private String referringSite;

    @Field("landing_site")
    @JsonProperty("landing_site")
    private String landingSite;

    @Field("cancelled_on")
    @JsonProperty("cancelled_on")
    private String cancelledOn;

    @Field("cancel_reason")
    @JsonProperty("cancel_reason")
    private String cancelReason;

    @Field("total_price_usd")
    @JsonProperty("total_price_usd")
    private Double totalPriceUsd;

    @Field("checkout_token")
    @JsonProperty("checkout_token")
    private String checkoutToken;

    @Field("reference")
    private String reference;

    @Field("user_id")
    @JsonProperty("user_id")
    private String userId;

    @Field("location_id")
    @JsonProperty("location_id")
    private String locationId;

    @Field("source_identifier")
    @JsonProperty("source_identifier")
    private String sourceIdentifier;

    @Field("source_url")
    @JsonProperty("source_url")
    private String sourceUrl;

    @Field("processed_on")
    @JsonProperty("processed_on")
    private Date processedOn;

    @Field("device_id")
    @JsonProperty("device_id")
    private String deviceId;

    @Field("browser_ip")
    @JsonProperty("browser_ip")
    private String browserIp;

    @Field("landing_site_ref")
    @JsonProperty("landing_site_ref")
    private String landingSiteRef;

    @Field("order_number")
    @JsonProperty("order_number")
    private Integer orderNumber;

    @Field("discount_codes")
    @JsonProperty("discount_codes")
    private List<DiscountCode> discountCodes;

    @Field("note_attributes")
    @JsonProperty("note_attributes")
    private List<NoteAttribute> noteAttributes;

    @Field("payment_gateway_names")
    @JsonProperty("payment_gateway_names")
    private List<String> paymentGatewayNames;

    @Field("processing_method")
    @JsonProperty("processing_method")
    private String processingMethod;

    @Field("checkout_id")
    @JsonProperty("checkout_id")
    private String checkoutId;

    @Field("source_name")
    @JsonProperty("source_name")
    private String sourceName;

    @Field("fulfillment_status")
    @JsonProperty("fulfillment_status")
    private String fulfillmentStatus;

    @Field("tax_lines")
    @JsonProperty("tax_lines")
    private List<TaxLine> taxLines;

    @Field("tags")
    private String tags;

    @Field("contact_email")
    @JsonProperty("contact_email")
    private String contactEmail;

    @Field("line_items")
    @JsonProperty("line_items")
    private List<Item> lineItems;

    @Field("shipping_lines")
    @JsonProperty("shipping_lines")
    private List<ShippingLine> shippingLines;

    @Field("billing_address")
    @JsonProperty("billing_address")
    private Address billingAddress;

    @Field("shipping_address")
    @JsonProperty("shipping_address")
    private Address shippingAddress;

    @Field("fulfillments")
    @JsonProperty("fulfillments")
    private List<Fulfillment> fulfillments;

    @Field("client_details")
    @JsonProperty("client_details")
    private List<ClientDetail> clientDetails;

    @Field("refunds")
    @JsonProperty("refunds")
    private List<Refund> refunds;

    @Field("payment_details")
    @JsonProperty("payment_details")
    private PaymentDetail paymentDetails;

    @Field("customer")
    private Customer customer;

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

    public String getClosedOn() {
        return closedOn;
    }

    public void setClosedOn(String closedOn) {
        this.closedOn = closedOn;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getGateway() {
        return gateway;
    }

    public void setGateway(String gateway) {
        this.gateway = gateway;
    }

    public boolean isTest() {
        return test;
    }

    public void setTest(boolean test) {
        this.test = test;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Double getSubtotalPrice() {
        return subtotalPrice;
    }

    public void setSubtotalPrice(Double subtotalPrice) {
        this.subtotalPrice = subtotalPrice;
    }

    public Double getTotalWeight() {
        return totalWeight;
    }

    public void setTotalWeight(Double totalWeight) {
        this.totalWeight = totalWeight;
    }

    public Double getTotalTax() {
        return totalTax;
    }

    public void setTotalTax(Double totalTax) {
        this.totalTax = totalTax;
    }

    public boolean isTaxesIncluded() {
        return taxesIncluded;
    }

    public void setTaxesIncluded(boolean taxesIncluded) {
        this.taxesIncluded = taxesIncluded;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getFinancialStatus() {
        return financialStatus;
    }

    public void setFinancialStatus(String financialStatus) {
        this.financialStatus = financialStatus;
    }

    public boolean isConfirmed() {
        return confirmed;
    }

    public void setConfirmed(boolean confirmed) {
        this.confirmed = confirmed;
    }

    public String getTotalDiscounts() {
        return totalDiscounts;
    }

    public void setTotalDiscounts(String totalDiscounts) {
        this.totalDiscounts = totalDiscounts;
    }

    public String getTotalLineItemsPrice() {
        return totalLineItemsPrice;
    }

    public void setTotalLineItemsPrice(String totalLineItemsPrice) {
        this.totalLineItemsPrice = totalLineItemsPrice;
    }

    public String getCartToken() {
        return cartToken;
    }

    public void setCartToken(String cartToken) {
        this.cartToken = cartToken;
    }

    public String getBuyerAcceptsMarketing() {
        return buyerAcceptsMarketing;
    }

    public void setBuyerAcceptsMarketing(String buyerAcceptsMarketing) {
        this.buyerAcceptsMarketing = buyerAcceptsMarketing;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getReferringSite() {
        return referringSite;
    }

    public void setReferringSite(String referringSite) {
        this.referringSite = referringSite;
    }

    public String getLandingSite() {
        return landingSite;
    }

    public void setLandingSite(String landingSite) {
        this.landingSite = landingSite;
    }

    public String getCancelledOn() {
        return cancelledOn;
    }

    public void setCancelledOn(String cancelledOn) {
        this.cancelledOn = cancelledOn;
    }

    public String getCancelReason() {
        return cancelReason;
    }

    public void setCancelReason(String cancelReason) {
        this.cancelReason = cancelReason;
    }

    public Double getTotalPriceUsd() {
        return totalPriceUsd;
    }

    public void setTotalPriceUsd(Double totalPriceUsd) {
        this.totalPriceUsd = totalPriceUsd;
    }

    public String getCheckoutToken() {
        return checkoutToken;
    }

    public void setCheckoutToken(String checkoutToken) {
        this.checkoutToken = checkoutToken;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getLocationId() {
        return locationId;
    }

    public void setLocationId(String locationId) {
        this.locationId = locationId;
    }

    public String getSourceIdentifier() {
        return sourceIdentifier;
    }

    public void setSourceIdentifier(String sourceIdentifier) {
        this.sourceIdentifier = sourceIdentifier;
    }

    public String getSourceUrl() {
        return sourceUrl;
    }

    public void setSourceUrl(String sourceUrl) {
        this.sourceUrl = sourceUrl;
    }

    public Date getProcessedOn() {
        return processedOn;
    }

    public void setProcessedOn(Date processedOn) {
        this.processedOn = processedOn;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getBrowserIp() {
        return browserIp;
    }

    public void setBrowserIp(String browserIp) {
        this.browserIp = browserIp;
    }

    public String getLandingSiteRef() {
        return landingSiteRef;
    }

    public void setLandingSiteRef(String landingSiteRef) {
        this.landingSiteRef = landingSiteRef;
    }

    public Integer getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(Integer orderNumber) {
        this.orderNumber = orderNumber;
    }

    public List<DiscountCode> getDiscountCodes() {
        return discountCodes;
    }

    public void setDiscountCodes(List<DiscountCode> discountCodes) {
        this.discountCodes = discountCodes;
    }

    public List<NoteAttribute> getNoteAttributes() {
        return noteAttributes;
    }

    public void setNoteAttributes(List<NoteAttribute> noteAttributes) {
        this.noteAttributes = noteAttributes;
    }

    public List<String> getPaymentGatewayNames() {
        return paymentGatewayNames;
    }

    public void setPaymentGatewayNames(List<String> paymentGatewayNames) {
        this.paymentGatewayNames = paymentGatewayNames;
    }

    public String getProcessingMethod() {
        return processingMethod;
    }

    public void setProcessingMethod(String processingMethod) {
        this.processingMethod = processingMethod;
    }

    public String getCheckoutId() {
        return checkoutId;
    }

    public void setCheckoutId(String checkoutId) {
        this.checkoutId = checkoutId;
    }

    public String getSourceName() {
        return sourceName;
    }

    public void setSourceName(String sourceName) {
        this.sourceName = sourceName;
    }

    public String getFulfillmentStatus() {
        return fulfillmentStatus;
    }

    public void setFulfillmentStatus(String fulfillmentStatus) {
        this.fulfillmentStatus = fulfillmentStatus;
    }

    public List<TaxLine> getTaxLines() {
        return taxLines;
    }

    public void setTaxLines(List<TaxLine> taxLines) {
        this.taxLines = taxLines;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public String getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }

    public List<Item> getLineItems() {
        return lineItems;
    }

    public void setLineItems(List<Item> lineItems) {
        this.lineItems = lineItems;
    }

    public List<ShippingLine> getShippingLines() {
        return shippingLines;
    }

    public void setShippingLines(List<ShippingLine> shippingLines) {
        this.shippingLines = shippingLines;
    }

    public Address getBillingAddress() {
        return billingAddress;
    }

    public void setBillingAddress(Address billingAddress) {
        this.billingAddress = billingAddress;
    }

    public Address getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(Address shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public List<Fulfillment> getFulfillments() {
        return fulfillments;
    }

    public void setFulfillments(List<Fulfillment> fulfillments) {
        this.fulfillments = fulfillments;
    }

    public List<ClientDetail> getClientDetails() {
        return clientDetails;
    }

    public void setClientDetails(List<ClientDetail> clientDetails) {
        this.clientDetails = clientDetails;
    }

    public List<Refund> getRefunds() {
        return refunds;
    }

    public void setRefunds(List<Refund> refunds) {
        this.refunds = refunds;
    }

    public PaymentDetail getPaymentDetails() {
        return paymentDetails;
    }

    public void setPaymentDetails(PaymentDetail paymentDetails) {
        this.paymentDetails = paymentDetails;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
