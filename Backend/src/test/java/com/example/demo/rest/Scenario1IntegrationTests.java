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
import org.springframework.test.context.jdbc.Sql;
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
@Sql
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

		String businessName = "Argos";
		String businessAddress = "";
		List<ColleguesDTO> collegues = new ArrayList<ColleguesDTO>();
		ColleguesDTO testCollegue = new ColleguesDTO();
		testCollegue.setDateOfBirth("1997-09-02");
		testCollegue.setPersonName("John Doe");

		collegues.add(testCollegue);

		List<LivingWithDTO> livingWith = new ArrayList<LivingWithDTO>();
		LivingWithDTO housemate = new LivingWithDTO();
		housemate.setDateOfBirth("1992-02-01");
		housemate.setForenames("Luke");
		housemate.setSurname("Davis");
		livingWith.add(housemate);

		String phoneNumber = "07721 555484";
		String network = "O2";
		List<MobileCallRecordsDTO> mobileCallRecords = new ArrayList<MobileCallRecordsDTO>();
		MobileCallRecordsDTO callerRecords = new MobileCallRecordsDTO();
		callerRecords.setCallCellTowerId(2342L);
		callerRecords.setCallerMSISDN("07700 098484");
		callerRecords.setReceiverMSISDN("07701 198555");
		callerRecords.setReceiverName("Alex Sutton");
		callerRecords.setTimestamp("2016-04-02T15:31:13.335");
		mobileCallRecords.add(callerRecords);

		List<MobileReceiveRecordsDTO> mobileReceiveRecords = new ArrayList<MobileReceiveRecordsDTO>();
		MobileReceiveRecordsDTO incomingRecords = new MobileReceiveRecordsDTO();
		incomingRecords.setCallCellTowerId(2343L);
		incomingRecords.setCallerMSISDN("07721 555484");
		incomingRecords.setReceiverMSISDN("07700 098484");
		incomingRecords.setCallerName("Davis Marbury");
		incomingRecords.setTimestamp("2015-05-02T15:31:13.335");
		mobileReceiveRecords.add(incomingRecords);

		String registrationDate = "";
		String make = "BMW";
		String model = "1-Series";
		String colour = "Black";
		String vehicleRegistrationNo = "UN28 EIN";
		String driverLicenceId = "COCHR509255MS9RM 41";

		BigDecimal amountEPOS = new BigDecimal(96.34);
		BigDecimal amountAMT = new BigDecimal(60);

		List<EPOSTransactionsDTO> eposTransactions = new ArrayList<EPOSTransactionsDTO>();
		EPOSTransactionsDTO EPOST = new EPOSTransactionsDTO();
		EPOST.setAmount(amountEPOS);
		EPOST.setPostcode("PO2 9AI");
		EPOST.setStreetName("Rundon Road");
		EPOST.setTimestamp("2015-05-01T18:00:53.615Z");
		EPOST.setVendor("B&M");
		eposTransactions.add(EPOST);

		List<ATMTransactionDTO> atmTransactions = new ArrayList<ATMTransactionDTO>();
		ATMTransactionDTO ATMT = new ATMTransactionDTO();
		ATMT.setAmount(amountAMT);
		ATMT.setPostcode("BH4 9AE");
		ATMT.setStreetName("Seamoor Road");
		ATMT.setTimestamp("2015-05-01T18:00:53.615Z");
		ATMT.setOperator("Tesco Express");
		atmTransactions.add(ATMT);

		String bank = "HSBC";
		Long accountNumber = 200000000L;
		String forenames = "Michael";
		String surname = "Cochrane";
		Long cardNumber = 4324123478769821L;
		String sortCode = "12-21-22";

		BankCardDTO bankCard = new BankCardDTO();
		bankCard.setATMTransaction(atmTransactions);
		bankCard.setCardNumber(cardNumber);
		bankCard.setEPOSTransactions(eposTransactions);
		bankCard.setSortCode(sortCode);

		mainDTO.setCitizenID("9171862863");

		mainDTO.setAssociatesDTO(this.associatesDTO(callRecords, businessName, businessAddress, collegues, livingWith));

		mainDTO.setPeopleBankAccountDTO(this.peopleBADTO(bankCard, bank, accountNumber, forenames, surname,
				eposTransactions, atmTransactions, driverLicenceId, accountNumber));

		mainDTO.setPeopleMobileDTO(this.peopleMobileDTO(phoneNumber, network, mobileCallRecords, mobileReceiveRecords));

		mainDTO.setVehiclesDTO(
				this.vehicleDTO(registrationDate, make, model, colour, vehicleRegistrationNo, driverLicenceId));

		String checkMainAsJSON = this.mapper.writeValueAsString(mainDTO);

		ResultMatcher checkBody = content().json(checkMainAsJSON);

		this.mockMvc.perform(request).andExpect(checkStatus).andExpect(checkBody);

	}

}