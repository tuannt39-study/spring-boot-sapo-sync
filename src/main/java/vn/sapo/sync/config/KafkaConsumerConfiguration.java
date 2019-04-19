package vn.sapo.sync.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.kafka.ConcurrentKafkaListenerContainerFactoryConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.listener.DeadLetterPublishingRecoverer;
import org.springframework.kafka.listener.SeekToCurrentErrorHandler;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.kafka.support.converter.RecordMessageConverter;
import org.springframework.kafka.support.converter.StringJsonMessageConverter;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;

@Configuration
public class KafkaConsumerConfiguration {

    private final Logger logger = LoggerFactory.getLogger(KafkaConsumerConfiguration.class);

    @Bean
    public ConcurrentKafkaListenerContainerFactory<Object, Object> kafkaListenerContainerFactory(ConcurrentKafkaListenerContainerFactoryConfigurer configurer, ConsumerFactory<Object, Object> kafkaConsumerFactory, KafkaTemplate<Object, Object> template) {
        ConcurrentKafkaListenerContainerFactory<Object, Object> factory = new ConcurrentKafkaListenerContainerFactory<>();
        configurer.configure(factory, kafkaConsumerFactory);
        factory.setErrorHandler(new SeekToCurrentErrorHandler(new DeadLetterPublishingRecoverer(template), 3));
        return factory;
    }

    @Bean
    public RecordMessageConverter converter() {
        return new StringJsonMessageConverter();
    }

    @Bean
    public NewTopic saveProduct() {
        return new NewTopic("products.save", 3, (short) 1);
    }

    @Bean
    public NewTopic deleteProduct() {
        return new NewTopic("products.delete", 3, (short) 1);
    }

    @KafkaListener(id = "product", topics = "products.save")
    public void listenProductSave(@Payload ConsumerRecord record, @Header(KafkaHeaders.RECEIVED_PARTITION_ID) int partition) {
        logger.info("Kafka topic {} from partition: {} - Object: {}", record.topic(), partition, record.value());
    }

    @KafkaListener(id = "product", topics = "products.delete")
    public void listenProductDelete(@Payload ConsumerRecord record, @Header(KafkaHeaders.RECEIVED_PARTITION_ID) int partition) {
        logger.info("Kafka topic {} from partition: {} - Object: {}", record.topic(), partition, record.value());
    }

}
