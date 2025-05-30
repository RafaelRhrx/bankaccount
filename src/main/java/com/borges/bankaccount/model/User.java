package com.borges.bankaccount.model;

import jakarta.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class User {

    @Id
    @GeneratedValue
    private Long id;

    @Column(unique = true,nullable = false)
    private String document;

    private String name;
    private String address;
    private String password;
}
