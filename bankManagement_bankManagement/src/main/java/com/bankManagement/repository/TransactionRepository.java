package com.bankManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bankManagement.entity.Transaction;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction,Integer>{

}
