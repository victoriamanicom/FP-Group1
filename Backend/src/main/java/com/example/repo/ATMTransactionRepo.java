package com.example.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.data.ATMTransaction;

@Repository
public interface ATMTransactionRepo extends JpaRepository<ATMTransaction, Integer> {

}
