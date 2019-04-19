package vn.sapo.sync.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serializable;

@Document(collection = "payment_detail")
public class PaymentDetail extends AbstractEntity implements Serializable {

    @Id
    private String id;

    @Field("credit_card_bin")
    @JsonProperty("credit_card_bin")
    private String creditCardBin;

    @Field("avs_result_code")
    @JsonProperty("avs_result_code")
    private String avsResultCode;

    @Field("cvv_result_code")
    @JsonProperty("cvv_result_code")
    private String cvvResultCode;

    @Field("credit_card_number")
    @JsonProperty("credit_card_number")
    private String creditCardNumber;

    @Field("credit_card_company")
    @JsonProperty("credit_card_company")
    private String creditCardCompany;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCreditCardBin() {
        return creditCardBin;
    }

    public void setCreditCardBin(String creditCardBin) {
        this.creditCardBin = creditCardBin;
    }

    public String getAvsResultCode() {
        return avsResultCode;
    }

    public void setAvsResultCode(String avsResultCode) {
        this.avsResultCode = avsResultCode;
    }

    public String getCvvResultCode() {
        return cvvResultCode;
    }

    public void setCvvResultCode(String cvvResultCode) {
        this.cvvResultCode = cvvResultCode;
    }

    public String getCreditCardNumber() {
        return creditCardNumber;
    }

    public void setCreditCardNumber(String creditCardNumber) {
        this.creditCardNumber = creditCardNumber;
    }

    public String getCreditCardCompany() {
        return creditCardCompany;
    }

    public void setCreditCardCompany(String creditCardCompany) {
        this.creditCardCompany = creditCardCompany;
    }
}
