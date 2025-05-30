package com.borges.bankaccount.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Transaction {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private Account sender;

    @ManyToOne
    private Account receiver;

    private Double valor;
    private Boolean reversal = false;
}
