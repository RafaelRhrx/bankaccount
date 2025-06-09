package com.borges.bankaccount.controllers;


import com.borges.bankaccount.dto.AccountDTO;
import com.borges.bankaccount.model.Account;
import com.borges.bankaccount.service.AccountService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/contas")
public class AccountController {

    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping
    public ResponseEntity<Account> openAccount(@RequestBody AccountDTO dto) {
        Account account = accountService.openAccount(dto);
        return ResponseEntity.ok(account);
    }
}
