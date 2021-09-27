package com.example.service;

import java.util.List;

import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.example.data.Citizen;
import com.example.data.PeopleMobile;
import com.example.data.VehicleRegistration;
import com.example.repo.VehicleRepo;

import com.example.rest.DTO.VehicleDTO;

@Service
public class VehicleService {
	
	private VehicleRepo vehicleRepo;
	
	
	public VehicleService(VehicleRepo vehicleRepo) {
		super();
		this.vehicleRepo = vehicleRepo;
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
