package com.example.data;

public class BankCard {

	private Long bankCardId;
	private Long cardNumber;
	private String sortCode;
	private Long bankAccountId;
	private Long accountNumber;
	private String bank;

	public BankCard(Long cardNumber, String sortCode, Long bankAccountId, Long accountNumber, String bank) {

		super();
		this.cardNumber = cardNumber;
		this.sortCode = sortCode;
		this.bankAccountId = bankAccountId;
		this.accountNumber = accountNumber;
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

}
