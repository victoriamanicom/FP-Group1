package com.example.data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "people_business_address")
public class PeopleBusinessAddress {

	public PeopleBusinessAddress(Long id, String personName, String homeAddress, String dateOfBirth,
			String businessName, String businessAddress) {
		super();
		this.id = id;
		this.personName = personName;
		this.homeAddress = homeAddress;
		this.dateOfBirth = dateOfBirth;
		this.businessName = businessName;
		this.businessAddress = businessAddress;
	}

	public PeopleBusinessAddress() {
		super();
	}

	@Id
	@Column(name = "id")
	private Long id;

	@Column(name = "person_name")
	private String personName;

	@Column(name = "home_address")
	private String homeAddress;

	@Column(name = "date_of_birth")
	private String dateOfBirth;

	@Column(name = "business_name")
	private String businessName;

	@Column(name = "business_address")
	private String businessAddress;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
