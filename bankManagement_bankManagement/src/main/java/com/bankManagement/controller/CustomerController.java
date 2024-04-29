package com.bankManagement.controller;

import javax.validation.Valid;


//import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import com.bankManagement.entity.Customer;
import com.bankManagement.service.CustomerService;

@Controller
public class CustomerController {
	
	@Autowired
	private CustomerService service;
	
	@GetMapping("/signup")
	public String goSignupPage(Model m) {
		m.addAttribute("Cust",new Customer());
		return "signup";
	}
	
	@GetMapping("/login")
	public String goLoginPage() {
		return "login";
	}
	
	@PostMapping("/registerCustomer")
	public String goRegisterCustomer(@Valid @ModelAttribute("Cust") Customer cust , BindingResult result ,Model m) {
		if(result.hasErrors()) {
			m.addAttribute("errorMessage", "please provide valid details!");
			return "signup";
		}
			if(service.registerCustomer(cust)) {
				m.addAttribute("errorMessage", "Registered Successfully");
			}else {
				m.addAttribute("errorMessage", "Registration not successfull!!   Invalid name or mobile number [Password should contain Capital & small letters,special character and numbers");
				return "signup";
			}
		return "home";
	}
	
	@PostMapping("/customerpage")
	public String accountlogin(@ModelAttribute Customer c,Model m) {
		if(service.loginCustomer(c.getCmail(),c.getCpass())) {
			return "customerpage";
		}
		m.addAttribute("errorMessage", "Please provide valid details");
		return "login";
	}
	

	@GetMapping("/viewaccount")
	public String myaccount(Model m) {
	    Customer c = service.viewAccount();
		m.addAttribute("caccount", c);
	    return "viewaccount";
	}
	
	@PostMapping("/deleteAccount")
    public String accountDelete() {
		service.deleteAccount();
        return "home";
    }
}