package tn.ipsas.coremodels.kafka.listeners;

import tn.ipsas.coremodels.events.ClientAddedEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.KafkaListener;
import tn.ipsas.coremodels.models.client.Client;

@Configuration
public class KafkaListeners {

    private final ApplicationEventPublisher publisher;

    public KafkaListeners(ApplicationEventPublisher publisher) {
        this.publisher = publisher;
    }

    @KafkaListener(topics = "client_add")
    public void listenGroupFoo(Client client) {
        this.publisher.publishEvent(new ClientAddedEvent(client));
    }
}
