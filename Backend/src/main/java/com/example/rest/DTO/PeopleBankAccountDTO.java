package com.example.rest.DTO;

import java.util.Set;

public class PeopleBankAccountDTO {

	public PeopleBankAccountDTO(Set<BankCardDTO> bankcardDTOs, String bank, Long accountNumber, String forenames,
			String surname) {
		super();
		this.bankCardDTOs = bankcardDTOs;
		this.bank = bank;
		this.accountNumber = accountNumber;
		this.forenames = forenames;
		this.surname = surname;
	}

	public PeopleBankAccountDTO(String bank, Long accountNumber, String forenames, String surname) {
		super();
		this.bank = bank;
		this.accountNumber = accountNumber;
		this.forenames = forenames;
		this.surname = surname;
	}

	public PeopleBankAccountDTO() {
		super();
	}

	private Set<BankCardDTO> bankCardDTOs;

	private String bank;

	private Long accountNumber;

	private String forenames;

	private String surname;

	public String getBank() {
		return bank;
	}

	public void setBank(String bank) {
		this.bank = bank;
	}

	public Long getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(Long accountNumber) {
		this.accountNumber = accountNumber;
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

	public Set<BankCardDTO> getBankCardDTOs() {
		return bankCardDTOs;
	}

	public void setBankcardDTOs(Set<BankCardDTO> bankCardDTOs) {
		this.bankCardDTOs = bankCardDTOs;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((accountNumber == null) ? 0 : accountNumber.hashCode());
		result = prime * result + ((bank == null) ? 0 : bank.hashCode());
		result = prime * result + ((bankCardDTOs == null) ? 0 : bankCardDTOs.hashCode());
		result = prime * result + ((forenames == null) ? 0 : forenames.hashCode());
		result = prime * result + ((surname == null) ? 0 : surname.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PeopleBankAccountDTO other = (PeopleBankAccountDTO) obj;
		if (accountNumber == null) {
			if (other.accountNumber != null)
				return false;
		} else if (!accountNumber.equals(other.accountNumber))
			return false;
		if (bank == null) {
			if (other.bank != null)
				return false;
		} else if (!bank.equals(other.bank))
			return false;
		if (bankCardDTOs == null) {
			if (other.bankCardDTOs != null)
				return false;
		} else if (!bankCardDTOs.equals(other.bankCardDTOs))
			return false;
		if (forenames == null) {
			if (other.forenames != null)
				return false;
		} else if (!forenames.equals(other.forenames))
			return false;
		if (surname == null) {
			if (other.surname != null)
				return false;
		} else if (!surname.equals(other.surname))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "PeopleBankAccountDTO [bankCardDTOs=" + bankCardDTOs + ", bank=" + bank + ", accountNumber="
				+ accountNumber + ", forenames=" + forenames + ", surname=" + surname + "]";
	}

}
