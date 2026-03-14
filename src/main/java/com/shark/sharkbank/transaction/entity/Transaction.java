package com.shark.sharkbank.transaction.entity;

import com.shark.sharkbank.account.entity.Account;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "transactions")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double amount;
    private String transactionType;
    private LocalDateTime transactionDate = LocalDateTime.now();
    private String description;
    private String status; // SUCCESS, FAILED, PENDING

    @ManyToOne
    @JoinColumn(name = "account_id")
    private Account account;

    private String sourceAccount;
    private String destinationAccount;
}
