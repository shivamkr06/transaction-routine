package com.transaction.routine.repository;

import com.transaction.routine.model.OperationType;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OperationTypeRepository extends JpaRepository<OperationType, Long> {
	
	Optional<OperationType> findById(Long operationTypeId);
}


