package com.example.service;

import java.util.List;

import com.example.model.Customer;
import com.example.model.Emi;
import com.example.model.Loan;
import com.example.model.Payment;

public interface LoanService {
	
	public Customer addCustomer(Customer Customer);
	
	Loan applyLoan(Long customerId, Loan loan);
	
	Loan loanApprove(Long loanId);
	
	List<Emi> generateEmi(Long loanId);
	
	Payment payEmi(Long emiId);
	
	List<Loan> getCustomerLoans(Long CustomerId);
	
	List<Emi> getEmis(Long loanId);
}
