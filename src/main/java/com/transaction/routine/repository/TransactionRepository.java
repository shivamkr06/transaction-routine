package com.transaction.routine.repository;

import com.transaction.routine.model.Transaction;

import jakarta.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {
	
	 @Transactional
	 default Transaction saveAndReturn(Transaction transaction) {
		 return save(transaction);
	 }
}

