package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Customer;
import com.example.model.Emi;
import com.example.model.Loan;
import com.example.model.Payment;
import com.example.service.LoanService;

@RestController
@RequestMapping("/api")
public class LoanController {
	
	@Autowired
	LoanService service;
	
	public LoanController(LoanService service) {
		super();
		this.service = service;
	}

    @PostMapping("/customers")
	public Customer addCusomer(@RequestBody Customer customer) {
		return service.addCustomer(customer);
	}
	
    @PostMapping("/loans/apply/{customerId}")
    public Loan applyLoan(@PathVariable Long customerId, @RequestBody Loan loan) {
    	return service.applyLoan(customerId, loan);
    }
    
    @PutMapping("/loans/approve/{loanId}")
    public Loan loanApprove(@PathVariable Long loanId) {
    	return service.loanApprove(loanId);
    }
    
    @PostMapping("/emi/generate/{loanId}")
    public List<Emi> generateEmi(@PathVariable Long loanId){
    	return service.generateEmi(loanId);
    }
    
    @PostMapping("/payments/pay/{emiId}")
    public Payment payEmi(@PathVariable Long emiId) {
    	return service.payEmi(emiId);
    }
    
    @GetMapping("/loans/customers/{customerId}")
    public List<Loan> getCustomerLoans(@PathVariable Long customerId){
    	return service.getCustomerLoans(customerId);
    }
    
    @GetMapping("/emi/{loanId}")
    public List<Emi> getEmis(@PathVariable Long loanId){
    	return service.getEmis(loanId);
    }

}
