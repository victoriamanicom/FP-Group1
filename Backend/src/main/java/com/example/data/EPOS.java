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

	public EPOS(Long id, String vendor, String streetName, String postcode, Double latitude, Double longitude) {

		super();
		this.id = id;
		this.vendor = vendor;
		this.streetName = streetName;
		this.postcode = postcode;
		this.latitude = latitude;
		this.longitude = longitude;

	}

	public EPOS(String vendor, String streetName, String postcode, Double latitude, Double longitude) {

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
	private Double latitude;

	@Column(name = "longitude")
	private Double longitude;

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

	public Set<EPOSTransactions> getEPOSTransactions() {
		return EPOSTransactions;
	}

	public void setEposTransactions(Set<EPOSTransactions> EPOSTransactions) {
		this.EPOSTransactions = EPOSTransactions;
	}

}
