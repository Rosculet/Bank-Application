package com.example.bank_security.repository;

import com.example.bank_security.model.AccountsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AccountRepository extends JpaRepository<AccountsEntity, Integer> {

    AccountsEntity findByCustomerId(int customerId);

}
