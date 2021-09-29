package com.example.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.example.data.Citizen;
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

	public List<VehicleDTO> findVehicles(Citizen citizen) {

		VehicleRegistration citizenToVehicleRegistration = new VehicleRegistration();

		citizenToVehicleRegistration.setForenames(citizen.getForenames());
		citizenToVehicleRegistration.setSurname(citizen.getSurname());
		citizenToVehicleRegistration.setDateOfBirth(citizen.getDateOfBirth());

		List<VehicleRegistration> peopleVehicles = this.vehicleRepo.findAll(Example.of(citizenToVehicleRegistration));

		ArrayList<VehicleDTO> suspectVehicles = new ArrayList<>();

		for (VehicleRegistration pV : peopleVehicles) {

			VehicleDTO suspectVehicleDTO = new VehicleDTO();

			suspectVehicleDTO.setRegistrationDate(pV.getRegistrationDate());
			suspectVehicleDTO.setMake(pV.getMake());
			suspectVehicleDTO.setModel(pV.getModel());
			suspectVehicleDTO.setColour(pV.getColour());
			suspectVehicleDTO.setVehicleRegistrationNo(pV.getVehicleRegistrationNo());

			suspectVehicles.add(suspectVehicleDTO);
		}

		return suspectVehicles;
	}
}
