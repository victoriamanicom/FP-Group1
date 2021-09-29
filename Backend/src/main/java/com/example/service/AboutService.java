package com.example.service;

import org.springframework.stereotype.Service;

import com.example.data.Citizen;
import com.example.repo.CitizenRepo;
import com.example.rest.DTO.CitizenReturnDTO;

@Service
public class AboutService {

	public AboutService(CitizenRepo bioRepo) {

		super();

	}

	public CitizenReturnDTO findCit(Citizen citizen) {

		CitizenReturnDTO newCitizen = new CitizenReturnDTO();

		newCitizen.setForenames(citizen.getForenames());
		newCitizen.setSurname(citizen.getSurname());
		newCitizen.setCitizenID(citizen.getCitizenID());
		newCitizen.setDateOfBirth(citizen.getDateOfBirth());
		newCitizen.setHomeAddress(citizen.getHomeAddress());
		newCitizen.setPlaceOfBirth(citizen.getPlaceOfBirth());
		newCitizen.setSex(citizen.getSex());

		return newCitizen;
	}

}
