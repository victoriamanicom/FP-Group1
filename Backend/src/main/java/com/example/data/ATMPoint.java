package com.example.data;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class ATMPoint {

	public ATMPoint(Long atmId, String operator, String streetName, String postcode, Double latitude,
			Double longitude) {

		super();
		this.atmId = atmId;
		this.operator = operator;
		this.streetName = streetName;
		this.postcode = postcode;
		this.latitude = latitude;
		this.longitude = longitude;

	}

	public ATMPoint(String operator, String streetName, String postcode, Double latitude, Double longitude) {

		super();
		this.operator = operator;
		this.streetName = streetName;
		this.postcode = postcode;
		this.latitude = latitude;
		this.longitude = longitude;

	}

	public ATMPoint() {
		super();
	}

	@Id
	@OneToMany(mappedBy = "atmId")
	private Set<ATMTransaction> ATMTransactions;

	@Column(name = "atmId")
	private Long atmId;

	@Column(name = "operator")
	private String operator;

	@Column(name = "streetName")
	private String streetName;

	@Column(name = "postcode")
	private String postcode;

	@Column(name = "latitude")
	private Double latitude;

	@Column(name = "longitude")
	private Double longitude;

	public Long getAtmId() {
		return atmId;
	}

	public void setAtmId(Long atmId) {
		this.atmId = atmId;
	}

	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	public String getStreetName() {
		return streetName;
	}

	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

	public String getPostcode() {
		return postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	public Set<ATMTransaction> getATMTransactions() {
		return ATMTransactions;
	}

	public void setAtmTransactions(Set<ATMTransaction> ATMTransactions) {
		this.ATMTransactions = ATMTransactions;
	}

}
