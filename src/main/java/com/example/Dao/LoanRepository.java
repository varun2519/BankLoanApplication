package com.example.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.model.Loan;

@Repository
public interface LoanRepository extends JpaRepository<Loan, Long>{
	
	List<Loan> findByCustomerCustomerId(Long customerId);

}
