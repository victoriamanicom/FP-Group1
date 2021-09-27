package com.example.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.data.Citizen;
import com.example.data.PeopleMobile;
import com.example.data.VehicleRegistration;
import com.example.rest.DTO.CitizenReturnDTO;
import com.example.rest.DTO.MainDTO;
import com.example.rest.DTO.PeopleMobileDTO;
import com.example.rest.DTO.VehicleDTO;
import com.example.service.AboutService;
import com.example.service.AssService;
import com.example.service.CitizenService;
import com.example.service.FinanceService;
import com.example.service.MobileService;
import com.example.service.VehicleService;
import com.example.service.WhereService;





@RestController
@CrossOrigin
public class Scenario1Controller {
	
		private CitizenService citizenservice;
		private FinanceService financeservice;
		private AssService assservice;
	    private MobileService mobileservice;
		private VehicleService vehicleservice;
		private WhereService whereservice;
		private AboutService aboutservice;
		
		@Autowired
		public Scenario1Controller(CitizenService citizenservice, FinanceService financeservice, AssService assservice,
				MobileService mobileservice, VehicleService vehicleservice, WhereService whereservice,
				AboutService aboutservice) {
			super();
			this.citizenservice = citizenservice;
			this.financeservice = financeservice;
			this.assservice = assservice;
			this.mobileservice = mobileservice;
			this.vehicleservice = vehicleservice;
			this.whereservice = whereservice;
			this.aboutservice = aboutservice;
		}
		
		@GetMapping("/Main")
		public ResponseEntity<MainDTO> findMain(@RequestBody PeopleMobile person) {
			
			PeopleMobile peoplemobile = this.mobileservice.findPeopleMobile(person);
			
			PeopleMobileDTO body = this.mobileservice.mapPMToDTO(peoplemobile);
			
			return new ResponseEntity<PeopleMobileDTO>(body, HttpStatus.OK);
		}
		
		
		
		@GetMapping("/Mobile")
		public ResponseEntity<PeopleMobileDTO> findPeopleMobile(@RequestBody PeopleMobile person) {
			
			PeopleMobile peoplemobile = this.mobileservice.findPeopleMobile(person);
			
			PeopleMobileDTO body = this.mobileservice.mapPMToDTO(peoplemobile);
			
			return new ResponseEntity<PeopleMobileDTO>(body, HttpStatus.OK);
		}
		
		
		@GetMapping("/Vehicle")
		public ResponseEntity<VehicleDTO> findVehicle(@RequestBody Citizen citizen) {
			
			VehicleRegistration vehicle = this.vehicleservice.findVehicle(citizen);
			
			VehicleDTO body = this.vehicleservice.mapVToDTO(vehicle);
			
			return new ResponseEntity<VehicleDTO>(body, HttpStatus.OK);
		}
		
		
		@GetMapping("/findCitizens")
		public ResponseEntity<List<CitizenReturnDTO>> findCitizens(@RequestBody Citizen citizen) {
			
			List<CitizenReturnDTO> body = this.citizenservice.findCitizens(citizen);
			
			return new ResponseEntity<List<CitizenReturnDTO>>(body, HttpStatus.OK);
		}
		
	
		@GetMapping("/getSuspectInfo/{citizenID}")
		public ResponseEntity<MainDTO> getSuspectInfo(@PathVariable String citizenID) {
			
			MainDTO body = this.citizenservice.getSuspectInfo(citizenID);
			
			return new ResponseEntity<MainDTO>(body, HttpStatus.OK);
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		@GetMapping("/About")
		public ResponseEntity<List<CitizenReturnDTO>> findCitizens(@RequestBody Citizen citizen) {
			
			List<CitizenReturnDTO> body = this.citizenservice.findCitizens(citizen);
			
			return new ResponseEntity<List<CitizenReturnDTO>>(body, HttpStatus.OK);
		}
		
		@GetMapping("/Where")
		public ResponseEntity<List<CitizenReturnDTO>> findCitizens(@RequestBody Citizen citizen) {
			
			List<CitizenReturnDTO> body = this.citizenservice.findCitizens(citizen);
			
			return new ResponseEntity<List<CitizenReturnDTO>>(body, HttpStatus.OK);
		}
		
		
		
		@GetMapping("/Associates")
		public ResponseEntity<List<CitizenReturnDTO>> findCitizens(@RequestBody Citizen citizen) {
			
			List<CitizenReturnDTO> body = this.citizenservice.findCitizens(citizen);
			
			return new ResponseEntity<List<CitizenReturnDTO>>(body, HttpStatus.OK);
		}
		
		@GetMapping("/Financial")
		public ResponseEntity<List<CitizenReturnDTO>> findCitizens(@RequestBody Citizen citizen) {
			
			List<CitizenReturnDTO> body = this.citizenservice.findCitizens(citizen);
			
			return new ResponseEntity<List<CitizenReturnDTO>>(body, HttpStatus.OK);
		}
	
}
