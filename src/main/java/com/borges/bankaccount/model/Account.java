package com.borges.bankaccount.model;

import jakarta.persistence.*;

@Entity
public class Account {

    @Id
    @GeneratedValue
    private Long id;

    @Column(unique = true)
    private String agency;

    @ManyToOne
    private User user;

    private Double saldo;
    private Boolean status;
}
