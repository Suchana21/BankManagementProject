package com.bankManagement.entity;

import javax.persistence.*;

@Entity
public class LoginCustomer {
	
	@Id
	private int id;
	
	@OneToOne
	@JoinColumn(name = "cid")
	private Customer customer;

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public LoginCustomer(int id, Customer customer) {
		super();
		this.id = id;
		this.customer = customer;
	}

	public LoginCustomer() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
