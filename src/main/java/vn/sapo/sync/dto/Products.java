package vn.sapo.sync.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import vn.sapo.sync.domain.Product;

import java.io.Serializable;
import java.util.List;

public class Products implements Serializable {

    @JsonProperty("products")
    private List<Product> lstProduct;

    public List<Product> getLstProduct() {
        return lstProduct;
    }

    public void setLstProduct(List<Product> lstProduct) {
        this.lstProduct = lstProduct;
    }
}
