
package com.example.bank_security.controller;

import com.example.bank_security.model.account.AccountEntity;
import com.example.bank_security.model.account.DTO.AccountDTO;
import com.example.bank_security.model.account.DTO.AccountMapper;
import com.example.bank_security.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class AccountController {

    @Autowired
    AccountRepository accountRepository;


    @PostMapping(value = "/account",  consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity addAccount(@RequestBody AccountDTO accountDTO) {

        AccountEntity account = AccountMapper.INSTANCE.dtoToAccount(accountDTO);
        accountRepository.save(account);
        ResponseEntity responseEntity = ResponseEntity.status(HttpStatus.CREATED)
                .body("Account created");
        return responseEntity;
    }

    @DeleteMapping("/account/{id}")
    public void deleteAccount(@PathVariable int id) {
        accountRepository.delete(accountRepository.findByAccountNumber(id));
    }
}


