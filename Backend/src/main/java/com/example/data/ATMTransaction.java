package com.example.data;

public class ATMTransaction {

	private String timestamp;
	private String type;
	private Double amount;

	public ATMTransaction(String timestamp, String type, Double amount) {
		super();
		this.timestamp = timestamp;
		this.type = type;
		this.amount = amount;
	}

	public ATMTransaction() {
		super();
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

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

}
