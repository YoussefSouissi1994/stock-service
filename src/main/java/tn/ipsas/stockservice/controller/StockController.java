package tn.ipsas.stockservice.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import tn.ipsas.coremodels.models.reglement.Reglement;
import tn.ipsas.coremodels.models.stock.Stock;
import tn.ipsas.stockservice.service.StockService;

@RestController
@RequestMapping
public class StockController {
    private final StockService service;

    public StockController(StockService service) {
        this.service = service;
    }
    @GetMapping
    public Page<Stock> page(Pageable pageable) {
        return service.getAll(pageable);
    }
    @GetMapping("{id}")
    public Stock byId(@PathVariable("id") String id) {
        return service.getById(id);
    }
    @PutMapping
    public Stock add(@RequestBody Stock stock) {
        stock.setId(null);
        return service.save(stock);
    }
    @PutMapping("{id}")
    public Stock update(@PathVariable("id") String id, @RequestBody Stock stock) {
        if (!service.exists(id)) {
            throw new IllegalArgumentException();
        }
        stock.setId(id);
        return service.save(stock);
    }
    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") String id) {
        if (!service.exists(id)) {
            throw new IllegalArgumentException();
        }
        service.delete(id);
    }

}
