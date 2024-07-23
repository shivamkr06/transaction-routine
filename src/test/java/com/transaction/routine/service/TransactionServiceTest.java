package com.transaction.routine.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.transaction.routine.model.Account;
import com.transaction.routine.model.OperationType;
import com.transaction.routine.model.Transaction;
import com.transaction.routine.model.TransactionRequest;
import com.transaction.routine.repository.AccountRepository;
import com.transaction.routine.repository.OperationTypeRepository;
import com.transaction.routine.repository.TransactionRepository;

public class TransactionServiceTest {

    @Mock
    private TransactionRepository transactionRepository;

    @Mock
    private AccountRepository accountRepository;

    @Mock
    private OperationTypeRepository operationTypeRepository;

    @InjectMocks
    private TransactionService transactionService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCreateTransaction() {
        Account account = new Account();
        account.setAccountId(1L);
        account.setDocumentNumber("12345678900");

        OperationType operationType = new OperationType(1, "Normal Purchase");

        TransactionRequest transactionRequest = new TransactionRequest();
        transactionRequest.setAccountId(1L);
        transactionRequest.setOperationTypeId(1);
        transactionRequest.setAmount(100.0);

        Transaction txn = new Transaction();
        txn.setAccount(account);
        txn.setAmount(100.0);
        txn.setOperationType(operationType);
        
        when(accountRepository.findById(1L)).thenReturn(Optional.of(account));
        when(operationTypeRepository.findById(1)).thenReturn(Optional.of(operationType));
        when(transactionRepository.save(any(Transaction.class))).thenReturn(txn);

        Transaction transaction = transactionService.createTransaction(transactionRequest);

        assertNotNull(transaction);
        assertEquals(1L, transaction.getAccount().getAccountId());
        assertEquals(1, transaction.getOperationType().getOperationTypeId());
        assertEquals(100.0, transaction.getAmount());
    }
}
