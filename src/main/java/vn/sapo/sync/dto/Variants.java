package vn.sapo.sync.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import vn.sapo.sync.domain.Variant;

import java.io.Serializable;
import java.util.List;

public class Variants implements Serializable {

    @JsonProperty("variants")
    private List<Variant> lstVariant;

    public List<Variant> getLstVariant() {
        return lstVariant;
    }

    public void setLstVariant(List<Variant> lstVariant) {
        this.lstVariant = lstVariant;
    }
}
