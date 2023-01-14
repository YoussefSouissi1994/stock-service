package tn.ipsas.stockservice.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import tn.ipsas.coremodels.exceptions.EntityNotFoundException;
import tn.ipsas.coremodels.models.facture.Facture;
import tn.ipsas.coremodels.models.produit.Product;
import tn.ipsas.coremodels.models.stock.Stock;
import tn.ipsas.stockservice.data.StockRepository;

@Service
public class StockService {
    private final StockRepository repository;

    public StockService(StockRepository repository) {
        this.repository = repository;
    }
    public Page<Stock> getAll(Pageable pageable, int rupture) {
        if (rupture == -1) {
            return repository.findAll(pageable);
        } else {
            return repository.findAllByQuantityLessThanEqual(rupture, pageable);
        }
    }
    public Stock getById(String id) {
        return repository.findById(id).orElseThrow(() -> new EntityNotFoundException(id));
    }
    public Stock save(Stock stock) {
        Stock stockSaved = repository.save(stock);
        return stockSaved;
    }

    public Stock create(Product product) {
        Stock stockSaved = new Stock();
        stockSaved.setProduct(product);
        stockSaved = repository.save(stockSaved);
        return stockSaved;
    }

    public void addFActure(Facture facture) {
        facture.getItems().forEach(factureItem -> {
            Stock stock = repository.findByProduct(factureItem.getProduct());
            stock.setQuantity(stock.getQuantity() - factureItem.getQuantity());
            repository.save(stock);
        });
    }
    public void delete(Product product) {
        repository.deleteByProduct(product);
    }
    public boolean exists(String id) {
        return repository.existsById(id);
    }

    public boolean check(Stock stock) {
        Stock byProduct = repository.findByProduct(stock.getProduct());
        return byProduct.getQuantity() >= stock.getQuantity();
    }
}
