package com.transaction.routine.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.transaction.routine.model.Account;
import com.transaction.routine.service.AccountService;

@RestController
@RequestMapping("/accounts")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @PostMapping("/createAccount")
    public ResponseEntity<?> createAccount(@RequestBody Account account) {
    	try {
        return ResponseEntity.ok(accountService.createAccount(account));
    	} catch (Exception e) {
			throw e;
		}
    }

    @GetMapping("/{accountId}")
    public ResponseEntity<?> getAccount(@PathVariable Long accountId) {
    	try {
        return ResponseEntity.ok(accountService.getAccount(accountId));
    	} catch (Exception e) {
			throw e;
		}
    }
}

