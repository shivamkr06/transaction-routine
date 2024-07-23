package com.transaction.routine.service;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.transaction.routine.model.Account;
import com.transaction.routine.model.OperationType;
import com.transaction.routine.model.Transaction;
import com.transaction.routine.model.TransactionRequest;
import com.transaction.routine.repository.AccountRepository;
import com.transaction.routine.repository.OperationTypeRepository;
import com.transaction.routine.repository.TransactionRepository;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;
    
    @Autowired
    private AccountRepository accountRepository;
    
    @Autowired
    private OperationTypeRepository operationTypeRepository;

    public Transaction createTransaction(TransactionRequest transactionRequest) {
    	Optional<OperationType> opsType = operationTypeRepository.findById(transactionRequest.getOperationTypeId());
    	if(!opsType.isPresent()) {
    		throw new RuntimeException("Invalid Operation type");
    	}
    	Optional<Account> acc = accountRepository.findById(transactionRequest.getAccountId());
    	if(!acc.isPresent()) {
    		throw new RuntimeException("Account already exist");
    	}
    	Transaction transaction = new Transaction();
    	
    	transaction.setAccount(acc.get());
    	transaction.setEventDate(LocalDateTime.now());
    	transaction.setAmount(transactionRequest.getAmount());
    	transaction.setOperationType(opsType.get());
        return transactionRepository.save(transaction);
    }
}

