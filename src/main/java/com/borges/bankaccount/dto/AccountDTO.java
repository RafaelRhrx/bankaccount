package com.borges.bankaccount.dto;

import com.borges.bankaccount.model.AccountStatus;

import java.math.BigDecimal;

public record AccountDTO(Long id, String agency, BigDecimal balance, AccountStatus status) {

}
