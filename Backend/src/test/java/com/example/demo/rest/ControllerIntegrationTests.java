package com.example.demo.rest;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.json.JSONObject.quote;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.aspectj.lang.annotation.Before;
import org.json.JSONObject;
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
import org.springframework.test.web.servlet.ResultMatcher;

import com.example.data.Citizen;
import com.example.data.VehicleRegistration;
import com.example.rest.DTO.ATMLocationDTO;
import com.example.rest.DTO.AssociatesDTO;
import com.example.rest.DTO.BankCardDTO;
import com.example.rest.DTO.CitizenReturnDTO;
import com.example.rest.DTO.ColleguesDTO;
import com.example.rest.DTO.EPOSLocationDTO;
import com.example.rest.DTO.LivingWithDTO;
import com.example.rest.DTO.MainDTO;
import com.example.rest.DTO.MobileCallRecordsDTO;
import com.example.rest.DTO.MobileReceiveRecordsDTO;
import com.example.rest.DTO.PeopleBankAccountDTO;
import com.example.rest.DTO.PeopleMobileDTO;
import com.example.rest.DTO.VehicleDTO;
import com.example.rest.DTO.WhereaboutsDTO;
import com.fasterxml.jackson.databind.ObjectMapper;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT) 

@AutoConfigureMockMvc
@Sql(scripts="project-data.sql", executionPhase=ExecutionPhase.AFTER_TEST_METHOD)
@ActiveProfiles("test")
public class ControllerIntegrationTests {
	
//	public static String citizenID;
//	
//	private static final String registrationDate;
//	private static final String make;
//	private static final String model;
//	private static final String colour;
//	private static final String vehicleRegistrationNo;
//	private static final String driverLicenceId;
//	private static final String phoneNumber;
//	private static final String network;
//	private static final List<MobileCallRecordsDTO> mobileCallRecords;
//	private static final List<MobileCallRecordsDTO> mobileReceiveRecords;
//	private static final String bankCardDTOs;
//	private static final String bank;
//	private static final Long accountNumber;
//	private static final String forenames;
//	private static final String surname;
//	private static final String homeAddress;
//	private static final String dateOfBirth;
//	private static final String sex; 
//	
//	
	
	@Autowired
	private MockMvc mockMvc;
	@Autowired
	private ObjectMapper mapper;
	
	@Test
	void testFindCitizens() throws Exception {
		
		RequestBuilder request = get("/findCitizens");
			
		ResultMatcher checkStatus = status().isOk();
		
		Citizen testCitizen = new Citizen("Michael", "Cochrane", "37 SPUR HILL AVENUE, POOLE, BH14 9PJ", "1955-09-25", "LONDON", "Male");
		String checkCitizenAsJSON = this.mapper.writeValueAsString(testCitizen);                    
		
		ResultMatcher checkBody = content().json(checkCitizenAsJSON);
		
		
		this.mockMvc.perform(request).andExpect(checkStatus).andExpect(checkBody);
		
		
	}
	
public MainDTO mainDTO;
	
public AssociatesDTO associatesDTO(List<PeopleMobileDTO> callRecords, String businessName, String businessAddress,
			List<ColleguesDTO> colleagues, List<LivingWithDTO> livingWith) { 
 
	AssociatesDTO testAssoc = new AssociatesDTO();
	testAssoc.setBusinessAddress(businessName);
	testAssoc.setBusinessName(businessName);
	testAssoc.setCallRecords(callRecords);
	testAssoc.setColleagues(colleagues);
	testAssoc.setHousehold(livingWith);
	
	
	return testAssoc;
 }

public PeopleMobileDTO peopleMobileDTO(String phoneNumber, String network, List<MobileCallRecordsDTO> mobileCallRecords, List<MobileCallRecordsDTO> mobileReceiveRecords) { 
	
	PeopleMobileDTO testPM = new PeopleMobileDTO();
	testPM.setMobileCallRecords(mobileCallRecords);
	testPM.setMobileReceiveRecords(mobileReceiveRecords);
	testPM.setNetwork(network);
	testPM.setPhoneNumber(phoneNumber);
	return testPM;
	
	
	
 }

public List<PeopleBankAccountDTO> peopleBADTO(BankCardDTO bankCardDTOs, String bank, Long accountNumber, String forenames, String surname) { 
		
		BankCardDTO card = new BankCardDTO(); 
		card.setATMTransaction(null);
		card.setEPOSTransactions(null);
		
		PeopleBankAccountDTO bankAcc = new PeopleBankAccountDTO();
		bankAcc.setAccountNumber(accountNumber);
		bankAcc.setBank(bank);
		bankAcc.setBankcardDTOs(bankCardDTOs);
		bankAcc.setForenames(forenames);
		bankAcc.setSurname(surname);
		
	
		List<PeopleBankAccountDTO> testAcc = new ArrayList<PeopleBankAccountDTO>();
		testAcc.add(bankAcc);
		return testAcc;
}

