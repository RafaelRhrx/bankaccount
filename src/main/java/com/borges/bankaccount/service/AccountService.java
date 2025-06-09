package com.borges.bankaccount.service;


import com.borges.bankaccount.dto.AccountDTO;
import com.borges.bankaccount.model.Account;
import com.borges.bankaccount.model.AccountStatus;
import com.borges.bankaccount.model.Customer;
import com.borges.bankaccount.repository.AccountRepository;
import com.borges.bankaccount.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class AccountService {

    private final AccountRepository accountRepository;
    private final CustomerRepository customerRepository;

    public AccountService(AccountRepository accountRepository, CustomerRepository customerRepository) {
        this.accountRepository = accountRepository;
        this.customerRepository = customerRepository;
    }

    public Account openAccount(AccountDTO dto) {
        Customer customer = customerRepository.findById(dto.id())
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));

        if (accountRepository.findByAgency(dto.agency()).isPresent()) {
            throw new RuntimeException("Agência já cadastrada");
        }

        Account account = new Account();
        account.setAgency(dto.agency());
        account.setStatus(dto.status() != null ? dto.status() : AccountStatus.ACTIVE);
        account.setBalance(dto.balance());
        account.setUser(customer);

        return accountRepository.save(account);
    }

}
