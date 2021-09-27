package com.example.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.example.data.Citizen;
import com.example.data.MobileCallRecords;
import com.example.data.PeopleMobile;
import com.example.repo.MobileCallRecordsRepo;
import com.example.repo.PeopleMobileRepo;
import com.example.rest.DTO.CitizenReturnDTO;
import com.example.rest.DTO.MobileCallRecordsDTO;
import com.example.rest.DTO.PeopleMobileDTO;


import org.modelmapper.ModelMapper;

@Service
public class MobileService {
	
	private PeopleMobileRepo pmRepo;
	
	
	public MobileService(PeopleMobileRepo pmRepo) {
		super();
		this.pmRepo = pmRepo;
	}


	public List<PeopleMobileDTO> findPM(Citizen citizen){
		
		PeopleMobile citizenToMobile = new PeopleMobile();
		citizenToMobile.setForenames(citizen.getForenames());
		citizenToMobile.setSurname(citizen.getSurname());
		citizenToMobile.setAddress(citizen.getHomeAddress());
		
		List<PeopleMobile> peopleM = this.pmRepo.findAll(Example.of(citizenToMobile));
		
		ArrayList<PeopleMobileDTO> suspectMobile = new ArrayList<>();
		for(PeopleMobile pm : peopleM) {
			
			PeopleMobileDTO suspectMobileDTO = new PeopleMobileDTO();
			suspectMobileDTO.setPhoneNumber(pm.getPhoneNumber());
			suspectMobileDTO.setNetwork(pm.getNetwork());
			
			ArrayList<MobileCallRecordsDTO> suspectRecords = new ArrayList<>();
			for( MobileCallRecords mcr : pm )
			// need to do pm.setters 
		} 
		return suspectMobile;
	}
	
	
}
