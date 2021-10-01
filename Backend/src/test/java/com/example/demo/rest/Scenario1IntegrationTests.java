package com.example.demo.rest;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;

import com.example.rest.DTO.ATMLocationDTO;
import com.example.rest.DTO.ATMTransactionDTO;
import com.example.rest.DTO.AssociatesDTO;
import com.example.rest.DTO.BankCardDTO;
import com.example.rest.DTO.CitizenReturnDTO;
import com.example.rest.DTO.ColleguesDTO;
import com.example.rest.DTO.EPOSLocationDTO;
import com.example.rest.DTO.EPOSTransactionsDTO;
import com.example.rest.DTO.LivingWithDTO;
import com.example.rest.DTO.MainDTO;
import com.example.rest.DTO.MobileCallRecordsDTO;
import com.example.rest.DTO.MobileReceiveRecordsDTO;
import com.example.rest.DTO.PeopleBankAccountDTO;
import com.example.rest.DTO.PeopleMobileDTO;
import com.example.rest.DTO.VehicleDTO;
import com.example.rest.DTO.WhereaboutsDTO;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)

@AutoConfigureMockMvc

@ActiveProfiles("test")
//@Sql(scripts = { "classpath:project-data.sql" })

public class Scenario1IntegrationTests {

	@Autowired
	private MockMvc mockMvc;
	@Autowired
	private ObjectMapper mapper;

	@Test
	void testFindCitizens() throws Exception {

		RequestBuilder request = post("/findCitizens");

		ResultMatcher checkStatus = status().isOk();

		List<CitizenReturnDTO> testCitizen = new ArrayList<CitizenReturnDTO>();
		CitizenReturnDTO testCitDTO = new CitizenReturnDTO();

		testCitDTO.setCitizenID("9171862863");
		testCitDTO.setDateOfBirth("1955-09-25");
		testCitDTO.setForenames("Davis");
		testCitDTO.setSex("male");
		testCitDTO.setSurname("Doe");
		testCitDTO.setHomeAddress("37 SPUR HILL AVENUE, POOLE, BH14 9PJ");
		testCitizen.add(testCitDTO);
		String checkCitizenAsJSON = this.mapper.writeValueAsString(testCitizen);

		ResultMatcher checkBody = content().json(checkCitizenAsJSON);

		this.mockMvc.perform(request).andExpect(checkStatus).andExpect(checkBody);

	}

	public MainDTO mainDTO;

	public AssociatesDTO associatesDTO(List<PeopleMobileDTO> callRecords, String businessName, String businessAddress,
			List<ColleguesDTO> colleagues, List<LivingWithDTO> livingWith) {

		AssociatesDTO assoc = new AssociatesDTO();
		assoc.setBusinessAddress(businessAddress);
		assoc.setBusinessName(businessName);
		assoc.setCallRecords(callRecords);
		assoc.setColleagues(colleagues);
		assoc.setHousehold(livingWith);

		return assoc;
	}

	public List<PeopleMobileDTO> peopleMobileDTO(String phoneNumber, String network,
			List<MobileCallRecordsDTO> mobileCallRecords, List<MobileReceiveRecordsDTO> mobileReceiveRecords) {

		List<PeopleMobileDTO> mobiles = new ArrayList<PeopleMobileDTO>();

		PeopleMobileDTO testPM = new PeopleMobileDTO();
		testPM.setMobileCallRecords(mobileCallRecords);
		testPM.setMobileReceiveRecords(mobileReceiveRecords);
		testPM.setNetwork(network);
		testPM.setPhoneNumber(phoneNumber);

		mobiles.add(testPM);
		return mobiles;

	}

