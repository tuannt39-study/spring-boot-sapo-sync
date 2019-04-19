package vn.sapo.sync.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import vn.sapo.sync.domain.Order;

import java.io.Serializable;
import java.util.List;

public class Orders implements Serializable {

    @JsonProperty("orders")
    private List<Order> lstOrder;

    public List<Order> getLstOrder() {
        return lstOrder;
    }

    public void setLstOrder(List<Order> lstOrder) {
        this.lstOrder = lstOrder;
    }
}
