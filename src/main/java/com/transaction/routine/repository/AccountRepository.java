package com.transaction.routine.repository;


import com.transaction.routine.model.Account;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
	
	 Optional<Account> findById(Long accountId);
}


