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
		
		@GetMapping("/findCitizen/forenames={forenames}/surname={surnames}/sex={sex}")
		public ResponseEntity<List<CitizenReturnDTO>> findCitizen(@PathVariable String forenames, @PathVariable String surname, @PathVariable String sex, @RequestBody Citizen citizen) {
			return ResponseEntity.ok(this.service.findCitizen(citizen));
		}
		
		
	
}