	public List<VehicleDTO> vehicleDTO(String registrationDate, String make, String model, String colour, String vehicleRegistrationNo, String driverLicenceId) { 
		
		VehicleDTO car = new VehicleDTO();
		car.setColour(colour);
		car.setMake(make);
		car.setVehicleRegistrationNo(vehicleRegistrationNo);
		car.setModel(model);
		
		
		List<VehicleDTO> testVehicle = new ArrayList<VehicleDTO>();
		testVehicle.add(car);
		
		return testVehicle;
	}

	public WhereaboutsDTO whereaboutsDTO(Long bankAccountId, Long cardNumber, List<ATMLocationDTO> aTMLocationDTOList,
			List<EPOSLocationDTO> locationEposDTOList) { 
	
		WhereaboutsDTO testWhere = new WhereaboutsDTO();
		testWhere.setATMLocationDTOList(aTMLocationDTOList);
		testWhere.setBankAccountId(bankAccountId);
		testWhere.setCardNumber(cardNumber);
		testWhere.setEPOSLocationDTOList(locationEposDTOList);
		
	
	return testWhere;
	}
	
	public CitizenReturnDTO citizenReturnDTO(String forenames, String surname, String homeAddress, String dateOfBirth, String sex) { 
	
		CitizenReturnDTO testCit = new CitizenReturnDTO();
		testCit.setDateOfBirth(dateOfBirth);
		testCit.setForenames(forenames);
		testCit.setHomeAddress(homeAddress);
		testCit.setSex(sex);
		testCit.setSurname(surname);
		
		
	
	return testCit;
	}



@Test
void testSuspectInfo() throws Exception {
		
		RequestBuilder request = get("/getSuspectInfo/{9171862863}");
			
		ResultMatcher checkStatus = status().isOk();
		
		List<PeopleMobileDTO> callRecords = new ArrayList<PeopleMobileDTO>();
		String businessName = "";
		String businessAddress = "";
		List<ColleguesDTO> collegues = new ArrayList<ColleguesDTO>();
		List<LivingWithDTO> livingWith = new ArrayList<LivingWithDTO>();
		
		String bank = "";
		Long accountNumber = 200000000L ;
		String forenames = "";
		String surname = "";
		BankCardDTO bankCard = new BankCardDTO();
		 
		String phoneNumber = "";
		String network = "";
		List<MobileCallRecordsDTO> mobileCallRecords = new ArrayList<MobileCallRecordsDTO>();
		List<MobileCallRecordsDTO> mobileReceiveRecords = new ArrayList<MobileCallRecordsDTO>();
		
		String registrationDate = "";
		String make = "";
		String model = "";
		String colour = "";
		String vehicleRegistrationNo = "";
		String driverLicenceId = "";
		
		 
		 
		 
		 mainDTO.setCitizenID("9171862863");
		 mainDTO.setAssociatesDTO(this.associatesDTO(callRecords, businessName, businessAddress, collegues, livingWith));
		 mainDTO.setPeopleBankAccountDTO(this.peopleBADTO(bankCard, bank,accountNumber,forenames,surname));
		 mainDTO.setPeopleMobileDTO(this.peopleMobileDTO(phoneNumber, network, mobileCallRecords, mobileReceiveRecords));
		 mainDTO.setVehiclesDTO(this.vehicleDTO(registrationDate, make, model, colour, vehicleRegistrationNo, driverLicenceId));
		 
		
		String checkMainAsJSON = this.mapper.writeValueAsString(mainDTO);                    
		
		ResultMatcher checkBody = content().json(checkMainAsJSON);
		
		
		this.mockMvc.perform(request).andExpect(checkStatus).andExpect(checkBody);
		
		
	}
	
	
	
	
	
;

 @Before(value = "")
 public void setup() throws Exception {
 
 	
	 
	 
	 
}
}
 

