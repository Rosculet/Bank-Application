package com.example.bank_security.repository;

import com.example.bank_security.model.AccountTransactionsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountTransactionRepository extends JpaRepository<AccountTransactionRepository, Integer> {

    List<AccountTransactionsEntity> findByCustomerIDOrderOrderByTransactionDtDesc(int customerId);

}
