package com.borges.bankaccount.service;


import com.borges.bankaccount.dto.AccountDTO;
import com.borges.bankaccount.model.Account;
import com.borges.bankaccount.model.AccountStatus;
import com.borges.bankaccount.model.User;
import com.borges.bankaccount.repository.AccountRepository;
import com.borges.bankaccount.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class AccountService {

    private final AccountRepository accountRepository;
    private final UserRepository userRepository;

    public AccountService(AccountRepository accountRepository, UserRepository userRepository) {
        this.accountRepository = accountRepository;
        this.userRepository = userRepository;
    }

    public Account openAccount(AccountDTO dto) {
        User user = userRepository.findById(dto.userId())
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));

        if (accountRepository.findByAgency(dto.agency()).isPresent()) {
            throw new RuntimeException("Agência já cadastrada");
        }

        Account account = new Account();
        account.setAgency(dto.agency());
        account.setStatus(AccountStatus.ACTIVE);
        account.setBalance(BigDecimal.ZERO);
        account.setUser(user);

        return accountRepository.save(account);
    }

}
