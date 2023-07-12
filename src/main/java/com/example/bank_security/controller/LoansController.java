package com.example.bank_security.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class LoansController {
    @GetMapping("/loans")
    public String getLoansDetails() {
        return "Here is your loan details from DB";
    }
}
