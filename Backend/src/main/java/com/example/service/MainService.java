package com.example.service;

import com.example.repo.MobileCallRecordsRepo;
import com.example.repo.PeopleMobileRepo;
import com.example.repo.VehicleRepo;

public class MainService {

	private PeopleMobileRepo pmRepo;
	private MobileCallRecordsRepo mcrRepo;
	private VehicleRepo vehicleRepo;

	public MainService(PeopleMobileRepo pmRepo, MobileCallRecordsRepo mcrRepo, VehicleRepo vehicleRepo) {
		super();
		this.pmRepo = pmRepo;
		this.mcrRepo = mcrRepo;
		this.vehicleRepo = vehicleRepo;
	}

//	public MainDTO getByCitizenID(String citizenID) {
//		return this.citizenrepo.findByCitizenID(citizenID);
//	}
//	
//	public MainDTO getSuspectInfo(String citizenID) {
//		List<PeopleBankAccount> pbaList = pbaRepo.findAll();
//		ArrayList<PeopleMobileDTO> suspectMobile = new ArrayList<>();
//		for(PeopleMobile pm : peopleSus) {
//			
//		}
//		
//		return null;

}