// @Test
// public void firstNameSerializes() throws IOException {
//     assertThat(this.json.write(personDTO))
//         .extractingJsonPathStringValue("@.firstName")
//         .isEqualTo(FIRST_NAME);
// }
//
// @Test
// public void secondNameSerializes() throws IOException {
//     assertThat(this.json.write(personDTO))
//         .extractingJsonPathStringValue("@.secondName")
//         .isEqualTo(SECOND_NAME);
// }
//
// @Test
// public void dateOfBirthSerializes() throws IOException, ParseException {
//     assertThat(this.json.write(personDTO))
//         .extractingJsonPathStringValue("@.dateOfBirth")
//         .isEqualTo(DATE_OF_BIRTH_STRING);
// }
//
// @Test
// public void professionSerializes() throws IOException {
//     assertThat(this.json.write(personDTO))
//         .extractingJsonPathStringValue("@.profession")
//         .isEqualTo(PROFESSION);
// }
//
// @Test
// public void salarySerializes() throws IOException {
//     assertThat(this.json.write(personDTO))
//         .extractingJsonPathNumberValue("@.salary")
//         .isEqualTo(SALARY.intValue());
// }
//
// @Test
// public void firstNameDeserializes() throws IOException {
//     assertThat(this.json.parseObject(JSON_TO_DESERIALIZE).getFirstName()).isEqualTo(FIRST_NAME);
// }
//
// @Test
// public void secondNameDeserializes() throws IOException {
//     assertThat(this.json.parseObject(JSON_TO_DESERIALIZE).getSecondName()).isEqualTo(SECOND_NAME);
// }
//
// @Test
// public void dateOfBirthDeserializes() throws IOException {
//     assertThat(this.json.parseObject(JSON_TO_DESERIALIZE).getDateOfBirth())
//         .isEqualTo(DATE_OF_BIRTH);
// }
//
// @Test
// public void professionDeserializes() throws IOException {
//     assertThat(this.json.parseObject(JSON_TO_DESERIALIZE).getProfession()).isEqualTo(PROFESSION);
// }
//
// @Test
// public void salaryDeserializes() throws IOException {
//     assertThat(this.json.parseObject(JSON_TO_DESERIALIZE).getSalary()).isEqualTo(SALARY);
// }
//}
//	
//
//}

//private static final String make;
//private static final String model;
//private static final String colour;
//private static final String vehicleRegistrationNo;
//private static final String driverLicenceId;
//
	



// private static final String JSON_TO_DESERIALIZE =
// 
// "{\"citizenID\":\"" +
// citizenID +   
// //ass
// 
//JSONObject obj = new JSONObject();
//obj.put("callRecords:", callRecords);
//obj.put("businessName:", businessName);
//obj.put("businessAddress:", businessAddress);
//obj.put("collegues:", collegues);
//obj.put("livingWith:", livingWith);
//
// 
//
// //vehicles
// "{\"registrationDate\":\"" +
// registrationDate +
// "\",\"make\":\"" +
// make +
// "\",\"model\":\"" +
// model +
// "\",\"colour\":\"" +
// colour +
// "\",\"vehicleRegistrationNo\":" +
// vehicleRegistrationNo +
// "\",\"driverLicenceId\":" +
// driverLicenceId +
//
//
// //mobile
// "{\"phoneNumber\":\"" +
// phoneNumber +
// "\",\"network\":\"" +
// network +
// "\",\"mobileCallRecords\":\"" +
// mobileCallRecords +
// "\",\"mobileReceiveRecords\":\"" +
// mobileReceiveRecords +
// 
// 
//
// //peoplebank
// "{\"bankCardDTOs\":\"" +
// bankCardDTOs +
// "\",\"bank\":\"" +
// bank +
// "\",\"accountNumber\":\"" +
// accountNumber +
// "\",\"forenames\":\"" +
// forenames +
// "\",\"surname\":" +
// surname +
//
// //citizenreturn
// "{\"forenames\":\"" +
// forenames +
// "\",\"surname\":\"" +
// surname +
// "\",\"homeAddress\":\"" +
// homeAddress +
// "\",\"dateOfBirth\":\"" +
// dateOfBirth +
// "\",\"sex\":" +
// sex;





//public void setup() throws Exception {
// mainDTO = new MainDTO(citizenID, callRecords, businessName, businessAddress, colleagues, livingWith, registrationDate, make, model, 
// colour, vehicleRegistrationNo, driverLicenceId, phoneNumber, network, mobileCallRecords  );
//}
