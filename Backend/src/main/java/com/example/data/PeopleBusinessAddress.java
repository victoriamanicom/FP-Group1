package com.example.data;

public class PeopleBusinessAddress {

	private String personName;
	private String homeAddress;
	private String dateOfBirth;
	private String businessName;
	private String businessAddress;

	public PeopleBusinessAddress(String personName, String homeAddress, String dateOfBirth, String businessName,
			String businessAddress) {
		super();
		this.personName = personName;
		this.homeAddress = homeAddress;
		this.dateOfBirth = dateOfBirth;
		this.businessName = businessName;
		this.businessAddress = businessAddress;
	}

	public PeopleBusinessAddress() {
		super();
	}

	public String getPersonName() {
		return personName;
	}

	public void setPersonName(String personName) {
		this.personName = personName;
	}

	public String getHomeAddress() {
		return homeAddress;
	}

	public void setHomeAddress(String homeAddress) {
		this.homeAddress = homeAddress;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
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

}
