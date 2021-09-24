package com.example.rest.DTO;

import java.util.Set;

public class MainDTO {

	private String CitizenID;
	private Set<AssociatesDTO> associatesDTO;
	private Set<WhereaboutsDTO> whereaboutsDTO;
	private Set<VehicleDTO> vehiclesDTO;
	private Set<PeopleMobileDTO> peopleMobileDTO;
	private Set<CitizenReturnDTO> citizenReturnDTO;
	private Set<PeopleBankAccountDTO> peopleBankAccountDTO;

	public MainDTO(String CitizenID, Set<AssociatesDTO> associatesDTO, Set<WhereaboutsDTO> whereaboutsDTO,
			Set<VehicleDTO> vehiclesDTO, Set<PeopleMobileDTO> peopleMobileDTO, Set<CitizenReturnDTO> citizenReturnDTO,
			Set<PeopleBankAccountDTO> peopleBankAccountDTO) {

		super();
		this.CitizenID = CitizenID;
		this.associatesDTO = associatesDTO;
		this.whereaboutsDTO = whereaboutsDTO;
		this.vehiclesDTO = vehiclesDTO;
		this.peopleMobileDTO = peopleMobileDTO;
		this.citizenReturnDTO = citizenReturnDTO;
		this.peopleBankAccountDTO = peopleBankAccountDTO;

	}

	public String getCitizenID() {
		return CitizenID;
	}

	public void setCitizenID(String citizenID) {
		CitizenID = citizenID;
	}

	public Set<AssociatesDTO> getAssociatesDTO() {
		return associatesDTO;
	}

	public void setAssociatesDTO(Set<AssociatesDTO> associatesDTO) {
		this.associatesDTO = associatesDTO;
	}

	public Set<WhereaboutsDTO> getWhereaboutsDTO() {
		return whereaboutsDTO;
	}

	public void setWhereaboutsDTO(Set<WhereaboutsDTO> whereaboutsDTO) {
		this.whereaboutsDTO = whereaboutsDTO;
	}

	public Set<VehicleDTO> getVehiclesDTO() {
		return vehiclesDTO;
	}

	public void setVehiclesDTO(Set<VehicleDTO> vehiclesDTO) {
		this.vehiclesDTO = vehiclesDTO;
	}

	public Set<PeopleMobileDTO> getPeopleMobileDTO() {
		return peopleMobileDTO;
	}

	public void setPeopleMobileDTO(Set<PeopleMobileDTO> peopleMobileDTO) {
		this.peopleMobileDTO = peopleMobileDTO;
	}

	public Set<CitizenReturnDTO> getCitizenReturnDTO() {
		return citizenReturnDTO;
	}

	public void setCitizenReturnDTO(Set<CitizenReturnDTO> citizenReturnDTO) {
		this.citizenReturnDTO = citizenReturnDTO;
	}

	public Set<PeopleBankAccountDTO> getPeopleBankAccountDTO() {
		return peopleBankAccountDTO;
	}

	public void setPeopleBankAccountDTO(Set<PeopleBankAccountDTO> peopleBankAccountDTO) {
		this.peopleBankAccountDTO = peopleBankAccountDTO;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((CitizenID == null) ? 0 : CitizenID.hashCode());
		result = prime * result + ((associatesDTO == null) ? 0 : associatesDTO.hashCode());
		result = prime * result + ((whereaboutsDTO == null) ? 0 : whereaboutsDTO.hashCode());
		result = prime * result + ((vehiclesDTO == null) ? 0 : vehiclesDTO.hashCode());
		result = prime * result + ((peopleMobileDTO == null) ? 0 : peopleMobileDTO.hashCode());
		result = prime * result + ((citizenReturnDTO == null) ? 0 : citizenReturnDTO.hashCode());
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
		MainDTO other = (MainDTO) obj;
		if (CitizenID == null) {
			if (other.CitizenID != null)
				return false;
		} else if (!CitizenID.equals(other.CitizenID))
			return false;
		if (associatesDTO == null) {
			if (other.associatesDTO != null)
				return false;
		} else if (!associatesDTO.equals(other.associatesDTO))
			return false;
		if (whereaboutsDTO == null) {
			if (other.whereaboutsDTO != null)
				return false;
		} else if (!whereaboutsDTO.equals(other.whereaboutsDTO))
			return false;
		if (vehiclesDTO == null) {
			if (other.vehiclesDTO != null)
				return false;
		} else if (!vehiclesDTO.equals(other.vehiclesDTO))
			return false;
		if (peopleMobileDTO == null) {
			if (other.peopleMobileDTO != null)
				return false;
		} else if (!peopleMobileDTO.equals(other.peopleMobileDTO))
			return false;
		if (citizenReturnDTO == null) {
			if (other.citizenReturnDTO != null)
				return false;
		} else if (!citizenReturnDTO.equals(other.citizenReturnDTO))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "MainDTO [CitizenID=" + CitizenID + ", associatesDTO=" + associatesDTO + ", whereaboutsDTO="
				+ whereaboutsDTO + ", vehiclesDTO=" + vehiclesDTO + ", peopleMobileDTO=" + peopleMobileDTO
				+ ", citizenReturnDTO=" + citizenReturnDTO + ", peopleBankAccountDTO=" + peopleBankAccountDTO + "]";
	}

}
