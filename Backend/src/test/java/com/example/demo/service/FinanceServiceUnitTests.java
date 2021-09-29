package com.example.demo.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;

import com.example.data.Citizen;
;
import com.example.repo.ATMPointRepo;
import com.example.repo.ATMTransactionRepo;
import com.example.repo.PeopleBankAccountRepo;
import com.example.rest.DTO.PeopleBankAccountDTO;
import com.example.service.FinanceService;

@SpringBootTest
@ActiveProfiles("test")
public class FinanceServiceUnitTests {
	
	@Autowired
	private FinanceService service;
	
	@MockBean 
	private PeopleBankAccountRepo pbaRepo;
	private ATMTransactionRepo atmTRepo;
	private ATMPointRepo atmPRepo;
	
	@Test
	void testGet() {
		List<PeopleBankAccountDTO> testFinance = List.of(new Citizen("Michael", "Cochrane", "37 SPUR HILL AVENUE, POOLE, BH14 9PJ", "1955-09-25", "LONDON", "Male");
		
		Mockito.when(this.pbaRepo.findAll()).thenReturn(testFinance);

		assertThat(this.service.findBA(null).equals(testFinance));

		Mockito.verify(this.repo, Mockito.times(1)).findAll();
	}
	

}
