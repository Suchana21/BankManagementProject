package com.bankManagement.entity;

import javax.persistence.*;

@Entity
public class Transaction {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int transaction_id;

	private int receiver_accountNo;
	
	private int transferred_amount;
	
	@ManyToOne
	@JoinColumn(name = "cid")
	private Customer customer;
	
	public Transaction() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Transaction(int receiver_accountNo,int transferred_amount,Customer customer) {
		super();
		this.receiver_accountNo=receiver_accountNo;
		this.transferred_amount=transferred_amount;
		this.customer=customer;
	}
	
	
	public int getTransaction_id() {
		return transaction_id;
	}

	public void setTransaction_id(int transaction_id) {
		this.transaction_id = transaction_id;
	}

	public int getTransferred_amount() {
		return transferred_amount;
	}
	public void setTransferred_amount(int transferred_amount) {
		this.transferred_amount = transferred_amount;
	}
	
	public int getReceiver_accountNo() {
		return receiver_accountNo;
	}

	public void setReceiver_accountNo(int receiver_accountNo) {
		this.receiver_accountNo = receiver_accountNo;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
}
