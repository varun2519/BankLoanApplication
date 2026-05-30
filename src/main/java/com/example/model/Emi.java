package com.example.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class Emi {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long emiId;
	
	private Double emiAmount;
	
	private LocalDate dueDate;
	
	private String status;
	
	@ManyToOne
	public Loan loan;

}
