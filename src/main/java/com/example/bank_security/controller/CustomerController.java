package com.example.bank_security.controller;

import com.example.bank_security.model.customer.CustomerEntity;
import com.example.bank_security.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.Optional;

@RequestMapping("/customer")
@RestController()
public class CustomerController {

    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    PasswordEncoder passwordEncoder;

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody CustomerEntity customer) {
        CustomerEntity savedCustomer = null;
        ResponseEntity responseEntity = null;
        try {
            String hashPwd = passwordEncoder.encode(customer.getPwd());
            customer.setPwd(hashPwd);
            customer.setCreateDt(new Date(System.currentTimeMillis()));
            savedCustomer = customerRepository.save(customer);
            if (savedCustomer.getCustomerId() > 0) {
                responseEntity = ResponseEntity
                        .status(HttpStatus.CREATED)
                        .body("Given user details are successfully registered");
            }
        } catch (Exception ex) {
            responseEntity = ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("An exception occured due to " + ex.getMessage());
        }
        return responseEntity;
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteCustomer(@PathVariable int id) {
        try {
            customerRepository.deleteById(id);
            return ResponseEntity.ok("Customer deleted successfully");
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("An exception occurred while deleting the user: " + ex.getMessage());
        }
    }

    @GetMapping("{id}")
    public ResponseEntity<CustomerEntity> getCustomer(@PathVariable int id) {
        Optional<CustomerEntity> optionalCustomer = customerRepository.findById(id);
        if (optionalCustomer.isPresent()) {
            CustomerEntity customer = optionalCustomer.get();
            return ResponseEntity.ok(customer);
        } else return ResponseEntity.notFound().build();
    }


}