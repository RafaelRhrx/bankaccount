package com.borges.bankaccount.dto;

import com.borges.bankaccount.model.CustomerType;

public record CustomerDTO(String name, String document, String address, String password, CustomerType type) {

}
