package com.example.bank_security.repository;

import com.example.bank_security.model.LoansEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface LoanRepository extends JpaRepository<LoansEntity, Integer> {

    List<LoansEntity> findByCustomerIdOrderByStartDtDesc(int customerId);
}
