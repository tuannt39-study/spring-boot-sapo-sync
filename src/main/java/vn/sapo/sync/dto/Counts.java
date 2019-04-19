package vn.sapo.sync.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class Counts implements Serializable {

    @JsonProperty("count")
    private Integer intCounts;

    public Integer getIntCounts() {
        return intCounts;
    }

    public void setIntCounts(Integer intCounts) {
        this.intCounts = intCounts;
    }
}
