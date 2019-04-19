package vn.sapo.sync.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import vn.sapo.sync.domain.Customer;

import java.io.Serializable;
import java.util.List;

public class Customers implements Serializable {

    @JsonProperty("customers")
    private List<Customer> lstCustomer;

    public List<Customer> getLstCustomer() {
        return lstCustomer;
    }

    public void setLstCustomer(List<Customer> lstCustomer) {
        this.lstCustomer = lstCustomer;
    }
}
