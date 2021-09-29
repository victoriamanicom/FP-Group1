package com.example.service;

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
			AboutService aboutService) {
		super();
		this.citizenRepo = citizenRepo;
		this.assService = assService;
		this.financeService = financeService;
		this.mobileService = mobileService;
		this.vehicleService = vehicleService;
		this.aboutService = aboutService;
	}

	public MainDTO getSuspectInfo(String citizenID) {

		Citizen foundSuspect = this.citizenRepo.findById(citizenID).get();

		MainDTO suspectInfo = new MainDTO();

		suspectInfo.setCitizenID(citizenID);

		suspectInfo.setAssociatesDTO(assService.findAssociates(foundSuspect));
		suspectInfo.setCitizenReturnDTO(aboutService.findCit(foundSuspect));
		suspectInfo.setPeopleBankAccountDTO(financeService.findBA(foundSuspect));
		suspectInfo.setPeopleMobileDTO(mobileService.findPM(foundSuspect));
		suspectInfo.setVehiclesDTO(vehicleService.findVehicles(foundSuspect));

		return suspectInfo;

	}

}
