package com.example.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.data.Citizen;
import com.example.data.PeopleBusinessAddress;
import com.example.data.PeopleMobile;
import com.example.repo.CitizenRepo;
import com.example.repo.PeopleBusinessRepo;
import com.example.repo.PeopleMobileRepo;

@Service
public class AssService {
	
	private PeopleMobileRepo pmRepo;
	private PeopleBusinessRepo pbRepo;
	private CitizenRepo citizenRepo;
	
	public AssService(PeopleMobileRepo pmRepo, PeopleBusinessRepo pbRepo, CitizenRepo citizenRepo) {
		super();
		this.pmRepo = pmRepo;
		this.pbRepo = pbRepo;
		this.citizenRepo = citizenRepo;
	}
	
	
	public PeopleBusinessAddress findPeopleBusiness(Citizen citizen) {
		List<PeopleBusinessAddress> peoplebusiness = this.pbRepo.findAll();
		
		for (int i = 0 ; i < peoplebusiness.size() ; i++) {
			if(peoplebusiness.get(i).getPersonName() == citizen.getForenames() && peoplebusiness.get(i).getSurname() == citizen.getSurname() && peoplebusiness.get(i).getAddress() == citizen.getHomeAddress()) {
				return peoplebusiness.get(i);
			} 	
			}
		return null;
		
		
	}
	

}
