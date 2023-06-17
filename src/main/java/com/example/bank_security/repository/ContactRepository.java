package com.example.bank_security.repository;

import com.example.bank_security.model.ContactMessagesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ContactRepository extends JpaRepository<ContactMessagesEntity, Integer> {

}
