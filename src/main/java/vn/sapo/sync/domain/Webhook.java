package vn.sapo.sync.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serializable;

@Document(collection = "webhook")
public class Webhook extends AbstractEntity implements Serializable {

    @Id
    private String id;

    @Field("format")
    private String format;

    @Field("topic")
    private String topic;

    @Field("address")
    private String address;

    public Webhook() {
    }

    public Webhook(String format, String topic, String address) {
        this.format = format;
        this.topic = topic;
        this.address = address;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

}
