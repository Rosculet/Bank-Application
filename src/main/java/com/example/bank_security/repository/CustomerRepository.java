package com.example.bank_security.repository;

import com.example.bank_security.model.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;



@Repository
public interface CustomerRepository extends JpaRepository<CustomerEntity, Integer> {

    List<CustomerEntity> findByEmail(String email);

}
