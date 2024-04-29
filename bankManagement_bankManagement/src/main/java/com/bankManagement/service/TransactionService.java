package com.bankManagement.service;

import java.util.ArrayList;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bankManagement.entity.Customer;
import com.bankManagement.entity.LoginCustomer;
import com.bankManagement.entity.Transaction;
import com.bankManagement.exception.TransactionException;
import com.bankManagement.repository.CustomerRepository;
import com.bankManagement.repository.LoginCustomerRepository;
import com.bankManagement.repository.TransactionRepository;

import javax.transaction.Transactional;

@Service
public class TransactionService {
	
	@Autowired
	private CustomerRepository crepo;
	
	@Autowired
	private TransactionRepository trepo;
	
	@Autowired
	private LoginCustomerRepository lrepo;
	
	
	@Transactional
	public boolean transferAmount(int receiverAcountNo, int amount) {
		try {
		Customer receiverAccount=null;
		LoginCustomer l=lrepo.findById(1).get();
		Customer senderAccount=crepo.findById(l.getCustomer().getCid()).orElse(null);
		
		try {
		List<Customer> clist = crepo.findAll();
		receiverAccount = clist.stream()
		        .filter(r -> r.getcACno()==receiverAcountNo)
		        .findFirst()
		        .orElse(null);
		}catch(NullPointerException e) {
			System.out.println("Can't find Receiver Account");
		}
		
		int senderBalance = senderAccount.getCbal();
		int receiverBalance = receiverAccount.getCbal();
		if (senderBalance >= amount) {
			int updatedSenderBalance = senderBalance - amount;
			int updatedReceiverBalance = receiverBalance + amount;

          senderAccount.setCbal(updatedSenderBalance);
          receiverAccount.setCbal(updatedReceiverBalance);

          crepo.save(senderAccount);
          crepo.save(receiverAccount);
          
          trepo.save(new Transaction(receiverAccount.getcACno(),amount,senderAccount));
          
          return true; // Successful transfer
		}
		}
		catch(Exception e) {
			throw new TransactionException("Invalid Transfer!1");
		}
		return false;  // Transfer failed (insufficient balance or invalid accounts)
}
	
	@Transactional
	public List<Transaction> getTransactionHistory(){
		
		List<Transaction> newList=new ArrayList<>();
		
		try {
		List<Transaction> tlist=trepo.findAll();
		
		LoginCustomer l=lrepo.findById(1).get();
		int id=l.getCustomer().getCid();
		for(Transaction tr:tlist) {
			if(tr.getCustomer().getCid()==id) {
				try {
				newList.add(tr);
				}
				catch(NullPointerException e) {
					e.printStackTrace();
				}
			}
		}
		}
		catch(Exception e) {
			throw new TransactionException("Invalid Transfer!1");
		}
		return newList;
	}
	
}
