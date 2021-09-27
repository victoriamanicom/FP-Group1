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
	private MobileCallRecordsRepo mcrRepo;
	private ModelMapper mapper;
	
	public MobileService(PeopleMobileRepo pmRepo, MobileCallRecordsRepo mcrRepo, ModelMapper mapper) {
		super();
		this.pmRepo = pmRepo;
		this.mcrRepo = mcrRepo;
		
	}
	
//	private PeopleMobileDTO mapCitizenToDTO(PeopleMobile peoplemobile) {
//		return this.mapper.map(peoplemobile, PeopleMobileDTO.class );
//	}
	public PeopleMobile findPeopleMobile(PeopleMobile person) {
		List<PeopleMobile> peopleMobile = this.pmRepo.findAll(Example.of(person));
		
		return null;
	}
	
	public Set<MobileCallRecordsDTO> findRecords(PeopleMobile peoplemobile){
		
		Set<MobileCallRecordsDTO> foundRecords = new HashSet<>();
		List<MobileCallRecords> records = this.mcrRepo.findAll();
		for (int i = 0 ; i < records.size() ; i++) {
			
			if(records.get(i).getCallerMSISDN() == peoplemobile.getPhoneNumber() || records.get(i).getReceiverMSISDN() == peoplemobile.getPhoneNumber()) {
				foundRecords.add(this.mapMCRToDTO(records.get(i)));
				
			}
		} return foundRecords;
	}
		
	
	public PeopleMobileDTO mapPMToDTO(PeopleMobile peoplemobile) {
		
		
		PeopleMobileDTO dto = new PeopleMobileDTO();
		dto.setNetwork(peoplemobile.getNetwork());
		dto.setPhoneNumber(peoplemobile.getPhoneNumber());
		dto.setMobileCallRecords(this.findRecords(peoplemobile));
		return dto;
		
	}
	
	

	public MobileCallRecordsDTO mapMCRToDTO(MobileCallRecords mobilecallrecords) {
		
		
		MobileCallRecordsDTO dto = new MobileCallRecordsDTO();
		dto.setCallCellTowerId(mobilecallrecords.getCallCellTowerId());
		dto.setCallerMSISDN(mobilecallrecords.getCallerMSISDN());
		dto.setReceiverMSISDN(mobilecallrecords.getReceiverMSISDN());
		
		dto.setTimestamp(mobilecallrecords.getTimestamp());
		return dto;
	}
	
	
}
