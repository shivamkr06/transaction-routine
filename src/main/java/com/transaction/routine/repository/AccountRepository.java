package com.transaction.routine.repository;


import org.springframework.stereotype.Repository;

import com.transaction.routine.model.Account;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Repository
public class AccountRepository {

    private final Map<Long, Account> accounts = new HashMap<>();
    private long nextId = 1;

    public Account save(Account account) {
        account.setAccountId(nextId++);
        accounts.put(account.getAccountId(), account);
        return account;
    }

    public Optional<Account> findById(Long accountId) {
        return Optional.ofNullable(accounts.get(accountId));
    }
}

