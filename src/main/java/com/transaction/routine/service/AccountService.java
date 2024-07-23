package com.transaction.routine.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.transaction.routine.model.Account;
import com.transaction.routine.repository.AccountRepository;

import java.util.Optional;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    public Account createAccount(Account account) {
    	Optional<Account> acc = accountRepository.findById(account.getAccountId());
    	if(acc.isPresent()) {
    		throw new RuntimeException("Account already exist");
    	}
        return accountRepository.save(account);
    }

    public Optional<Account> getAccount(Long accountId) {
    	Optional<Account> acc = accountRepository.findById(accountId);
    	if(!acc.isPresent()) {
    		throw new RuntimeException("Account Doesn't exist");
    	}
    	return acc;
    }
}
