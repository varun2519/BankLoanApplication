package com.example.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.model.Payment;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Integer>{

}
