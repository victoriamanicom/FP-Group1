package com.example.rest.DTO;

public class ATMLocationDTO {

	private String timestamp;
	private String atmId;
	private String operator;
	private String streetName;
	private String postcode;
	private java.math.BigDecimal latitude;
	private java.math.BigDecimal longitude;

	public ATMLocationDTO(String timestamp, String atmId, String operator, String streetName, String postcode,
			java.math.BigDecimal latitude, java.math.BigDecimal longitude) {

		super();
		this.timestamp = timestamp;
		this.atmId = atmId;
		this.operator = operator;
		this.streetName = streetName;
		this.postcode = postcode;
		this.latitude = latitude;
		this.longitude = longitude;

	}

	public ATMLocationDTO() {
		super();
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	public String getAtmId() {
		return atmId;
	}

	public void setAtmId(String atmId) {
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((atmId == null) ? 0 : atmId.hashCode());
		result = prime * result + ((latitude == null) ? 0 : latitude.hashCode());
		result = prime * result + ((longitude == null) ? 0 : longitude.hashCode());
		result = prime * result + ((operator == null) ? 0 : operator.hashCode());
		result = prime * result + ((postcode == null) ? 0 : postcode.hashCode());
		result = prime * result + ((streetName == null) ? 0 : streetName.hashCode());
		result = prime * result + ((timestamp == null) ? 0 : timestamp.hashCode());
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
		ATMLocationDTO other = (ATMLocationDTO) obj;
		if (atmId == null) {
			if (other.atmId != null)
				return false;
		} else if (!atmId.equals(other.atmId))
			return false;
		if (latitude == null) {
			if (other.latitude != null)
				return false;
		} else if (!latitude.equals(other.latitude))
			return false;
		if (longitude == null) {
			if (other.longitude != null)
				return false;
		} else if (!longitude.equals(other.longitude))
			return false;
		if (operator == null) {
			if (other.operator != null)
				return false;
		} else if (!operator.equals(other.operator))
			return false;
		if (postcode == null) {
			if (other.postcode != null)
				return false;
		} else if (!postcode.equals(other.postcode))
			return false;
		if (streetName == null) {
			if (other.streetName != null)
				return false;
		} else if (!streetName.equals(other.streetName))
			return false;
		if (timestamp == null) {
			if (other.timestamp != null)
				return false;
		} else if (!timestamp.equals(other.timestamp))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ATMLocationDTO [timestamp=" + timestamp + ", atmId=" + atmId + ", operator=" + operator
				+ ", streetName=" + streetName + ", postcode=" + postcode + ", latitude=" + latitude + ", longitude="
				+ longitude + "]";
	}

}