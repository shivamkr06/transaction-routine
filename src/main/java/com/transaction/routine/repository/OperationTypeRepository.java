package com.transaction.routine.repository;


import org.springframework.stereotype.Repository;

import com.transaction.routine.model.OperationType;

import jakarta.annotation.PostConstruct;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Repository
public class OperationTypeRepository {

    private final Map<Integer, OperationType> operationTypes = new HashMap<>();

    @PostConstruct
    public void init() {
        save(new OperationType(1,"Normal Purchase"));
        save(new OperationType(2,"Purchase with installments"));
        save(new OperationType(3,"Withdrawal"));
        save(new OperationType(4,"Credit Voucher"));
    }

    public OperationType save(OperationType operationType) {
        operationTypes.put(operationType.getOperationTypeId(), operationType);
        return operationType;
    }

    public Optional<OperationType> findById(Integer operationTypeId) {
        return Optional.ofNullable(operationTypes.get(operationTypeId));
    }
}
