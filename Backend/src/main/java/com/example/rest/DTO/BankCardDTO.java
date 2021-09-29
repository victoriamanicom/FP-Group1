package com.example.rest.DTO;

import java.util.List;
import java.util.Set;

public class BankCardDTO {

	public BankCardDTO(String sortCode, List<ATMTransactionDTO> atmTransactions,
			List<EPOSTransactionsDTO> eposTransactions) {
		super();
		this.sortCode = sortCode;
		ATMTransaction = atmTransactions;
		EPOSTransactions = eposTransactions;
	}

	public BankCardDTO(String sortCode) {
		super();
		this.sortCode = sortCode;
	}

	public BankCardDTO() {
		super();
	}

	private String sortCode;

	private List<ATMTransactionDTO> ATMTransaction;

	private List<EPOSTransactionsDTO> EPOSTransactions;

	public String getSortCode() {
		return sortCode;
	}

	public void setSortCode(String sortCode) {
		this.sortCode = sortCode;
	}

	public List<ATMTransactionDTO> getATMTransaction() {
		return ATMTransaction;
	}

	public void setATMTransaction(List<ATMTransactionDTO> atmTransactions) {
		ATMTransaction = atmTransactions;
	}

	public List<EPOSTransactionsDTO> getEPOSTransactions() {
		return EPOSTransactions;
	}

	public void setEPOSTransactions(List<EPOSTransactionsDTO> eposTransactions) {
		EPOSTransactions = eposTransactions;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ATMTransaction == null) ? 0 : ATMTransaction.hashCode());
		result = prime * result + ((EPOSTransactions == null) ? 0 : EPOSTransactions.hashCode());
		result = prime * result + ((sortCode == null) ? 0 : sortCode.hashCode());
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
		BankCardDTO other = (BankCardDTO) obj;
		if (ATMTransaction == null) {
			if (other.ATMTransaction != null)
				return false;
		} else if (!ATMTransaction.equals(other.ATMTransaction))
			return false;
		if (EPOSTransactions == null) {
			if (other.EPOSTransactions != null)
				return false;
		} else if (!EPOSTransactions.equals(other.EPOSTransactions))
			return false;
		if (sortCode == null) {
			if (other.sortCode != null)
				return false;
		} else if (!sortCode.equals(other.sortCode))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "BankCardDTO [sortCode=" + sortCode + ", ATMTransaction=" + ATMTransaction + ", EPOSTransactions="
				+ EPOSTransactions + "]";
	}

}
