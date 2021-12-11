package com.ms.poke.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ms.poke.models.Expense;
import com.ms.poke.repositories.ExpenseRepository;

@Service
public class ExpenseService {
	
	// this code does something idk yet to expense repo
	@Autowired
	ExpenseRepository expRepo;
	
	//The R in CRUD
	public List<Expense> allExpenses(){
		return expRepo.findAll();
	}
	
	//This line of code creates an expense in the database
	public Expense createExpense(Expense exp) {
		return expRepo.save(exp);
	}
	
	//This line tells progrma to pull up the info from an Expense
	public Expense oneExpense(Long id) {
		Optional<Expense> optionalExp = expRepo.findById(id);
		if (optionalExp.isPresent()) {
			return optionalExp.get();
		}
		else {
			return null;
		}
	}
	
	//This is the cheap method to execute the U in CRUD
	public Expense updateExpense(Expense exp) {
		return expRepo.save(exp);
	}
	
	//This is the D in CRUD
	public void deleteExpense(Long id) {
		expRepo.deleteById(id);
	}

}
