package com.example.bank_security.repository;

import com.example.bank_security.model.customer.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface CustomerRepository extends JpaRepository<CustomerEntity, Integer> {

    List<CustomerEntity> findByEmail(String email);

    ResponseEntity<String> deleteByCustomerId(int id);
}
