package com.wellsfargo.counselor.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
public class Portfolio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long portfolioId;

    @OneToOne
    @JoinColumn(name = "client_id", nullable = false)
    private Client client;

    @Column(nullable = false)
    private String portfolioName;

    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date creationDate;

    @OneToMany(mappedBy = "portfolio", cascade = CascadeType.ALL)
    private Set<Security> securities;

    protected Portfolio() {
    }

    public Portfolio(Client client, String portfolioName, Date creationDate) {
        this.client = client;
        this.portfolioName = portfolioName;
        this.creationDate = creationDate;
    }

    public Long getPortfolioId() { return portfolioId; }

    public Client getClient() { return client; }
    public void setClient(Client client) { this.client = client; }

    public String getPortfolioName() { return portfolioName; }
    public void setPortfolioName(String portfolioName) { this.portfolioName = portfolioName; }

    public Date getCreationDate() { return creationDate; }
    public void setCreationDate(Date creationDate) { this.creationDate = creationDate; }

    public Set<Security> getSecurities() { return securities; }
    public void setSecurities(Set<Security> securities) { this.securities = securities; }
}
