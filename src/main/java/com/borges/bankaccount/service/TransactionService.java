package com.borges.bankaccount.service;

import com.borges.bankaccount.dto.TransactionDTO;
import com.borges.bankaccount.model.Account;
import com.borges.bankaccount.model.AccountStatus;
import com.borges.bankaccount.model.Transaction;
import com.borges.bankaccount.repository.AccountRepository;
import com.borges.bankaccount.repository.TransactionRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Service
public class TransactionService {

    private final AccountRepository accountRepository;
    private final TransactionRepository transactionRepository;
    private final NotificationService notificationService;

    public TransactionService(AccountRepository accountRepository,
                              TransactionRepository transactionRepository,
                              NotificationService notificationService) {
        this.accountRepository = accountRepository;
        this.transactionRepository = transactionRepository;
        this.notificationService = notificationService;
    }

    @Transactional
    public void transfer(TransactionDTO dto) {
        Account sender = accountRepository.findById(dto.senderId())
                .orElseThrow(() -> new RuntimeException("Conta origem não encontrada"));

        Account receiver = accountRepository.findById(dto.receiverId())
                .orElseThrow(() -> new RuntimeException("Conta destino não encontrada"));

        if (!AccountStatus.ACTIVE.equals(sender.getStatus()) || !AccountStatus.ACTIVE.equals(receiver.getStatus())) {
            throw new RuntimeException("Conta(s) inativa(s).");
        }

        BigDecimal value = dto.value();

        if (sender.getBalance().compareTo(value) < 0) {
            throw new RuntimeException("Saldo insuficiente.");
        }

        sender.setBalance(sender.getBalance().subtract(value));
        receiver.setBalance(receiver.getBalance().add(value));

        accountRepository.save(sender);
        accountRepository.save(receiver);

        Transaction transaction = new Transaction();
        transaction.setAccountSender(sender);
        transaction.setAccountReceiver(receiver);
        transaction.setValue(value);
        transaction.setCreatedAt(LocalDateTime.now());

        transactionRepository.save(transaction);
        notificationService.notifyMessage();

    }

    @Transactional
    public void revertTransaction(Long id) {
        Transaction transaction = transactionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Transferência não encontrada"));

        if  (transaction.isReversal()) {
            throw new RuntimeException("Transferência já foi revertida");
        }

        Account sender = transaction.getAccountSender();
        Account receiver = transaction.getAccountReceiver();
        BigDecimal value = transaction.getValue();

        if (receiver.getBalance().compareTo(value) < 0) {
            throw new RuntimeException("Saldo insuficiente na conta de destino para reverter");
        }

        receiver.setBalance(receiver.getBalance().subtract(value));
        sender.setBalance(sender.getBalance().add(value));

        accountRepository.save(sender);
        accountRepository.save(receiver);

        transaction.setReversal(true);
        transactionRepository.save(transaction);
    }


}
