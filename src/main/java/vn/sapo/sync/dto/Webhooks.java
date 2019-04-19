package vn.sapo.sync.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import vn.sapo.sync.domain.Webhook;

import java.io.Serializable;
import java.util.List;

public class Webhooks implements Serializable {

    @JsonProperty("webhooks")
    private List<Webhook> lstWebhook;

    public List<Webhook> getLstWebhook() {
        return lstWebhook;
    }

    public void setLstWebhook(List<Webhook> lstWebhook) {
        this.lstWebhook = lstWebhook;
    }
}
