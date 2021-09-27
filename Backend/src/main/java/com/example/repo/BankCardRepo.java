package com.example.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.data.ATMPoint;
import com.example.data.ATMTransaction;
import com.example.data.BankCard;
import com.example.data.Citizen;
import com.example.data.PeopleBankAccount;
import com.example.rest.DTO.MainDTO;

@Repository
public interface BankCardRepo extends JpaRepository<BankCard, Integer>{
	
	
	
	
	
	
	

}
