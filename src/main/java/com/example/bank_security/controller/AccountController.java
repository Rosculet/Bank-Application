/*
package com.example.bank_security.controller;


import com.example.bank_security.model.AccountsEntity;
import com.example.bank_security.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class AccountController {

    @Autowired
    AccountRepository accountRepository;

    @GetMapping("/account")
    public AccountsEntity getAccountDetails(@RequestBody int id) {

        AccountsEntity accountsEntity = accountRepository.findByCustomerId(id);
        if (accountsEntity != null)
            return accountsEntity;
        else
            return null;
    }
}
*/
