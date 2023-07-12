package com.example.bank_security.repository;

import com.example.bank_security.model.account.AccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<AccountEntity, Integer> {

    AccountEntity findByCustomerCustomerId(int customerId);

    AccountEntity findByAccountNumber(int id);

    void delete(AccountEntity account);
}

