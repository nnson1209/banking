package com.shark.sharkbank.account.dtos;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.shark.sharkbank.auth_users.dtos.UserDTO;
import com.shark.sharkbank.auth_users.entity.User;
import com.shark.sharkbank.enums.AccountStatus;
import com.shark.sharkbank.enums.AccountType;
import com.shark.sharkbank.enums.Currency;
import com.shark.sharkbank.transaction.entity.Transaction;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@AllArgsConstructor
@NoArgsConstructor
public class AccountDTO {

    private Long id;

    private String accountNumber;

    private BigDecimal balance;

    private AccountType accountType;

    private Currency currency;

    private AccountStatus status;

    @JsonBackReference
    private UserDTO user;

    @JsonManagedReference
    private List<TransactionDTO> transactions;

    private LocalDateTime closedAt;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
