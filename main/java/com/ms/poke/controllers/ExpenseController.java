package com.ms.poke.controllers;

import java.util.List;

import javax.validation.Valid;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.validation.BindingResult;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

import com.ms.poke.models.Expense;
import com.ms.poke.services.ExpenseService;



@Controller
public class ExpenseController {
	
	//This line of code puts the e service as a dependency, whatever that means lol
	@Autowired
	ExpenseService expService;
	
	//this code shows all the list in your expense db
	@RequestMapping("/expenses")
	public String index(Model model, @ModelAttribute("expense") Expense expense ) {
		List<Expense> expenses = expService.allExpenses();
		model.addAttribute("expenses", expenses);
		return "index.jsp";
	}
	
	@RequestMapping("/")
	public String chris() {
		return "redirect:/expenses";
	}
	
	
	
	
		@PostMapping("/expenses")
		public String create(Model model, @Valid @ModelAttribute("expense") Expense expense, BindingResult result) {
			// In case of validation error 
			if(result.hasErrors()) {
				// include to render table
				List<Expense> expenses = expService.allExpenses();
				model.addAttribute("expenses", expenses);

				return "index.jsp";
			}
			// created so table updates
			else {
				expService.createExpense(expense);
				return "redirect:/expenses";
			}
		}
	
		
		
		
	
	
	//This routes to the edit page
		@RequestMapping("/expenses/edit/{id}")
		public String edit(@PathVariable("id") Long id, Model model) {
			Expense expense = expService.oneExpense(id);
			model.addAttribute("expense", expense);
			return "/expenses/edit.jsp";
		}
		
	// this is the action route that updates
		@PutMapping("/expenses/{id}")
		public String update(@Valid @ModelAttribute("expense") Expense expense, BindingResult result) {
			if(result.hasErrors()) {
				return "/expenses/edit.jsp";
			}
			// after put request successful, redirect to home page
			else {
				expService.updateExpense(expense);
				return "redirect:/expenses";
			}
		}
		
		
		//Code to direct user to see individual expenses
		@RequestMapping("/expenses/{id}")
		public String readOne(@PathVariable("id") Long id, Model model) {
			Expense expense = expService.oneExpense(id);
			model.addAttribute("expense", expense);
			return "/delete.jsp";
	
	
	
	}
		
		@DeleteMapping("expenses/{id}")
		public String delete(@PathVariable("id") Long id) {
			expService.deleteExpense(id);
			return "redirect:/expenses";
		}
		
		}
