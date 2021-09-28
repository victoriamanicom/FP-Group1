package com.example.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.data.Citizen;
import com.example.rest.DTO.CitizenReturnDTO;
import com.example.rest.DTO.MainDTO;
import com.example.service.AboutService;
import com.example.service.AssService;
import com.example.service.CitizenService;
import com.example.service.FinanceService;
import com.example.service.MainService;
import com.example.service.MobileService;
import com.example.service.VehicleService;

@RestController
@CrossOrigin
public class Scenario1Controller {

	private CitizenService citizenservice;
	private FinanceService financeservice;
	private AssService assservice;
	private MobileService mobileservice;
	private VehicleService vehicleservice;
	private AboutService aboutservice;
	private MainService mainservice;

	@Autowired
	public Scenario1Controller(CitizenService citizenservice, FinanceService financeservice, AssService assservice,
			MobileService mobileservice, VehicleService vehicleservice, AboutService aboutservice) {
		super();
		this.citizenservice = citizenservice;
		this.financeservice = financeservice;
		this.assservice = assservice;
		this.mobileservice = mobileservice;
		this.vehicleservice = vehicleservice;
		this.aboutservice = aboutservice;
	}

	@GetMapping("/findCitizens")
	public ResponseEntity<List<CitizenReturnDTO>> findCitizens(@RequestBody Citizen citizen) {

		List<CitizenReturnDTO> body = this.citizenservice.findCitizens(citizen);

		return new ResponseEntity<List<CitizenReturnDTO>>(body, HttpStatus.OK);
	}

	@GetMapping("/getSuspectInfo/{citizenID}")
	public ResponseEntity<MainDTO> getSuspectInfo(@PathVariable String citizenID) {

		MainDTO body = this.mainservice.getSuspectInfo(citizenID);

		return new ResponseEntity<MainDTO>(body, HttpStatus.OK);
	}

}