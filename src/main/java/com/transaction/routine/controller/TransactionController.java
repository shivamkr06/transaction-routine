package com.transaction.routine.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.transaction.routine.model.TransactionRequest;
import com.transaction.routine.service.TransactionService;

@RestController
@RequestMapping("/transactions")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @PostMapping("/createTransaction")
    public ResponseEntity<?> createTransaction(@RequestBody TransactionRequest transaction) {
    	try {
        return ResponseEntity.ok(transactionService.createTransaction(transaction));
    	} catch (Exception e) {
			throw e;
		}
    }
}
