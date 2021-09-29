package com.example.service;

import java.util.Optional;

import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.example.data.Citizen;
import com.example.repo.CitizenRepo;
import com.example.repo.MobileCallRecordsRepo;
import com.example.repo.PeopleMobileRepo;
import com.example.repo.VehicleRepo;
import com.example.rest.DTO.MainDTO;

@Service
public class MainService {

	private CitizenRepo citizenRepo;
	private AssService assService;
	private FinanceService financeService;
	private MobileService mobileService;
	private VehicleService vehicleService;
	private AboutService aboutService;

	public MainService(PeopleMobileRepo pmRepo, MobileCallRecordsRepo mcrRepo, VehicleRepo vehicleRepo,
			CitizenRepo citizenRepo, AssService assService, CitizenService citizenService,
			FinanceService financeService, MobileService mobileService, VehicleService vehicleService,
			AboutService aboutservice) {
		super();
		this.citizenRepo = citizenRepo;
		this.assService = assService;
		this.financeService = financeService;
		this.mobileService = mobileService;
		this.vehicleService = vehicleService;
	}

	public MainDTO getSuspectInfo(String citizenID) {
		Citizen suspect = new Citizen();
		suspect.setCitizenID(citizenID);

		Optional<Citizen> foundSuspect = this.citizenRepo.findOne(Example.of(suspect));

		MainDTO suspectInfo = new MainDTO();

		suspectInfo.setCitizenID(citizenID);

		suspectInfo.setAssociatesDTO(assService.findAssociates(foundSuspect.get()));
		suspectInfo.setCitizenReturnDTO(aboutService.findCit(foundSuspect.get()));
		suspectInfo.setPeopleBankAccountDTO(financeService.findBA(foundSuspect.get()));
		suspectInfo.setPeopleMobileDTO(mobileService.findPM(foundSuspect.get()));
		suspectInfo.setVehiclesDTO(vehicleService.findVehicles(foundSuspect.get()));

		return suspectInfo;

	}

}
