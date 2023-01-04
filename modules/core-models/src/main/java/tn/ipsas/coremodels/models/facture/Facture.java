package tn.ipsas.coremodels.models.facture;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import tn.ipsas.coremodels.models.client.Client;

import java.util.List;
import java.util.function.ToDoubleFunction;

public class Facture {
    @Id
    private String id;
    private String code;
    @DBRef
    private Client client;
    private List<FactureItem> items;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public List<FactureItem> getItems() {
        return items;
    }

    public void setItems(List<FactureItem> items) {
        this.items = items;
    }
    public double getTotal() {
        return items
                .stream()
                .mapToDouble(FactureItem::getTotal)
                .sum();

    }
}
