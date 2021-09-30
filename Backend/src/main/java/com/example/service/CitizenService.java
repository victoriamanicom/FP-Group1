package com.example.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.example.data.Citizen;
import com.example.repo.CitizenRepo;
import com.example.repo.PeopleBankAccountRepo;
import com.example.rest.DTO.CitizenReturnDTO;

@Service
public class CitizenService {

	private CitizenRepo citizenrepo;

	@Autowired
	public CitizenService(CitizenRepo citizenrepo, PeopleBankAccountRepo pbaRepo) {
		this.citizenrepo = citizenrepo;
	}

	private CitizenReturnDTO mapCitizenToDTO(Citizen citizen) {

		return new CitizenReturnDTO(citizen.getCitizenID(), citizen.getForenames(), citizen.getSurname(),
				citizen.getHomeAddress(), citizen.getDateOfBirth(), citizen.getPlaceOfBirth(), citizen.getSex());

	}

	public List<CitizenReturnDTO> findCitizens(Citizen citizen) {
		return this.citizenrepo.findAll(Example.of(citizen)).stream().map(this::mapCitizenToDTO)
				.collect(Collectors.toList());
	}

}
