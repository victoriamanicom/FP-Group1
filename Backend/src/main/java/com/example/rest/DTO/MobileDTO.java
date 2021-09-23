package com.example.rest.DTO;

public class MobileDTO {

	private String phoneNumber;
	private String network;
	private String timestamp;
	private String receiverMSISN;
	private String forenames;
	private String surname;

	public MobileDTO(String phoneNumber, String network, String timestamp, String receiverMSISN, String forenames,
			String surname) {

		super();
		this.phoneNumber = phoneNumber;
		this.network = network;
		this.timestamp = timestamp;
		this.receiverMSISN = receiverMSISN;
		this.forenames = forenames;
		this.surname = surname;

	}

	public MobileDTO() {
		super();
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getNetwork() {
		return network;
	}

	public void setNetwork(String network) {
		this.network = network;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	public String getReceiverMSISN() {
		return receiverMSISN;
	}

	public void setReceiverMSISN(String receiverMSISN) {
		this.receiverMSISN = receiverMSISN;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((phoneNumber == null) ? 0 : phoneNumber.hashCode());
		result = prime * result + ((network == null) ? 0 : network.hashCode());
		result = prime * result + ((timestamp == null) ? 0 : timestamp.hashCode());
		result = prime * result + ((receiverMSISN == null) ? 0 : receiverMSISN.hashCode());
		result = prime * result + ((forenames == null) ? 0 : forenames.hashCode());
		result = prime * result + ((surname == null) ? 0 : surname.hashCode());
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
		MobileDTO other = (MobileDTO) obj;
		if (phoneNumber == null) {
			if (other.phoneNumber != null)
				return false;
		} else if (!phoneNumber.equals(other.phoneNumber))
			return false;
		if (network == null) {
			if (other.network != null)
				return false;
		} else if (!network.equals(other.network))
			return false;
		if (timestamp == null) {
			if (other.timestamp != null)
				return false;
		} else if (!timestamp.equals(other.timestamp))
			return false;
		if (receiverMSISN == null) {
			if (other.receiverMSISN != null)
				return false;
		} else if (!receiverMSISN.equals(other.receiverMSISN))
			return false;
		if (forenames == null) {
			if (other.forenames != null)
				return false;
		} else if (!forenames.equals(other.forenames))
			return false;
		if (surname == null) {
			if (other.surname != null)
				return false;
		} else if (!surname.equals(other.surname))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "MobileDTO [phoneNumber=" + phoneNumber + ", network=" + network + ", timestamp=" + timestamp
				+ ", receiverMSISN=" + receiverMSISN + ", forenames=" + forenames + ", surname=" + surname + "]";
	}

}
