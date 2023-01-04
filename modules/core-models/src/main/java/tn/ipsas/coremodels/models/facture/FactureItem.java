package tn.ipsas.coremodels.models.facture;

import org.springframework.data.mongodb.core.mapping.DBRef;
import tn.ipsas.coremodels.models.produit.Product;

public class FactureItem {
    @DBRef
    private Product product;
    private int quantity;
    private int unitPrice;

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(int unitPrice) {
        this.unitPrice = unitPrice;
    }


    public double getTotal() {
        return unitPrice * quantity;
    }

}
