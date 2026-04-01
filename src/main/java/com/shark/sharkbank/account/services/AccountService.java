package com.shark.sharkbank.account.services;

import com.shark.sharkbank.account.dtos.AccountDTO;
import com.shark.sharkbank.account.entity.Account;
import com.shark.sharkbank.auth_users.entity.User;
import com.shark.sharkbank.enums.AccountType;
import com.shark.sharkbank.res.Response;

import java.util.List;

public interface AccountService {
    Account createAccount(AccountType accountType, User user);

    Response<List<AccountDTO>> getMyAccounts();

    Response<?> closeAccount(String accountNumber);
}