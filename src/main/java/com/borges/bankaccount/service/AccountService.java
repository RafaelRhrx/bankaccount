package com.borges.bankaccount.service;


import com.borges.bankaccount.repository.AccountRepository;
import com.borges.bankaccount.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {
    @Autowired
    private AccountRepository accountRepo;

    @Autowired
    private TransactionRepository transactionRepo;

    @Autowired
    private NotifyService notifyService;

}
