package com.example.rest.DTO;

public class CitizenReturnDTO {

	private String citizenID;
	private String forenames;
	private String surname;
	private String homeAddress;
	private String dateOfBirth;
	private String placeOfBirth;
	private String sex;

	public CitizenReturnDTO(String citizenID, String forenames, String surname, String homeAddress, String dateOfBirth,
			String placeOfBirth, String sex) {
		super();
		this.citizenID = citizenID;
		this.forenames = forenames;
		this.surname = surname;
		this.homeAddress = homeAddress;
		this.dateOfBirth = dateOfBirth;
		this.placeOfBirth = placeOfBirth;
		this.sex = sex;
	}

	public CitizenReturnDTO() {
		super();
	}

	public String getForenames() {
		return forenames;
	}

	public void setForenames(String forenames) {
		this.forenames = forenames;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
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

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getCitizenID() {
		return citizenID;
	}

	public void setCitizenID(String citizenID) {
		this.citizenID = citizenID;
	}

	public String getPlaceOfBirth() {
		return placeOfBirth;
	}

	public void setPlaceOfBirth(String placeOfBirth) {
		this.placeOfBirth = placeOfBirth;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dateOfBirth == null) ? 0 : dateOfBirth.hashCode());
		result = prime * result + ((forenames == null) ? 0 : forenames.hashCode());
		result = prime * result + ((homeAddress == null) ? 0 : homeAddress.hashCode());
		result = prime * result + ((surname == null) ? 0 : surname.hashCode());
		result = prime * result + ((sex == null) ? 0 : sex.hashCode());
		result = prime * result + ((citizenID == null) ? 0 : citizenID.hashCode());
		result = prime * result + ((placeOfBirth == null) ? 0 : placeOfBirth.hashCode());
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
		CitizenReturnDTO other = (CitizenReturnDTO) obj;
		if (dateOfBirth == null) {
			if (other.dateOfBirth != null)
				return false;
		} else if (!dateOfBirth.equals(other.dateOfBirth))
			return false;
		if (forenames == null) {
			if (other.forenames != null)
				return false;
		} else if (!forenames.equals(other.forenames))
			return false;
		if (homeAddress == null) {
			if (other.homeAddress != null)
				return false;
		} else if (!homeAddress.equals(other.homeAddress))
			return false;
		if (surname == null) {
			if (other.surname != null)
				return false;
		} else if (!surname.equals(other.surname))
			return false;
		if (sex == null) {
			if (other.sex != null)
				return false;
		} else if (!sex.equals(other.sex))
			return false;
		if (citizenID == null) {
			if (other.citizenID != null)
				return false;
		} else if (!citizenID.equals(other.citizenID))
			return false;
		if (placeOfBirth == null) {
			if (other.placeOfBirth != null)
				return false;
		} else if (!placeOfBirth.equals(other.placeOfBirth))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "CitizenReturnDTO [citizenID=" + citizenID + ", forenames=" + forenames + ", surname=" + surname
				+ ", homeAddress=" + homeAddress + ", dateOfBirth=" + dateOfBirth + ", placeOfBirth=" + placeOfBirth
				+ ", sex=" + sex + "]";
	}

}
