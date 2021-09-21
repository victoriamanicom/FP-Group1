package com.example.data;

public class EPOSTransactions {

	private Long eposId;
	private String timestamp;
	private Long payeeAccount;
	private Double amount;

	public EPOSTransactions(Long eposId, String timestamp, Long payeeAccount, Double amount) {
		super();
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

	public Long getEposId() {
		return eposId;
	}

	public void setEposId(Long eposId) {
		this.eposId = eposId;
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

}
