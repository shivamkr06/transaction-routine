package com.transaction.routine.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.transaction.routine.model.Account;
import com.transaction.routine.repository.AccountRepository;

public class AccountServiceTest {

    @Mock
    private AccountRepository accountRepository;

    @InjectMocks
    private AccountService accountService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCreateAccount() {
        Account account = new Account();
        account.setDocumentNumber("12345678900");

        when(accountRepository.save(account)).thenReturn(account);

        Account createdAccount = accountService.createAccount(account);

        assertNotNull(createdAccount);
        assertEquals("12345678900", createdAccount.getDocumentNumber());
    }

    @Test
    void testGetAccount() {
        Account account = new Account();
        account.setAccountId(1L);
        account.setDocumentNumber("12345678900");

        when(accountRepository.findById(1L)).thenReturn(Optional.of(account));

        Optional<Account> retrievedAccount = accountService.getAccount(1L);

        assertNotNull(retrievedAccount);
        assertEquals("12345678900", retrievedAccount.get().getDocumentNumber());
    }
}
