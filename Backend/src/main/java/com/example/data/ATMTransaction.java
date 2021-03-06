package com.example.data;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "atm_transaction")
public class ATMTransaction implements Serializable {

	public ATMTransaction(Long Id, String timestamp, String type, java.math.BigDecimal amount) {

		super();
		this.Id = Id;
		this.timestamp = timestamp;
		this.type = type;
		this.amount = amount;

	}

	public ATMTransaction() {
		super();
	}

	@ManyToOne
	@JoinColumn(name = "atm_id", nullable = false)
	private ATMPoint atmId;

	@ManyToOne
	@JoinColumn(name = "card_number", referencedColumnName = "card_number", nullable = false)
	private BankCard cardNumber;

	@Id
	@Column(name = "id")
	private Long Id;

	@Column(name = "timestamp")
	private String timestamp;

	@Column(name = "type")
	private String type;

	@Column(name = "amount")
	private java.math.BigDecimal amount;

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public java.math.BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(java.math.BigDecimal amount) {
		this.amount = amount;
	}

	public ATMPoint getAtmId() {
		return atmId;
	}

	public void setAtmId(ATMPoint atmId) {
		this.atmId = atmId;
	}

	public BankCard getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(BankCard cardNumber) {
		this.cardNumber = cardNumber;
	}

}
