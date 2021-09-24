package com.example.rest.DTO;

import java.util.List;

public class AssociatesDTO {

	public AssociatesDTO(List<PeopleMobileDTO> callRecords, String businessName, String businessAddress,
			List<ColleguesDTO> collegues, List<LivingWithDTO> livingWith) {
		super();
		this.callRecords = callRecords;
		this.businessName = businessName;
		this.businessAddress = businessAddress;
		this.collegues = collegues;
		this.livingWith = livingWith;
	}

	public AssociatesDTO() {
		super();
	}

	private List<PeopleMobileDTO> callRecords;

	private String businessName;

	private String businessAddress;

	private List<ColleguesDTO> collegues;

	private List<LivingWithDTO> livingWith;

	public List<PeopleMobileDTO> getCallRecords() {
		return callRecords;
	}

	public void setCallRecords(List<PeopleMobileDTO> callRecords) {
		this.callRecords = callRecords;
	}

	public String getBusinessName() {
		return businessName;
	}

	public void setBusinessName(String businessName) {
		this.businessName = businessName;
	}

	public String getBusinessAddress() {
		return businessAddress;
	}

	public void setBusinessAddress(String businessAddress) {
		this.businessAddress = businessAddress;
	}

	public List<ColleguesDTO> getCollegues() {
		return collegues;
	}

	public void setColleagues(List<ColleguesDTO> collegues) {
		this.collegues = collegues;
	}

	public List<LivingWithDTO> getLivingWith() {
		return livingWith;
	}

	public void setHousehold(List<LivingWithDTO> peopleLivingWith) {
		this.livingWith = peopleLivingWith;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((businessAddress == null) ? 0 : businessAddress.hashCode());
		result = prime * result + ((businessName == null) ? 0 : businessName.hashCode());
		result = prime * result + ((callRecords == null) ? 0 : callRecords.hashCode());
		result = prime * result + ((collegues == null) ? 0 : collegues.hashCode());
		result = prime * result + ((livingWith == null) ? 0 : livingWith.hashCode());
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
		AssociatesDTO other = (AssociatesDTO) obj;
		if (businessAddress == null) {
			if (other.businessAddress != null)
				return false;
		} else if (!businessAddress.equals(other.businessAddress))
			return false;
		if (businessName == null) {
			if (other.businessName != null)
				return false;
		} else if (!businessName.equals(other.businessName))
			return false;
		if (callRecords == null) {
			if (other.callRecords != null)
				return false;
		} else if (!callRecords.equals(other.callRecords))
			return false;
		if (collegues == null) {
			if (other.collegues != null)
				return false;
		} else if (!collegues.equals(other.collegues))
			return false;
		if (livingWith == null) {
			if (other.livingWith != null)
				return false;
		} else if (!livingWith.equals(other.livingWith))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "AssociatesDTO [callRecords=" + callRecords + ", businessName=" + businessName + ", businessAddress="
				+ businessAddress + ", colleagues=" + collegues + ", household=" + livingWith + "]";
	}

}
