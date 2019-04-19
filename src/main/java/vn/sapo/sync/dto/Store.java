package vn.sapo.sync.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class Store implements Serializable {

    @JsonProperty("store")
    private String storeName;

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }
}
