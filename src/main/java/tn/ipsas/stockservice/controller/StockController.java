package tn.ipsas.stockservice.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
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
    public Page<Stock> page(Pageable pageable,
                            @RequestParam(value = "rupture", required = false, defaultValue = "-1") int rupture) {
        return service.getAll(pageable, rupture);
    }
    @GetMapping("{id}")
    public Stock byId(@PathVariable("id") String id) {
        return service.getById(id);
    }

    @PutMapping("{id}")
    public Stock update(@PathVariable("id") String id, @RequestBody Stock stock) {
        if (!service.exists(id)) {
            throw new IllegalArgumentException();
        }
        stock.setId(id);
        return service.save(stock);
    }

    @PostMapping("check")
    public boolean check(@RequestBody Stock stock) {
        return service.check(stock);
    }


}
