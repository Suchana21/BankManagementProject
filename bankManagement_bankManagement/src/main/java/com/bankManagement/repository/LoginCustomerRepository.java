package com.bankManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bankManagement.entity.LoginCustomer;

@Repository
public interface LoginCustomerRepository extends JpaRepository<LoginCustomer, Integer> {

}
