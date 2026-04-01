package com.shark.sharkbank.transaction.services;

import com.shark.sharkbank.res.Response;
import com.shark.sharkbank.transaction.dtos.TransactionDTO;
import com.shark.sharkbank.transaction.dtos.TransactionRequest;

import java.util.List;

public interface TransactionService {
    Response<?>createTransaction(TransactionRequest transactionRequest);
    Response<List<TransactionDTO>> getTransactionsForMyAccount(String accountNumber, int page, int size);
}
