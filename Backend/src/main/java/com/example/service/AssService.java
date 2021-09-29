package com.example.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.example.data.Citizen;
import com.example.data.PeopleBusinessAddress;
import com.example.repo.CitizenRepo;
import com.example.repo.PeopleBusinessRepo;
import com.example.repo.PeopleMobileRepo;
import com.example.rest.DTO.AssociatesDTO;
import com.example.rest.DTO.ColleguesDTO;
import com.example.rest.DTO.LivingWithDTO;

@Service
public class AssService {

	private PeopleBusinessRepo pbRepo;
	private CitizenRepo citizenRepo;

	public AssService(PeopleMobileRepo pmRepo, PeopleBusinessRepo pbRepo, CitizenRepo citizenRepo) {
		super();
		this.pbRepo = pbRepo;
		this.citizenRepo = citizenRepo;
	}

	public AssociatesDTO findAssociates(Citizen citizen) {

		AssociatesDTO newAssociate = new AssociatesDTO();

		PeopleBusinessAddress busAdd = new PeopleBusinessAddress();

		busAdd.setPersonName(citizen.getForenames() + " " + citizen.getSurname());
		busAdd.setDateOfBirth(citizen.getDateOfBirth());

		PeopleBusinessAddress citizenBusAdd = this.pbRepo.findOne(Example.of(busAdd)).get();

		newAssociate.setBusinessAddress(citizenBusAdd.getBusinessAddress());
		newAssociate.setBusinessName(citizenBusAdd.getBusinessName());

		ArrayList<LivingWithDTO> housemates = new ArrayList<>();

		Citizen familyMember = new Citizen();
		familyMember.setHomeAddress(citizen.getHomeAddress());
		List<Citizen> family = this.citizenRepo.findAll(Example.of(familyMember));

		for (Citizen memberOfFamily : family) {

			LivingWithDTO livingWith = new LivingWithDTO();
			livingWith.setDateOfBirth(memberOfFamily.getDateOfBirth());
			livingWith.setForenames(memberOfFamily.getForenames());
			livingWith.setSurname(memberOfFamily.getSurname());

			housemates.add(livingWith);

		}

		newAssociate.setHousehold(housemates);

		ArrayList<ColleguesDTO> colleagues = new ArrayList<>();

		PeopleBusinessAddress colleague = new PeopleBusinessAddress();

		colleague.setBusinessAddress(citizenBusAdd.getBusinessAddress());

		List<PeopleBusinessAddress> workmates = this.pbRepo.findAll(Example.of(colleague));

		for (PeopleBusinessAddress workmate : workmates) {

			ColleguesDTO workingWith = new ColleguesDTO();
			workingWith.setPersonName(workmate.getPersonName());
			workingWith.setDateOfBirth(workmate.getDateOfBirth());

			colleagues.add(workingWith);

		}

		newAssociate.setColleagues(colleagues);

		return newAssociate;
	}

}
