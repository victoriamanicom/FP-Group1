package com.example.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.example.data.Citizen;
import com.example.data.MobileCallRecords;
import com.example.data.PeopleMobile;
import com.example.repo.MobileCallRecordsRepo;
import com.example.repo.PeopleMobileRepo;
import com.example.rest.DTO.MobileCallRecordsDTO;
import com.example.rest.DTO.MobileReceiveRecordsDTO;
import com.example.rest.DTO.PeopleMobileDTO;

@Service
public class MobileService {

	private PeopleMobileRepo pmRepo;
	private MobileCallRecordsRepo mcRepo;

	public MobileService(PeopleMobileRepo pmRepo, MobileCallRecordsRepo mcRepo) {
		super();
		this.pmRepo = pmRepo;
		this.mcRepo = mcRepo;
	}

	public List<PeopleMobileDTO> findPM(Citizen citizen) {

		PeopleMobile citizenToMobile = new PeopleMobile();
		citizenToMobile.setForenames(citizen.getForenames());
		citizenToMobile.setSurname(citizen.getSurname());
		citizenToMobile.setAddress(citizen.getHomeAddress());

		List<PeopleMobile> peopleM = this.pmRepo.findAll(Example.of(citizenToMobile));

		ArrayList<PeopleMobileDTO> suspectMobile = new ArrayList<>();

		for (PeopleMobile pm : peopleM) {

			PeopleMobileDTO suspectMobileDTO = new PeopleMobileDTO();
			suspectMobileDTO.setPhoneNumber(pm.getPhoneNumber());
			suspectMobileDTO.setNetwork(pm.getNetwork());

			ArrayList<MobileCallRecordsDTO> suspectOutgoingRecords = new ArrayList<>();
			for (MobileCallRecords mcr : pm.getMobileCallRecords()) {

				MobileCallRecordsDTO recordsDTO = new MobileCallRecordsDTO();
				recordsDTO.setTimestamp(mcr.getTimestamp());
				recordsDTO.setCallerMSISDN(mcr.getPhoneNumber().getPhoneNumber());
				recordsDTO.setReceiverMSISDN(mcr.getReceiverMSISDN());
				recordsDTO.setCallCellTowerId(mcr.getCallCellTowerId());

				PeopleMobile receiverMobile = new PeopleMobile();
				receiverMobile.setPhoneNumber(mcr.getReceiverMSISDN());
				List<PeopleMobile> receiverName = this.pmRepo.findAll(Example.of(receiverMobile));

				for (PeopleMobile rpm : receiverName) {

					recordsDTO.setReceiverName(rpm.getForenames().concat(rpm.getSurname()));

				}

				suspectOutgoingRecords.add(recordsDTO);

			}

			ArrayList<MobileReceiveRecordsDTO> suspectIncomingRecords = new ArrayList<>();
			for (MobileCallRecords mcr : mcRepo.findByReceiverMSISDN(pm.getPhoneNumber())) {

				MobileReceiveRecordsDTO receiverRecordsDTO = new MobileReceiveRecordsDTO();
				receiverRecordsDTO.setTimestamp(mcr.getTimestamp());
				receiverRecordsDTO.setCallerMSISDN(mcr.getPhoneNumber().getPhoneNumber());
				receiverRecordsDTO.setReceiverMSISDN(mcr.getReceiverMSISDN());
				receiverRecordsDTO.setCallCellTowerId(mcr.getCallCellTowerId());

				PeopleMobile callerMobile = new PeopleMobile();
				callerMobile.setPhoneNumber(mcr.getPhoneNumber().getPhoneNumber());
				List<PeopleMobile> callerName = this.pmRepo.findAll(Example.of(callerMobile));

				for (PeopleMobile rpm : callerName) {

					receiverRecordsDTO.setCallerName(rpm.getForenames().concat(rpm.getSurname()));

				}

				suspectIncomingRecords.add(receiverRecordsDTO);

			}

			suspectMobileDTO.setMobileCallRecords(suspectOutgoingRecords);
			suspectMobileDTO.setMobileReceiveRecords(suspectIncomingRecords);
			suspectMobile.add(suspectMobileDTO);

		}

		return suspectMobile;
	}

}
