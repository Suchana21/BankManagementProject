package com.bankManagement.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class HomeController {
	
	@GetMapping("/")
	public String goToHome() {
		return "home";
	}
	
	@GetMapping("/aboutus")
	public String goAboutUs() {
		return "aboutus";
	}
	
	@GetMapping("/contact")
	public String goContact() {
		return "contact";
	}
}
