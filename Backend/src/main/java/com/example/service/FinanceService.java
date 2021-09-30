package com.example.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.example.data.ATMTransaction;
import com.example.data.BankCard;
import com.example.data.Citizen;
import com.example.data.EPOSTransactions;
import com.example.data.PeopleBankAccount;
import com.example.repo.PeopleBankAccountRepo;
import com.example.rest.DTO.ATMTransactionDTO;
import com.example.rest.DTO.BankCardDTO;
import com.example.rest.DTO.EPOSTransactionsDTO;
import com.example.rest.DTO.PeopleBankAccountDTO;

@Service
public class FinanceService {

	private PeopleBankAccountRepo pbaRepo;

	public FinanceService(PeopleBankAccountRepo pbaRepo) {
		super();
		this.pbaRepo = pbaRepo;
	}

	public List<PeopleBankAccountDTO> findBA(Citizen citizen) {

		PeopleBankAccount citizenToBankAccount = new PeopleBankAccount();

		citizenToBankAccount.setForenames(citizen.getForenames());
		citizenToBankAccount.setSurname(citizen.getSurname());
		citizenToBankAccount.setHomeAddress(citizen.getHomeAddress());

		System.out.println(citizenToBankAccount);

		List<PeopleBankAccount> peopleBA = this.pbaRepo.findAll(Example.of(citizenToBankAccount));

		System.out.println("PEOPLEBA: " + peopleBA);

		ArrayList<PeopleBankAccountDTO> suspectFinances = new ArrayList<>();

		for (PeopleBankAccount pBA : peopleBA) {

			PeopleBankAccountDTO suspectBankDTO = new PeopleBankAccountDTO();

			ArrayList<BankCardDTO> bankCards = new ArrayList<>();

			System.out.println("CARDS: " + pBA.getBankCards());

			for (BankCard bc : pBA.getBankCards()) {

				System.out.println("CARD: " + bc);

				BankCardDTO bankCardDTO = new BankCardDTO();
				bankCardDTO.setSortCode(bc.getSortCode());
				bankCardDTO.setCardNumber(bc.getCardNumber());

				ArrayList<ATMTransactionDTO> atmTrans = new ArrayList<>();

				System.out.println("ATM TRANS: " + bc.getATMTransactions());

				for (ATMTransaction ATMT : bc.getATMTransactions()) {
					System.out.println("ATM: " + ATMT);
					ATMTransactionDTO ATMtransDTO = new ATMTransactionDTO();
					ATMtransDTO.setTimestamp(ATMT.getTimestamp());
					ATMtransDTO.setType(ATMT.getType());
					ATMtransDTO.setAmount(ATMT.getAmount());
					ATMtransDTO.setStreetName(ATMT.getAtmId().getStreetName());
					ATMtransDTO.setPostcode(ATMT.getAtmId().getPostcode());
					ATMtransDTO.setOperator(ATMT.getAtmId().getOperator());

					atmTrans.add(ATMtransDTO);
				}

				bankCardDTO.setATMTransaction(atmTrans);

				ArrayList<EPOSTransactionsDTO> eposTrans = new ArrayList<>();
				System.out.println("EPOS TRANS: " + bc.getEPOSTransactions());

				for (EPOSTransactions EPOST : bc.getEPOSTransactions()) {
					System.out.println("EPOS: " + EPOST);

					EPOSTransactionsDTO EPOStransDTO = new EPOSTransactionsDTO();
					EPOStransDTO.setTimestamp(EPOST.getTimestamp());
					EPOStransDTO.setAmount(EPOST.getAmount());
					EPOStransDTO.setStreetName(EPOST.getId().getStreetName());
					EPOStransDTO.setPostcode(EPOST.getId().getPostcode());
					EPOStransDTO.setVendor(EPOST.getId().getVendor());

					eposTrans.add(EPOStransDTO);
				}
				bankCardDTO.setEPOSTransactions(eposTrans);

				bankCards.add(bankCardDTO);
			}

			suspectBankDTO.setForenames(citizenToBankAccount.getForenames());
			suspectBankDTO.setSurname(citizenToBankAccount.getSurname());
			suspectBankDTO.setAccountNumber(pBA.getAccountNumber());
			suspectBankDTO.setBank(pBA.getBank());
			suspectBankDTO.setBankcardDTOs(bankCards);

			suspectFinances.add(suspectBankDTO);

		}

		return suspectFinances;

	}

}
