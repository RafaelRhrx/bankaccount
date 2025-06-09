package com.borges.bankaccount.model;

import jakarta.persistence.*;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
@Entity
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String agency;

    @ManyToOne
    private Customer customer;

    @Column(nullable = false)
    private BigDecimal balance;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private AccountStatus status;

    public void setAgency(String agency) {
        this.agency = agency;
    }

    public void setStatus(AccountStatus status) {
        this.status = status;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public void setUser(Customer customer) {
        this.customer = customer;
    }

    public Account() {
        this.status = AccountStatus.ACTIVE;
    }

}
