package com.example.bank_security;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;


@SpringBootApplication
@EnableWebSecurity(debug = true)
public class BankSecurityApplication {
    public static void main(String[] args) {

        SpringApplication.run(BankSecurityApplication.class, args);
    }

}
