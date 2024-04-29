package com.bankManagement.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.bankManagement.entity.Transaction;
import com.bankManagement.service.TransactionService;

@Controller
public class TransactionController {
	
	@Autowired
	private TransactionService tservice;
	
	@GetMapping("/transferamount")
	public String goTotransferpage() {
		return "transferamount";
	}
	
	
	@PostMapping("/transfer")
    public String transferAmount(@RequestParam("receiverAccountNo") int receiverAccountNo,
                                @RequestParam("amount") int amount,
                                Model m) {
        boolean success;
			success = tservice.transferAmount(receiverAccountNo, amount);
			if (success) {
				m.addAttribute("errorMessage", "Transfer Successfull");
				return "transferamount";
			} 
			else {
				m.addAttribute("errorMessage", "Transfer not successfull");
			}
        return "transferamount"; 
    }

	
	@GetMapping("/customerpage")
	public String goToCustomerpage() {
		return "customerpage";
	}

	
	@GetMapping("/transactionlist")
	public String getTransactionHistory(Model m) {
	    List<Transaction> transactions;
			transactions = tservice.getTransactionHistory();
			m.addAttribute("transactions", transactions);
	    
	    return "transactionlist";
	}
}
