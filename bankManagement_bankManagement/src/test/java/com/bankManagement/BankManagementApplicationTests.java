package com.bankManagement;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.bankManagement.entity.Customer;
import com.bankManagement.entity.LoginCustomer;
import com.bankManagement.repository.CustomerRepository;
import com.bankManagement.service.CustomerService;

@SpringBootTest
class BankManagementApplicationTests {
	
	@Autowired
	CustomerRepository repository;
	
	@Autowired
	CustomerService service;

	@Test
	void contextLoads() {
	}
	
	
//	@Test
//	public void testRegisterCustomer() {
//		Customer c=new Customer();
//		c.setCid(34);
//		c.setcACno(service.RanAcNo());
//		c.setCname("Karan");
//		c.setCbal(20000);
//		c.setCmail("karan@gmail.com");
//		c.setCpass("Karan@123");
//		c.setCmob("9887654321");
//		c.setCadd("Siliguri");
//		assertEquals(true,service.registerCustomer(c));
//	}
//	
//	@Test
//	public void testLoginCustomer() {
//		Customer c=new Customer();
//		c.setCid(34);
//		c.setcACno(1161019);
//		c.setCname("Karan");
//		c.setCbal(20000);
//		c.setCmail("karan@gmail.com");
//		c.setCpass("Karan@123");
//		c.setCmob("9887654321");
//		c.setCadd("Siliguri");
//		assertEquals(true,service.loginCustomer("karan@gmail.com","Karan@123"));
//	}
	

}