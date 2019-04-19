package vn.sapo.sync.dto;

import vn.sapo.sync.domain.Webhook;

import java.io.Serializable;

public class WebhookDTO implements Serializable {

    private Webhook webhook;

    public Webhook getWebhook() {
        return webhook;
    }

    public void setWebhook(Webhook webhook) {
        this.webhook = webhook;
    }
}
