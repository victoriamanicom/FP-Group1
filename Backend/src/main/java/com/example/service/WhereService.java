package com.example.service;

import java.util.List;

import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.example.data.Citizen;
import com.example.data.PeopleBankAccount;
import com.example.repo.PeopleBankAccountRepo;

@Service
public class WhereService {
	
	private PeopleBankAccountRepo pbaRepo;
	
		
	public List<PeopleBankAccount> findBA(Citizen citizen) {
			
			
			PeopleBankAccount citizenToBankAccount = new PeopleBankAccount();
			
			
			citizenToBankAccount.setForenames(citizen.getForenames());
			citizenToBankAccount.setSurname(citizen.getSurname());
		    citizenToBankAccount.setHomeAddress(citizen.getHomeAddress());
			
			List<PeopleBankAccount> peopleBA = this.pbaRepo.findAll(Example.of(citizenToBankAccount));
			
			return  peopleBA;
		
		} 
}
