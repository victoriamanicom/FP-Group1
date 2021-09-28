package com.example.service;

import java.util.Optional;

import org.springframework.data.domain.Example;

import com.example.data.Citizen;
import com.example.repo.CitizenRepo;
import com.example.repo.MobileCallRecordsRepo;
import com.example.repo.PeopleMobileRepo;
import com.example.repo.VehicleRepo;
import com.example.rest.DTO.MainDTO;

public class MainService {

	private PeopleMobileRepo pmRepo;
	private MobileCallRecordsRepo mcrRepo;
	private VehicleRepo vehicleRepo;
	private CitizenRepo citizenRepo;
	private AssService assService;
	private CitizenService citizenService;
	private FinanceService financeService;
	private MobileService mobileService;
	private VehicleService vehicleService;
	private AboutService aboutService;

	public MainService(PeopleMobileRepo pmRepo, MobileCallRecordsRepo mcrRepo, VehicleRepo vehicleRepo,
			CitizenRepo citizenRepo, AssService assService, CitizenService citizenService,
			FinanceService financeService, MobileService mobileService, VehicleService vehicleService,
			AboutService aboutservice) {
		super();
		this.pmRepo = pmRepo;
		this.mcrRepo = mcrRepo;
		this.vehicleRepo = vehicleRepo;
		this.citizenRepo = citizenRepo;
		this.assService = assService;
		this.citizenService = citizenService;
		this.financeService = financeService;
		this.mobileService = mobileService;
		this.vehicleService = vehicleService;
		this.aboutService = aboutService;
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
