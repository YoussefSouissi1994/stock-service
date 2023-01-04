package tn.ipsas.coremodels.models.reglement;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import tn.ipsas.coremodels.models.client.Client;
import tn.ipsas.coremodels.models.facture.Facture;

import java.util.Date;
import java.util.List;

public class Reglement {
    @Id
    private String id;
    private Double amount;
    private Date date;
    @DBRef
    private List<Facture> factures;
    @DBRef
    private Client client;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public List<Facture> getFacture() {
        return factures;
    }

    public void setFacture(List<Facture> factures) {
        this.factures = factures;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
