package com.example.demo.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;

import com.example.data.Citizen;
import com.example.repo.CitizenRepo;
import com.example.service.CitizenService;

@SpringBootTest
@ActiveProfiles("test")
public class CitizenServiceUnitTest {

	@Autowired
	private CitizenService citizenService;

	@MockBean
	private CitizenRepo citizenRepo;

	@Test
	public void testFindCitizens() {

		List<Citizen> returnedCitizenList = new ArrayList<>();

		Citizen colin = new Citizen("3554464415L", "Colin", "Parsons", "37 SPUR HILL AVENUE, POOLE, BH14 9PJ",
				"1967-03-17", "MANCHESTER", "Male");

		returnedCitizenList.add(colin);

		Mockito.when(this.citizenRepo.findAll()).thenReturn(returnedCitizenList);

		assertThat(this.citizenService.findCitizens(colin)).isEqualTo(returnedCitizenList);

	}

}
