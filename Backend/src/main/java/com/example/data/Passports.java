package com.example.data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "passport")
public class Passports {

	public Passports(Integer passportNumber, String surname, String givenName, String nationality, String dob,
			String sex, String placeOfBirth, String issuingCountry, String dateOfIssue, String dateOfExpiry) {

		super();
		this.passportNumber = passportNumber;
		this.surname = surname;
		this.givenName = givenName;
		this.nationality = nationality;
		this.dob = dob;
		this.sex = sex;
		this.placeOfBirth = placeOfBirth;
		this.issuingCountry = issuingCountry;
		this.dateOfIssue = dateOfIssue;
		this.dateOfExpiry = dateOfExpiry;

	}

	public Passports(String surname, String givenName, String nationality, String dob, String sex, String placeOfBirth,
			String issuingCountry, String dateOfIssue, String dateOfExpiry) {

		super();
		this.surname = surname;
		this.givenName = givenName;
		this.nationality = nationality;
		this.dob = dob;
		this.sex = sex;
		this.placeOfBirth = placeOfBirth;
		this.issuingCountry = issuingCountry;
		this.dateOfIssue = dateOfIssue;
		this.dateOfExpiry = dateOfExpiry;

	}

	public Passports() {
		super();
	}

	@Id
	@Column(name = "passport_number")
	private Integer passportNumber;

	@Column(name = "surname")
	private String surname;

	@Column(name = "given_name")
	private String givenName;

	@Column(name = "nationality")
	private String nationality;

	@Column(name = "dob")
	private String dob;

	@Column(name = "sex")
	private String sex;

	@Column(name = "place_of_birth")
	private String placeOfBirth;

	@Column(name = "issuing_country")
	private String issuingCountry;

	@Column(name = "date_of_issue")
	private String dateOfIssue;

	@Column(name = "date_of_expiry")
	private String dateOfExpiry;

	public Integer getPassportNumber() {
		return passportNumber;
	}

	public void setPassportNumber(Integer passportNumber) {
		this.passportNumber = passportNumber;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getGivenName() {
		return givenName;
	}

	public void setGivenName(String givenName) {
		this.givenName = givenName;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getPlaceOfBirth() {
		return placeOfBirth;
	}

	public void setPlaceOfBirth(String placeOfBirth) {
		this.placeOfBirth = placeOfBirth;
	}

	public String getIssuingCountry() {
		return issuingCountry;
	}

	public void setIssuingCountry(String issuingCountry) {
		this.issuingCountry = issuingCountry;
	}

	public String getDateOfIssue() {
		return dateOfIssue;
	}

	public void setDateOfIssue(String dateOfIssue) {
		this.dateOfIssue = dateOfIssue;
	}

	public String getDateOfExpiry() {
		return dateOfExpiry;
	}

	public void setDateOfExpiry(String dateOfExpiry) {
		this.dateOfExpiry = dateOfExpiry;
	}

}