	public List<PeopleBankAccountDTO> peopleBADTO(BankCardDTO bankCardDTOs, String bank, Long accountNumber,
			String forenames, String surname, List<EPOSTransactionsDTO> eposTransactions,
			List<ATMTransactionDTO> atmTransactions, String sortCode, Long cardNumber) {

		List<BankCardDTO> cards = new ArrayList<BankCardDTO>();

		BankCardDTO card = new BankCardDTO();

		card.setATMTransaction(atmTransactions);
		card.setEPOSTransactions(eposTransactions);
		card.setSortCode(sortCode);

		PeopleBankAccountDTO bankAcc = new PeopleBankAccountDTO();
		bankAcc.setAccountNumber(accountNumber);
		bankAcc.setBank(bank);
		bankAcc.setBankcardDTOs(cards);
		bankAcc.setForenames(forenames);
		bankAcc.setSurname(surname);

		List<PeopleBankAccountDTO> testAcc = new ArrayList<PeopleBankAccountDTO>();
		testAcc.add(bankAcc);
		return testAcc;
	}

	public List<VehicleDTO> vehicleDTO(String registrationDate, String make, String model, String colour,
			String vehicleRegistrationNo, String driverLicenceId) {

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

	public CitizenReturnDTO citizenReturnDTO(String forenames, String surname, String homeAddress, String dateOfBirth,
			String sex) {

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

		RequestBuilder request = get("/getSuspectInfo/9171862863");

		ResultMatcher checkStatus = status().isOk();

		List<PeopleMobileDTO> callRecords = new ArrayList<PeopleMobileDTO>();

		callRecords.add(null);

		MainDTO mainDTO = new MainDTO();

		CitizenReturnDTO About = new CitizenReturnDTO("9171862863", "Michael Shane", "Cochrane",
				"37 SPUR HILL AVENUE, POOLE, BH14 9PJ", "1955-09-25", "LONDON", "MALE");

		List<ColleguesDTO> collegues = new ArrayList<ColleguesDTO>();
		ColleguesDTO testCollegue = new ColleguesDTO();
		testCollegue.setDateOfBirth("1959-05-06");
		testCollegue.setPersonName("Linda Lynda Anderson");

		collegues.add(testCollegue);

		List<LivingWithDTO> livingWith = new ArrayList<LivingWithDTO>();
		LivingWithDTO housemate = new LivingWithDTO();
		housemate.setDateOfBirth("1994-01-19");
		housemate.setForenames("Colin");
		housemate.setSurname("Parsons");
		livingWith.add(housemate);

		AssociatesDTO associates = new AssociatesDTO(callRecords, "Wash and Dry", "Seamoor Road, BH4 9AE", collegues,
				livingWith);

		List<VehicleDTO> listOfCars = new ArrayList<VehicleDTO>();
		VehicleDTO cars = new VehicleDTO("1999-01-16", "Toyota", "Yaris", "red", "UN28 EIN", "COCHR509255MS9RM 41");
		listOfCars.add(cars);

		List<MobileCallRecordsDTO> callers = new ArrayList<MobileCallRecordsDTO>();
		MobileCallRecordsDTO calledTo = new MobileCallRecordsDTO();
		calledTo.setCallCellTowerId(0L);
		calledTo.setCallerMSISDN("07700 098484");
		calledTo.setReceiverMSISDN("07700 192766");
		calledTo.setReceiverName("Mathew Terry James");
		calledTo.setTimestamp("2015-05-02 15:31:13.335");
		callers.add(calledTo);

		List<MobileReceiveRecordsDTO> receivers = new ArrayList<MobileReceiveRecordsDTO>();
		MobileReceiveRecordsDTO calledFrom = new MobileReceiveRecordsDTO();
		calledFrom.setCallCellTowerId(0L);
		calledFrom.setCallerMSISDN("07700 098484");
		calledFrom.setCallerName("Mathew Terry James");
		calledFrom.setReceiverMSISDN("07700 192766");
		calledFrom.setTimestamp("2015-05-02 15:31:13.335");
		receivers.add(calledFrom);

		List<PeopleMobileDTO> listOfMobiles = new ArrayList<PeopleMobileDTO>();
		PeopleMobileDTO mobiles = new PeopleMobileDTO("07700 192766", "T-Mobile", callers, receivers);
		listOfMobiles.add(mobiles);

		BigDecimal amountATM = new BigDecimal(50.0);

		List<ATMTransactionDTO> atmTrans = new ArrayList<ATMTransactionDTO>();
		ATMTransactionDTO transATM = new ATMTransactionDTO();
		transATM.setAmount(amountATM);
		transATM.setOperator("Barclays Bank");
		transATM.setPostcode("BH4 9BB");
		transATM.setStreetName("Poole Road");
		transATM.setTimestamp("2015-05-03T17:36:59.673");
		transATM.setType("Cash Withdrawal");
		atmTrans.add(transATM);

		BigDecimal amountEPOS = new BigDecimal(26.02);

		List<EPOSTransactionsDTO> eposTrans = new ArrayList<EPOSTransactionsDTO>();
		EPOSTransactionsDTO transEPOS = new EPOSTransactionsDTO();
		transEPOS.setAmount(amountEPOS);
		transEPOS.setPostcode("BH4 9AE");
		transEPOS.setStreetName("Seamoor Road");
		transEPOS.setTimestamp("2015-05-01T18:00:53.615Z");
		transEPOS.setVendor("Wash and Dry");
		eposTrans.add(transEPOS);

		List<BankCardDTO> bankCard = new ArrayList<BankCardDTO>();
		BankCardDTO bankCards = new BankCardDTO();
		bankCards.setATMTransaction(atmTrans);
		bankCards.setCardNumber(2139399399319671L);
		bankCards.setEPOSTransactions(eposTrans);
		bankCards.setSortCode("31-01-93");

		PeopleBankAccountDTO bankInfo = new PeopleBankAccountDTO(bankCard, "The Royal Bank of Scotland", 67875272L,
				"Michael Shane", "Cochrane");

		List<PeopleBankAccountDTO> bankInfoList = new ArrayList<PeopleBankAccountDTO>();
		bankInfoList.add(bankInfo);

//		BigDecimal amountAMT = new BigDecimal(60);
//
//		List<EPOSTransactionsDTO> eposTransactions = new ArrayList<EPOSTransactionsDTO>();
//		EPOSTransactionsDTO EPOST = new EPOSTransactionsDTO();
//		EPOST.setAmount(amountEPOS);
//		EPOST.setPostcode("PO2 9AI");
//		EPOST.setStreetName("Rundon Road");
//		EPOST.setTimestamp("2015-05-01T18:00:53.615Z");
//		EPOST.setVendor("B&M");
//		eposTransactions.add(EPOST);
//
//		List<ATMTransactionDTO> atmTransactions = new ArrayList<ATMTransactionDTO>();
//		ATMTransactionDTO ATMT = new ATMTransactionDTO();
//		ATMT.setAmount(amountAMT);
//		ATMT.setPostcode("BH4 9AE");
//		ATMT.setStreetName("Seamoor Road");
//		ATMT.setTimestamp("2015-05-01T18:00:53.615Z");
//		ATMT.setOperator("Tesco Express");
//		atmTransactions.add(ATMT);
//
//		String bank = "HSBC";
//		Long accountNumber = 200000000L;
//		String forenames = "Michael Shane";
//		String surname = "Cochrane";
//		Long cardNumber = 4324123478769821L;
//		String sortCode = "12-21-22";
//
//		BankCardDTO bankCard = new BankCardDTO();
//		bankCard.setATMTransaction(atmTransactions);
//		bankCard.setCardNumber(cardNumber);
//		bankCard.setEPOSTransactions(eposTransactions);
//		bankCard.setSortCode(sortCode);

		mainDTO.setCitizenID("9171862863");

		mainDTO.setCitizenReturnDTO(About);

		mainDTO.setAssociatesDTO(associates);

		mainDTO.setPeopleBankAccountDTO(bankInfoList);

		mainDTO.setVehiclesDTO(listOfCars);

		mainDTO.setPeopleMobileDTO(listOfMobiles);

		String checkMainAsJSON = this.mapper.writeValueAsString(mainDTO);

		ResultMatcher checkBody = content().json(checkMainAsJSON);

		this.mockMvc.perform(request).andExpect(checkStatus).andExpect(checkBody);

	}

}