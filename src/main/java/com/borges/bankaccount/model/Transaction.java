package com.borges.bankaccount.model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Account accountSender;

    @ManyToOne
    private Account accountReceiver;

    @Column(nullable = false)
    private BigDecimal value;

    @Column(nullable = false)
    private LocalDateTime date;

    @Column(nullable = false)
    private Boolean reversal = false;

    public void setAccountSender(Account accountSender) {
        this.accountSender = accountSender;
    }

    public void setAccountReceiver(Account accountReceiver) {
        this.accountReceiver = accountReceiver;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }
    

    public void setReversal(Boolean reversal) {
        this.reversal = reversal;
    }

    public boolean isReversal() {
        return reversal;
    }

    public Account getAccountReceiver() {
        return accountReceiver;
    }

    public Account getAccountSender() {
        return accountSender;
    }

    public BigDecimal getValue() {
        return value;
    }
}
