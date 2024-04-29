package com.bankManagement.service;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bankManagement.entity.Customer;
import com.bankManagement.entity.LoginCustomer;
import com.bankManagement.exception.CustomerException;
import com.bankManagement.repository.CustomerRepository;
import com.bankManagement.repository.LoginCustomerRepository;

@Service
public class CustomerService {
	
	@Autowired
	private CustomerRepository repo;
	
	@Autowired
	private LoginCustomerRepository lrepo;
	
	
	public boolean registerCustomer(Customer c){
		
		try {
		if(c.getCmob().matches("^[789]\\d{9}$") && c.getCmail().matches("^(.+)@((.+)com)$") && c.getCpass().matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=]).{8,20}$") && c.getCname().matches("^[a-zA-Z\\s]+$")) {
			c.setcACno(this.RanAcNo());
			repo.save(c);
			return true;
		}
		}
		catch(Exception e) {
			throw new CustomerException("Invalid Registrations!!");
		}
		return false;
	}
	
	public int RanAcNo() {
		Random r = new Random();
		int max = 2000000;
		int min = 1000000;
		return r.ints(min,max).findFirst().getAsInt();
	}
	
	
	public boolean loginCustomer(String email, String pass){
		List<Customer> list = repo.findAll();
		try {
		for(Customer c:list) {
			if(email.equals(c.getCmail()) && pass.equals(c.getCpass())) {
				repo.findById(c.getCid());
				lrepo.save(new LoginCustomer(1,c));
				return true;
			}
		}
		}catch(Exception e) {
			throw new CustomerException("Invalid Login!!");
		}
		return false;
	}
	
	
	public Customer viewAccount(){
		Customer c=null;
		try {
			LoginCustomer l=lrepo.findById(1).get();
			c= repo.findById(l.getCustomer().getCid()).orElse(null);
		}catch(Exception e) {
			throw new CustomerException("Invalid account!!");
		}
		return c;
	}
	
	public boolean deleteAccount(){
		try {
		LoginCustomer l=lrepo.findById(1).get();
		lrepo.deleteAll();
		repo.deleteById(l.getCustomer().getCid());
		}catch(Exception e) {
			throw new CustomerException("Invalid deletion of account!!");
		}
		return true;
	}
	
	
}