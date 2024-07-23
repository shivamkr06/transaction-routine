package com.transaction.routine.repository;


import org.springframework.stereotype.Repository;

import com.transaction.routine.model.Transaction;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class TransactionRepository {

    private final List<Transaction> transactions = new ArrayList<>();
    private long nextId = 1;

    public Transaction save(Transaction transaction) {
        transaction.setTransactionId(nextId++);
        transactions.add(transaction);
        return transaction;
    }

    public Optional<Transaction> findById(Long transactionId) {
        return transactions.stream().filter(t -> t.getTransactionId().equals(transactionId)).findFirst();
    }

    public List<Transaction> findAll() {
        return new ArrayList<>(transactions);
    }
}
