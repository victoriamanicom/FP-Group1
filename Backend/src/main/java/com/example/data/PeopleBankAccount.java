package com.example.data;

import java.time.LocalDateTime;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "people_bank_account")
public class PeopleBankAccount {

	public PeopleBankAccount(Long bankAccountId, Long accountNumber, String bank, String forenames, String surname,
			LocalDateTime dateOfBirth, String homeAddress) {
		super();
		this.bankAccountId = bankAccountId;
		this.accountNumber = accountNumber;
		this.bank = bank;
		this.forenames = forenames;
		this.surname = surname;
		this.dateOfBirth = dateOfBirth;
		this.homeAddress = homeAddress;
	}

	public PeopleBankAccount(Long accountNumber, String bank, String forenames, String surname,
			LocalDateTime dateOfBirth, String homeAddress) {
		super();
		this.accountNumber = accountNumber;
		this.bank = bank;
		this.forenames = forenames;
		this.surname = surname;
		this.dateOfBirth = dateOfBirth;
		this.homeAddress = homeAddress;
	}

	public PeopleBankAccount() {
		super();
	}

	@Id
	@Column(name = "bank_account_id")
	private Long bankAccountId;

	@Column(name = "account_number")
	private Long accountNumber;

	@Column(name = "bank")
	private String bank;

	@Column(name = "forenames")
	private String forenames;

	@Column(name = "surname")
	private String surname;

	@Column(name = "date_of_birth")
	private LocalDateTime dateOfBirth;

	@Column(name = "home_address")
	private String homeAddress;

	@OneToMany(mappedBy = "accountNumber")
	private Set<BankCard> bankCards;

	public Long getBankAccountId() {
		return bankAccountId;
	}

	public void setBankAccountId(Long bankAccountId) {
		this.bankAccountId = bankAccountId;
	}

	public Long getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(Long accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getBank() {
		return bank;
	}

	public void setBank(String bank) {
		this.bank = bank;
	}

	public String getForenames() {
		return forenames;
	}

	public void setForenames(String forenames) {
		this.forenames = forenames;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public LocalDateTime getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDateTime dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getHomeAddress() {
		return homeAddress;
	}

	public void setHomeAddress(String homeAddress) {
		this.homeAddress = homeAddress;
	}

	public Set<BankCard> getBankCards() {
		return bankCards;
	}

	public void setBankCards(Set<BankCard> bankCards) {
		this.bankCards = bankCards;
	}

}
