package com.example.data;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "epos")
public class EPOS {

	public EPOS(Long id, String vendor, String streetName, String postcode, java.math.BigDecimal latitude,
			java.math.BigDecimal longitude) {

		super();
		this.id = id;
		this.vendor = vendor;
		this.streetName = streetName;
		this.postcode = postcode;
		this.latitude = latitude;
		this.longitude = longitude;

	}

	public EPOS(String vendor, String streetName, String postcode, java.math.BigDecimal latitude,
			java.math.BigDecimal longitude) {

		super();
		this.vendor = vendor;
		this.streetName = streetName;
		this.postcode = postcode;
		this.latitude = latitude;
		this.longitude = longitude;

	}

	public EPOS() {
		super();
	}

	@OneToMany(mappedBy = "id")
	private Set<EPOSTransactions> EPOSTransactions;

	@Id
	@Column(name = "id")
	private Long id;

	@Column(name = "vendor")
	private String vendor;

	@Column(name = "street_name")
	private String streetName;

	@Column(name = "postcode")
	private String postcode;

	@Column(name = "latitude")
	private java.math.BigDecimal latitude;

	@Column(name = "longitude")
	private java.math.BigDecimal longitude;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getVendor() {
		return vendor;
	}

	public void setVendor(String vendor) {
		this.vendor = vendor;
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

	public Set<EPOSTransactions> getEPOSTransactions() {
		return EPOSTransactions;
	}

	public void setEposTransactions(Set<EPOSTransactions> EPOSTransactions) {
		this.EPOSTransactions = EPOSTransactions;
	}

}
