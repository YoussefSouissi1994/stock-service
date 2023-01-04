package tn.ipsas.stockservice.data;

import org.springframework.data.mongodb.repository.MongoRepository;
import tn.ipsas.coremodels.models.stock.Stock;

public interface StockRepository extends MongoRepository<Stock, String> {
}
