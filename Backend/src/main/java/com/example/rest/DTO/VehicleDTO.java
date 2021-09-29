package com.example.rest.DTO;

import java.time.LocalDateTime;

public class VehicleDTO {

	private LocalDateTime registrationDate;
	private String make;
	private String model;
	private String colour;
	private String vehicleRegistrationNo;
	private String driverLicenceId;

	public VehicleDTO(LocalDateTime registrationDate, String make, String model, String colour,
			String vehicleRegistrationNo, String driverLicenceId) {
		super();
		this.registrationDate = registrationDate;
		this.make = make;
		this.model = model;
		this.colour = colour;
		this.vehicleRegistrationNo = vehicleRegistrationNo;
		this.driverLicenceId = driverLicenceId;
	}

	public VehicleDTO() {
		super();
	}

	public String getDriverLicenceId() {
		return driverLicenceId;
	}

	public void setDriverLicenceId(String driverLicenceId) {
		this.driverLicenceId = driverLicenceId;
	}

	public LocalDateTime getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(LocalDateTime registrationDate) {
		this.registrationDate = registrationDate;
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getColour() {
		return colour;
	}

	public void setColour(String colour) {
		this.colour = colour;
	}

	public String getVehicleRegistrationNo() {
		return vehicleRegistrationNo;
	}

	public void setVehicleRegistrationNo(String vehicleRegistrationNo) {
		this.vehicleRegistrationNo = vehicleRegistrationNo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((registrationDate == null) ? 0 : registrationDate.hashCode());
		result = prime * result + ((make == null) ? 0 : make.hashCode());
		result = prime * result + ((model == null) ? 0 : model.hashCode());
		result = prime * result + ((colour == null) ? 0 : colour.hashCode());
		result = prime * result + ((vehicleRegistrationNo == null) ? 0 : vehicleRegistrationNo.hashCode());
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
		VehicleDTO other = (VehicleDTO) obj;
		if (registrationDate == null) {
			if (other.registrationDate != null)
				return false;
		} else if (!registrationDate.equals(other.registrationDate))
			return false;
		if (make == null) {
			if (other.make != null)
				return false;
		} else if (!make.equals(other.make))
			return false;
		if (model == null) {
			if (other.model != null)
				return false;
		} else if (!model.equals(other.model))
			return false;
		if (colour == null) {
			if (other.colour != null)
				return false;
		} else if (!colour.equals(other.colour))
			return false;
		if (vehicleRegistrationNo == null) {
			if (other.vehicleRegistrationNo != null)
				return false;
		} else if (!vehicleRegistrationNo.equals(other.vehicleRegistrationNo))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "VehicleDTO [registrationDate=" + registrationDate + ", make=" + make + ", model=" + model + ", colour="
				+ colour + ", vehicleRegistrationNo=" + vehicleRegistrationNo + "]";
	}

}
