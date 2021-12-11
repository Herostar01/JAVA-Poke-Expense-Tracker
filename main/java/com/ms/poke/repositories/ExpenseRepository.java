package com.ms.poke.repositories;

import java.util.List;

import com.ms.poke.models.Expense;

import org.springframework.data.repository.CrudRepository;

import org.springframework.stereotype.Repository;

@Repository
public interface ExpenseRepository extends CrudRepository<Expense, Long>{
	
	//this line of code allows the program to dive into the DB and gets all items
	List<Expense> findAll();

}
