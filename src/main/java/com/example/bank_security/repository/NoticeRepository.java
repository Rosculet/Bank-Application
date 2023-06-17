package com.example.bank_security.repository;

import com.example.bank_security.model.NoticeDetailsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface NoticeRepository extends JpaRepository<NoticeDetailsEntity, Integer> {

}
