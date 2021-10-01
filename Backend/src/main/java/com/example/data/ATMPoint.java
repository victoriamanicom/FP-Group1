package com.example.data;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "atm_point")
public class ATMPoint {

	public ATMPoint(Integer atmId, String operator, String streetName, String postcode, java.math.BigDecimal latitude,
			java.math.BigDecimal longitude) {

		super();
		this.atmId = atmId;
		this.operator = operator;
		this.streetName = streetName;
		this.postcode = postcode;
		this.latitude = latitude;
		this.longitude = longitude;

	}

	public ATMPoint(String operator, String streetName, String postcode, java.math.BigDecimal latitude,
			java.math.BigDecimal longitude) {

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

	@OneToMany(mappedBy = "atmId")
	private Set<ATMTransaction> ATMTransactions;

	@Id
	@Column(name = "atm_id")
	private Integer atmId;

	@Column(name = "operator")
	private String operator;

	@Column(name = "street_name")
	private String streetName;

	@Column(name = "postcode")
	private String postcode;

	@Column(name = "latitude")
	private java.math.BigDecimal latitude;

	@Column(name = "longitude")
	private java.math.BigDecimal longitude;

	public Integer getAtmId() {
		return atmId;
	}

	public void setAtmId(Integer atmId) {
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

	public java.math.BigDecimal getLatitude() {
		return latitude;
	}

	public void setLatitude(java.math.BigDecimal latitude) {
		this.latitude = latitude;
	}

	public java.math.BigDecimal getLongitude() {
		return longitude;
	}

	public void setLongitude(java.math.BigDecimal longitude) {
		this.longitude = longitude;
	}

	public Set<ATMTransaction> getATMTransactions() {
		return ATMTransactions;
	}

	public void setAtmTransaction(Set<ATMTransaction> ATMTransactions) {
		this.ATMTransactions = ATMTransactions;
	}

}
