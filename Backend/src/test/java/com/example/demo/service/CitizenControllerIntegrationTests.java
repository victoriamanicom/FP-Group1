package com.example.demo.service;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;

import com.example.rest.DTO.MainDTO;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)

@AutoConfigureMockMvc
@Sql(scripts = "project-data.sql", executionPhase = ExecutionPhase.AFTER_TEST_METHOD)
@ActiveProfiles("test")
public class CitizenControllerIntegrationTests {

	@Autowired
	private MockMvc mockmvc;

	@Autowired
	private ObjectMapper mapper;

//	@Test
//	void testFindCitizens() throws Exception {
//
//		RequestBuilder request = get("/findCitizens");
//
//		ResultMatcher checkStatus = status().isOk();
//
//	}

	@Test
	public void testgetSuspectInfo() throws Exception {

		RequestBuilder request = get("/getSuspectInfo/" + "6452622442");

		List<MainDTO> mainDTOList = new ArrayList<MainDTO>();

	}

}
