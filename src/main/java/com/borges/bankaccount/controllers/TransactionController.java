package com.borges.bankaccount.controllers;

import com.borges.bankaccount.dto.TransactionDTO;
import com.borges.bankaccount.service.TransactionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/transferencias")
public class TransactionController {

    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @PostMapping
    public ResponseEntity<Void> transfer(@RequestBody TransactionDTO dto) {
        transactionService.transfer(dto);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/{id}/reversal")
    public ResponseEntity<Void> reversal(@PathVariable Long id) {
        transactionService.revertTransaction(id);
        return ResponseEntity.ok().build();
    }
}
