package com.borges.bankaccount.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Entity
@Table(name="bank_transactions")
@AllArgsConstructor
@NoArgsConstructor
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name="account_sender")
    private Account accountSender;

    @ManyToOne
    @JoinColumn(name="account_receiver")
    private Account accountReceiver;

    @Column(name = "transaction_value")
    private BigDecimal value;


    private LocalDateTime createdAt;


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

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
    

    public void setReversal(Boolean reversal) {
        this.reversal = reversal;
    }

    public boolean isReversal() {
        return reversal;
    }

}
