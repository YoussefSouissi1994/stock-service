package tn.ipsas.stockservice.events;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import tn.ipsas.coremodels.events.ProductAddedEvent;
import tn.ipsas.coremodels.models.produit.Product;
import tn.ipsas.stockservice.service.StockService;

@Component
public class ProductAddedEventListener implements ApplicationListener<ProductAddedEvent> {
    private final StockService stockService;

    public ProductAddedEventListener(StockService stockService) {
        this.stockService = stockService;
    }

    @Override
    public void onApplicationEvent(ProductAddedEvent event) {
        stockService.create((Product) event.getSource());
    }
}
