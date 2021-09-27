package com.example.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.data.Citizen;
import com.example.data.PeopleBankAccount;
import com.example.data.PeopleBusinessAddress;
import com.example.data.PeopleMobile;
import com.example.rest.DTO.MainDTO;
import com.example.rest.DTO.PeopleMobileDTO;

@Repository
public interface PeopleBusinessRepo extends JpaRepository<PeopleBusinessAddress, Integer>{
	
	
	
	
	
	
	

}
