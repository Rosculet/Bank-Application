package com.example.bank_security.repository;

import com.example.bank_security.model.CardsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CardRepository extends JpaRepository<CardsEntity, Integer> {

    List<CardsEntity> findByCustomerId(int customerId);

}
