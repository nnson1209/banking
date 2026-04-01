package com.shark.sharkbank.audit_dashboard.service;

import com.shark.sharkbank.account.dtos.AccountDTO;
import com.shark.sharkbank.auth_users.dtos.UserDTO;
import com.shark.sharkbank.transaction.dtos.TransactionDTO;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface AuditorService {

    Map<String, Long> getSystemTotals();

    Optional<UserDTO> findUserByEmail(String email);

    Optional<AccountDTO> findAccountDetailsByAccountNumber(String accountNumber);

    List<TransactionDTO> findTransactionsByAccountNumber(String accountNumber);

    Optional<TransactionDTO> findTransactionById(Long transactionId);
}