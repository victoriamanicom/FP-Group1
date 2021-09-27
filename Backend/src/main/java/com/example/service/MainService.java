package com.example.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.data.domain.Example;

import com.example.data.MobileCallRecords;
import com.example.data.PeopleMobile;
import com.example.data.VehicleRegistration;
import com.example.repo.MobileCallRecordsRepo;
import com.example.repo.PeopleMobileRepo;
import com.example.repo.VehicleRepo;
import com.example.rest.DTO.MobileCallRecordsDTO;
import com.example.rest.DTO.PeopleMobileDTO;
import com.example.rest.DTO.VehicleDTO;

public class MainService {
	
	private PeopleMobileRepo pmRepo;
	private MobileCallRecordsRepo mcrRepo;
	private VehicleRepo vehicleRepo;
	
	public MainService(PeopleMobileRepo pmRepo, MobileCallRecordsRepo mcrRepo, VehicleRepo vehicleRepo) {
		super();
		this.pmRepo = pmRepo;
		this.mcrRepo = mcrRepo;
		this.vehicleRepo = vehicleRepo;
	}
	
	
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

	public VehicleRegistration findVehicle(VehicleRegistration vehicle) {
		List<VehicleRegistration> peopleVehicle = this.vehicleRepo.findAll(Example.of(vehicle));
		return null;
		
	}
	
	public VehicleDTO mapVToDTO(VehicleRegistration peoplevehicle) {
			
			
			VehicleDTO dto = new VehicleDTO();
			dto.setColour(peoplevehicle.getColour());
			dto.setMake(peoplevehicle.getMake());
			dto.setModel(peoplevehicle.getModel());
			dto.setRegistrationDate(peoplevehicle.getRegistrationDate());
			dto.setVehicleRegistrationNo(peoplevehicle.getVehicleRegistrationNo());
			return dto;
			
		}

	




}
