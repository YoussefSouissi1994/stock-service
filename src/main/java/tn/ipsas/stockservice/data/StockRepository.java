package tn.ipsas.stockservice.data;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import tn.ipsas.coremodels.models.produit.Product;
import tn.ipsas.coremodels.models.stock.Stock;

public interface StockRepository extends MongoRepository<Stock, String> {
    void deleteByProduct(Product product);
    Stock findByProduct(Product product);

    Page<Stock> findAllByQuantityLessThanEqual(int quantity, Pageable pageable);
}
