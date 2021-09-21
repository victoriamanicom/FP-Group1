package com.example.data;

public class EPOS {

	private Long id;
	private String vendor;
	private String streetName;
	private String postcode;
	private Double latitude;
	private Double longitude;

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

}
