package com.transaction.routine.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.transaction.routine.model.Account;
import com.transaction.routine.service.AccountService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/accounts")
@Tag(name = "Account Controller", description = "API for managing accounts")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @Operation(summary = "Create a new account")
    @PostMapping("/createAccount")
    public ResponseEntity<?> createAccount(@RequestBody Account account) {
    	try {
        return ResponseEntity.ok(accountService.createAccount(account));
    	} catch (Exception e) {
			throw e;
		}
    }

    @Operation(summary = "Retrieve account information")
    @GetMapping("/{accountId}")
    public ResponseEntity<?> getAccount(@PathVariable Long accountId) {
    	try {
        return ResponseEntity.ok(accountService.getAccount(accountId));
    	} catch (Exception e) {
			throw e;
		}
    }
}

