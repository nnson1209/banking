package com.shark.sharkbank.transaction.dtos;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.shark.sharkbank.account.dtos.AccountDTO;
import com.shark.sharkbank.account.entity.Account;
import com.shark.sharkbank.enums.TransactionStatus;
import com.shark.sharkbank.enums.TransactionType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@AllArgsConstructor
@NoArgsConstructor
public class TransactionDTO {

    private Long id;

    private BigDecimal amount;

    private TransactionType transactionType;

    private LocalDateTime transactionDate;
    private String description;

    private TransactionStatus status;

    @JsonBackReference
    private AccountDTO account;

    private String sourceAccount;
    private String destinationAccount;
}
