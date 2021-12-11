package com.ms.poke.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.PreUpdate;
import javax.persistence.GeneratedValue;
import javax.persistence.PrePersist;
import javax.validation.constraints.NotNull;
import javax.persistence.Entity;
import javax.validation.constraints.Size;
import javax.validation.constraints.Min;

import javax.persistence.Table;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.format.annotation.DateTimeFormat;


@Entity
@Table(name="expenses")
public class Expense {
	
	//Whenever creating a model, write member variables first with err and valid flash messages
		@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotNull
	@Size (min=1, max = 80, message="The name for expense can't be empty.")
	private String name;
	
	@NotNull
	@Size(min=3, max = 88, message="Vendor must not be blank.")
	private String vendor;
	
	@NotNull
	@Min(value=0, message="Amount cannot be a negative number.")
	private double amount;
	
	@NotNull 
	@Size(min= 3, max = 777, message="Description must not be blank.")
	private String description;
	
	@Column(updatable = false)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date createdAt;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date updatedAt;
	
	// This line of code constructs the model or class
	public Expense() {
		
	}
	
	public Expense (String name, String vendor, double amount, String description) {
		this.amount = amount;
		this.vendor= vendor;
		this.description = description;
		this.name = name;
	}
	
	//Write Code for get and set methods here
	public Long getId() {
		return id;
	}
	public String getVendor() {
		return vendor;
	}
	public String getName() {
		return name;
	}
	public String getDescription() {
		return description;
	}
	public double getAmount() {
		return amount;
	}
	
	
	
	public void setId(Long id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public void setVendor(String vendor) {
		this.vendor = vendor;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	
	public Date getUdatedAt() {
		return updatedAt;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	
	
	@PrePersist
	protected void onCreate() {
		this.createdAt = new Date();
	}
	
	@PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }
		

}
