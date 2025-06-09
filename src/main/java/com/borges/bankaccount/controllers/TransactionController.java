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
    public ResponseEntity<String> transfer(@RequestBody TransactionDTO dto) {
        transactionService.transfer(dto);
        return ResponseEntity.ok("Transferência feita com sucesso");
    }

    @PostMapping("/{id}/reversal")
    public ResponseEntity<String> reversal(@PathVariable Long id) {
        transactionService.revertTransaction(id);
        return ResponseEntity.ok("Transação revertida com sucesso");
    }
}
