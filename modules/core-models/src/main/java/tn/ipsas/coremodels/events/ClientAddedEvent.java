package tn.ipsas.coremodels.events;

import org.springframework.context.ApplicationEvent;
import tn.ipsas.coremodels.models.client.Client;

import java.time.Clock;

public class ClientAddedEvent extends ApplicationEvent {
    public ClientAddedEvent(Client source) {
        super(source);
    }

    public ClientAddedEvent(Client source, Clock clock) {
        super(source, clock);
    }
}
