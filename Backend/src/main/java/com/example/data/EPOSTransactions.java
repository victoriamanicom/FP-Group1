package com.example.data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "epos_transactions")
public class EPOSTransactions {

	public EPOSTransactions(Long Id, Long eposId, String timestamp, Long payeeAccount, Double amount) {
		super();
		this.Id = Id;
		this.payeeAccount = payeeAccount;
		this.amount = amount;
	}

	public EPOSTransactions(String timestamp, Long payeeAccount, Double amount) {
		super();
		this.timestamp = timestamp;
		this.payeeAccount = payeeAccount;
		this.amount = amount;
	}

	public EPOSTransactions() {
		super();
	}

	@Id
	@Column(name = "id")
	private Long Id;

	@Column(name = "timestamp")
	private String timestamp;

	@ManyToOne
	@JoinColumn(name = "epos_id", nullable = false)
	private EPOS id;

	@ManyToOne
	@JoinColumn(name = "bank_card_number", nullable = false)
	private BankCard bankCardNumber;

	@Column(name = "payee_account")
	private Long payeeAccount;

	@Column(name = "amount")
	private Double amount;

	public void setId(Long id) {
		Id = id;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	public Long getPayeeAccount() {
		return payeeAccount;
	}

	public void setPayeeAccount(Long payeeAccount) {
		this.payeeAccount = payeeAccount;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public EPOS getId() {
		return id;
	}

	public void setId(EPOS id) {
		this.id = id;
	}

	public BankCard getBankCardNumber() {
		return bankCardNumber;
	}

	public void setBankCardNumber(BankCard bankCardNumber) {
		this.bankCardNumber = bankCardNumber;
	}

}
