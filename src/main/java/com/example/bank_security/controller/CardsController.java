package com.example.bank_security.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class CardsController {

    @GetMapping("/cards")
    public String getCardDetails(){
        return "Here is your card details from DB";
    }

}
