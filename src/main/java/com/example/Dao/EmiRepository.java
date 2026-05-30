package com.example.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.model.Emi;

@Repository
public interface EmiRepository extends JpaRepository<Emi, Long>{
	
	List<Emi> findByLoanLoanId(Long loanId);

}
