package com.example.serviceImpl;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.Dao.CustomerRepository;
import com.example.Dao.EmiRepository;
import com.example.Dao.LoanRepository;
import com.example.Dao.PaymentRepository;
import com.example.model.Customer;
import com.example.model.Emi;
import com.example.model.Loan;
import com.example.model.Payment;
import com.example.service.LoanService;

@Service
public class LoanServiceImpl implements LoanService{
	
	CustomerRepository cxRepo;
	EmiRepository emiRepo;
	LoanRepository loanRepo;
	PaymentRepository paymentRepo;
	
	

	public LoanServiceImpl(CustomerRepository cxRepo, EmiRepository emiRepo, LoanRepository loanRepo,
			PaymentRepository paymentRepo) {
		super();
		this.cxRepo = cxRepo;
		this.emiRepo = emiRepo;
		this.loanRepo = loanRepo;
		this.paymentRepo = paymentRepo;
	}



	@Override
	public Customer addCustomer(Customer Customer) {
		return cxRepo.save(Customer);
	}



	@Override
	public Loan applyLoan(Long customerId, Loan loan) {
		Customer customer = cxRepo.findById(customerId)
                .orElseThrow(() -> new RuntimeException("Customer not found"));
		loan.setCustomer(customer);
		loan.setStatus("PENDING");
		return loanRepo.save(loan);
	}



	@Override
	public Loan loanApprove(Long loanId) {
		
		Loan loan = loanRepo.findById(loanId).orElseThrow(() -> new RuntimeException("Loan Id not found"));
		
		loan.setStatus("Approved");
		return loanRepo.save(loan);
	}



	@Override
	public List<Emi> generateEmi(Long loanId) {

	    List<Emi> existingEmis = emiRepo.findByLoanLoanId(loanId);

	    if (!existingEmis.isEmpty()) {
	        throw new RuntimeException("EMI already generated for this loan");
	    }

	    Loan loan = loanRepo.findById(loanId)
	            .orElseThrow(() -> new RuntimeException("Loan not found"));

	    double principal = loan.getAmount();
	    double monthlyRate = loan.getInterestRate() / 12 / 100;
	    int months = loan.getTenureMonths();

	    double emiAmount = principal * monthlyRate * Math.pow(1 + monthlyRate, months)
	            / (Math.pow(1 + monthlyRate, months) - 1);

	    for (int i = 1; i <= months; i++) {
	        Emi emi = new Emi();
	        emi.setLoan(loan);
	        emi.setEmiAmount(emiAmount);
	        emi.setDueDate(LocalDate.now().plusMonths(i));
	        emi.setStatus("PENDING");
	        emiRepo.save(emi);
	    }

	    return emiRepo.findByLoanLoanId(loanId);
	}



	@Override
	public Payment payEmi(Long emiId) {
		Emi emi = emiRepo.findById(emiId).orElseThrow(() -> new RuntimeException("Emi Id not found"));
		
		emi.setStatus("PAID");
		
		emiRepo.save(emi);
		
		Payment payment = new Payment();
		
		payment.setEmi(emi);
		payment.setAmountPaid(emi.getEmiAmount());
		payment.setPaymentDate(LocalDateTime.now());
			
		return paymentRepo.save(payment);
	}



	@Override
	public List<Loan> getCustomerLoans(Long CustomerId) {
		return loanRepo.findByCustomerCustomerId(CustomerId);
	}



	@Override
	public List<Emi> getEmis(Long loanId) {
		return emiRepo.findByLoanLoanId(loanId);
	}

}
