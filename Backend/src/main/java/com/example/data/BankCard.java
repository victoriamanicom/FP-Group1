package com.example.data;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class BankCard {

	public BankCard(Long cardNumber, String sortCode, Long bankAccountId, Long accountNumber, String bank) {

		super();
		this.cardNumber = cardNumber;
		this.sortCode = sortCode;
		this.bankAccountId = bankAccountId;
		this.bank = bank;

	}

	public BankCard(Long bankCardId, Long cardNumber, String sortCode, Long bankAccountId, Long accountNumber,
			String bank) {

		super();
		this.bankCardId = bankCardId;
		this.cardNumber = cardNumber;
		this.sortCode = sortCode;
		this.bankAccountId = bankAccountId;
		this.bank = bank;

	}

	public BankCard() {
		super();
	}

	@Id
	@Column(name = "bank_card_id")
	private Long bankCardId;

	@Column(name = "card_number")
	private Long cardNumber;

	@Column(name = "sort_code")
	private String sortCode;

	@Column(name = "bank_account_id")
	private Long bankAccountId;

	@OneToMany(mappedBy = "bankCardNumber")
	private Set<ATMTransaction> atmTransactions;

	@OneToMany(mappedBy = "bankCardNumber")
	private Set<EPOSTransactions> eposTransactions;

	@ManyToOne
	@JoinColumn(name = "account_number", nullable = false)
	private PeopleBankAccount accountNumber;

	@Column(name = "bank")
	private String bank;

	public Long getBankCardId() {
		return bankCardId;
	}

	public void setBankCardId(Long bankCardId) {
		this.bankCardId = bankCardId;
	}

	public Long getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(Long cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getSortCode() {
		return sortCode;
	}

	public void setSortCode(String sortCode) {
		this.sortCode = sortCode;
	}

	public Long getBankAccountId() {
		return bankAccountId;
	}

	public void setBankAccountId(Long bankAccountId) {
		this.bankAccountId = bankAccountId;
	}

	public PeopleBankAccount getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(PeopleBankAccount accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getBank() {
		return bank;
	}

	public void setBank(String bank) {
		this.bank = bank;
	}

	public Set<ATMTransaction> getATMTransactions() {
		return atmTransactions;
	}

	public void setAtmTransactions(Set<ATMTransaction> atmTransactions) {
		this.atmTransactions = atmTransactions;
	}

	public Set<EPOSTransactions> getEPOSTransactions() {
		return eposTransactions;
	}

	public void setEPOSTransactions(Set<EPOSTransactions> eposTransactions) {
		this.eposTransactions = eposTransactions;
	}

}
