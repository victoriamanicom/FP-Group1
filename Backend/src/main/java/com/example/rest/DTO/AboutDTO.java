package com.example.rest.DTO;

public class AboutDTO {

	private String vehicleRegistrationNo;
	private String phoneNumber;
	private String businessName;
	private String businessAddress;

	public AboutDTO(String vehicleRegistrationNo, String phoneNumber, String businessName, String businessAddress) {

		super();
		this.vehicleRegistrationNo = vehicleRegistrationNo;
		this.phoneNumber = phoneNumber;
		this.businessName = businessName;
		this.businessAddress = businessAddress;

	}

	public AboutDTO() {
		super();
	}

	public String getVehicleRegistrationNo() {
		return vehicleRegistrationNo;
	}

	public void setVehicleRegistrationNo(String vehicleRegistrationNo) {
		this.vehicleRegistrationNo = vehicleRegistrationNo;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((vehicleRegistrationNo == null) ? 0 : vehicleRegistrationNo.hashCode());
		result = prime * result + ((phoneNumber == null) ? 0 : phoneNumber.hashCode());
		result = prime * result + ((businessName == null) ? 0 : businessName.hashCode());
		result = prime * result + ((businessAddress == null) ? 0 : businessAddress.hashCode());
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
		AboutDTO other = (AboutDTO) obj;
		if (vehicleRegistrationNo == null) {
			if (other.vehicleRegistrationNo != null)
				return false;
		} else if (!vehicleRegistrationNo.equals(other.vehicleRegistrationNo))
			return false;
		if (phoneNumber == null) {
			if (other.phoneNumber != null)
				return false;
		} else if (!phoneNumber.equals(other.phoneNumber))
			return false;
		if (businessName == null) {
			if (other.businessName != null)
				return false;
		} else if (!businessName.equals(other.businessName))
			return false;
		if (businessAddress == null) {
			if (other.businessAddress != null)
				return false;
		} else if (!businessAddress.equals(other.businessAddress))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "AboutDTO [vehicleRegistrationNo=" + vehicleRegistrationNo + ", phoneNumber=" + phoneNumber
				+ ", businessName=" + businessName + ", businessAddress=" + businessAddress + "]";
	}

}
