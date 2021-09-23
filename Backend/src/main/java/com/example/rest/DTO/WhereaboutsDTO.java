package com.example.rest.DTO;

import java.util.List;

public class WhereaboutsDTO {

	private Long bankAccountId;
	private Long cardNumber;

	private List<ATMLocationDTO> ATMLocationDTOList;
	private List<EPOSLocationDTO> EPOSLocationDTOList;

	public WhereaboutsDTO(Long bankAccountId, Long cardNumber, List<ATMLocationDTO> aTMLocationDTOList,
			List<EPOSLocationDTO> locationEposDTOList) {
		super();
		this.bankAccountId = bankAccountId;
		this.cardNumber = cardNumber;
		ATMLocationDTOList = aTMLocationDTOList;
		EPOSLocationDTOList = locationEposDTOList;
	}

	public WhereaboutsDTO() {
		super();
	}

	public Long getBankAccountId() {
		return bankAccountId;
	}

	public void setBankAccountId(Long bankAccountId) {
		this.bankAccountId = bankAccountId;
	}

	public Long getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(Long cardNumber) {
		this.cardNumber = cardNumber;
	}

	public List<ATMLocationDTO> getATMLocationDTOList() {
		return ATMLocationDTOList;
	}

	public void setATMLocationDTOList(List<ATMLocationDTO> aTMLocationDTOList) {
		ATMLocationDTOList = aTMLocationDTOList;
	}

	public List<EPOSLocationDTO> getEPOSLocationDTOList() {
		return EPOSLocationDTOList;
	}

	public void setEPOSLocationDTOList(List<EPOSLocationDTO> locationEposDTOList) {
		EPOSLocationDTOList = locationEposDTOList;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ATMLocationDTOList == null) ? 0 : ATMLocationDTOList.hashCode());
		result = prime * result + ((EPOSLocationDTOList == null) ? 0 : EPOSLocationDTOList.hashCode());
		result = prime * result + ((bankAccountId == null) ? 0 : bankAccountId.hashCode());
		result = prime * result + ((cardNumber == null) ? 0 : cardNumber.hashCode());
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
		WhereaboutsDTO other = (WhereaboutsDTO) obj;
		if (ATMLocationDTOList == null) {
			if (other.ATMLocationDTOList != null)
				return false;
		} else if (!ATMLocationDTOList.equals(other.ATMLocationDTOList))
			return false;
		if (EPOSLocationDTOList == null) {
			if (other.EPOSLocationDTOList != null)
				return false;
		} else if (!EPOSLocationDTOList.equals(other.EPOSLocationDTOList))
			return false;
		if (bankAccountId == null) {
			if (other.bankAccountId != null)
				return false;
		} else if (!bankAccountId.equals(other.bankAccountId))
			return false;
		if (cardNumber == null) {
			if (other.cardNumber != null)
				return false;
		} else if (!cardNumber.equals(other.cardNumber))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "WhereaboutsDTO [bankAccountId=" + bankAccountId + ", cardNumber=" + cardNumber + ", ATMLocationDTOList="
				+ ATMLocationDTOList + ", EPOSLocationDTOList=" + EPOSLocationDTOList + "]";
	}

}