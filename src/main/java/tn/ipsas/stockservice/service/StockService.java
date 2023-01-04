package tn.ipsas.stockservice.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import tn.ipsas.coremodels.exceptions.EntityNotFoundException;
import tn.ipsas.coremodels.models.stock.Stock;
import tn.ipsas.stockservice.data.StockRepository;

@Service
public class StockService {
    private final StockRepository repository;

    public StockService(StockRepository repository) {
        this.repository = repository;
    }
    public Page<Stock> getAll(Pageable pageable) {
        return repository.findAll(pageable);
    }
    public Stock getById(String id) {
        return repository.findById(id).orElseThrow(() -> new EntityNotFoundException(id));
    }
    public Stock save(Stock stock) {
        Stock stockSaved = repository.save(stock);
        return stockSaved;
    }
    public void delete(String id) {
        Stock stock = repository.findById(id).orElseThrow(() -> new EntityNotFoundException(id));
        repository.deleteById(id);
    }
    public boolean exists(String id) {
        return repository.existsById(id);
    }

}
