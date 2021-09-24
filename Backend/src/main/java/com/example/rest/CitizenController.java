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
import com.example.rest.DTO.CitizenReturnDTO;
import com.example.rest.DTO.MainDTO;
import com.example.service.CitizenService;





@RestController
@CrossOrigin
public class CitizenController {
	
		private CitizenService service;
		
		@Autowired
		public CitizenController(CitizenService service) {
			super();
			this.service = service;
		}
		
		@GetMapping("/findCitizens")
		public ResponseEntity<List<CitizenReturnDTO>> findCitizens(@RequestBody Citizen citizen) {
			
			List<CitizenReturnDTO> body = this.service.findCitizens(citizen);
			
			return new ResponseEntity<List<CitizenReturnDTO>>(body, HttpStatus.OK);
		}
		
		@GetMapping("/getSuspectInfo/{citizenID}")
		public ResponseEntity<MainDTO> getSuspectInfo(@PathVariable String citizenID) {
			
			MainDTO body = this.service.getSuspectInfo(citizenID);
			
			return new ResponseEntity<MainDTO>(body, HttpStatus.OK);
		}
		
		
	
}
