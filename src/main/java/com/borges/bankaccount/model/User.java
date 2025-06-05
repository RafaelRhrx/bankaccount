package com.borges.bankaccount.model;

import jakarta.persistence.*;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true,nullable = false)
    private String document;

    @Column(nullable = false)
    private String name;
    private String address;
    private String password;
    private String email;


}
