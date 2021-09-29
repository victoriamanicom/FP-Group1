package com.example.data;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "bank_card")
public class BankCard {

	public BankCard(String cardNumber, String sortCode, Integer bankAccountId, Integer accountNumber, String bank) {

		super();
		this.cardNumber = cardNumber;
		this.sortCode = sortCode;
		this.bankAccountId = bankAccountId;
		this.bank = bank;

	}

	public BankCard(Integer bankCardId, String cardNumber, String sortCode, Integer bankAccountId,
			Integer accountNumber, String bank) {

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
	private Integer bankCardId;

	@Column(name = "card_number")
	private String cardNumber;

	@Column(name = "sort_code")
	private String sortCode;

	@Column(name = "bank_account_id")
	private Integer bankAccountId;

	@OneToMany(mappedBy = "cardNumber")
	private Set<ATMTransaction> atmTransactions;

	@OneToMany(mappedBy = "cardNumber")
	private Set<EPOSTransactions> eposTransactions;

	@ManyToOne
	@JoinColumn(name = "account_number", nullable = false)
	private PeopleBankAccount accountNumber;

	@Column(name = "bank")
	private String bank;

	public Integer getBankCardId() {
		return bankCardId;
	}

	public void setBankCardId(Integer bankCardId) {
		this.bankCardId = bankCardId;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getSortCode() {
		return sortCode;
	}

	public void setSortCode(String sortCode) {
		this.sortCode = sortCode;
	}

	public Integer getBankAccountId() {
		return bankAccountId;
	}

	public void setBankAccountId(Integer bankAccountId) {
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
