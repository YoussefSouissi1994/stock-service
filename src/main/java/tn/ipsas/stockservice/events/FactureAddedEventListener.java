package tn.ipsas.stockservice.events;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import tn.ipsas.coremodels.events.FactureAddedEvent;
import tn.ipsas.coremodels.events.ProductAddedEvent;
import tn.ipsas.coremodels.models.facture.Facture;
import tn.ipsas.coremodels.models.produit.Product;
import tn.ipsas.stockservice.service.StockService;

@Component
public class FactureAddedEventListener implements ApplicationListener<FactureAddedEvent> {
    private final StockService stockService;

    public FactureAddedEventListener(StockService stockService) {
        this.stockService = stockService;
    }

    @Override
    public void onApplicationEvent(FactureAddedEvent event) {
        stockService.addFActure((Facture) event.getSource());
    }
}
