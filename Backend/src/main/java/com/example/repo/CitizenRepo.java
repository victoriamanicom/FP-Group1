package com.example.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.data.Citizen;
import com.example.rest.DTO.MainDTO;

@Repository
public interface CitizenRepo extends JpaRepository<Citizen, Integer>{
	
	MainDTO findByCitizenID(String citizenID);
	
	
	
	
	

}
