package com.example.service;
import java.util.List;
import java.util.stream.Collectors;
import com.example.data.Citizen;
import com.example.data.VehicleRegistration;
import com.example.repo.CitizenRepo;
import com.example.repo.VehicleRepo;
import com.example.rest.DTO.CitizenReturnDTO;
import com.example.rest.DTO.PeopleBankAccountDTO;
import com.example.rest.DTO.VehicleDTO;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;



public class CitizenService {
	
	private CitizenRepo citizenrepo;
	
	
	
	private ModelMapper mapper;

	
	
	@Autowired
	public Scenario1Service(CitizenRepo citizenrepo, ModelMapper mapper) {
		this.citizenrepo = citizenrepo;
		
		this.mapper = mapper;
	}
	
	private CitizenReturnDTO mapCitizenToDTO(Citizen citizen) {
		return this.mapper.map(citizen, CitizenReturnDTO.class );
	}
	
	public List<CitizenReturnDTO> findCitizen(Citizen citizen) {
		return this.citizenrepo.findAll(Example.of(citizen)).stream().map(this::mapCitizenToDTO).collect(Collectors.toList());
	}
	
	public Citizen getByCitizenID(String citizenID) {
		return this.citizenrepo.findByCitizenID(citizenID);
	}
	
	public PeopleBankAccountDTO getFinance(String citizenID) {
		
		
		
		
	}
	
	
	
	
	
	
	
	
	


		
		
		
	
		
		
		
		
		
		

	

}
