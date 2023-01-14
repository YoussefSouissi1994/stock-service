package tn.ipsas.stockservice.events;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import tn.ipsas.coremodels.events.ProductAddedEvent;
import tn.ipsas.coremodels.events.ProductRemovedEvent;
import tn.ipsas.coremodels.models.produit.Product;
import tn.ipsas.stockservice.service.StockService;

@Component
public class ProductRemovedEventListener implements ApplicationListener<ProductRemovedEvent> {
    private final StockService stockService;

    public ProductRemovedEventListener(StockService stockService) {
        this.stockService = stockService;
    }

    @Override
    public void onApplicationEvent(ProductRemovedEvent event) {
        stockService.delete((Product) event.getSource());
    }
}
