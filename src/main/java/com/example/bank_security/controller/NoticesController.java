package com.example.bank_security.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class NoticesController {

    @GetMapping("/notices")
    public String getLoansDetails(){
        return "Here are the notices details from DB";
    }

}
