package com.borges.bankaccount.dto;

import com.borges.bankaccount.model.UserType;

public record UserDTO(String name, String document, String adress, String password, UserType type) {
}
