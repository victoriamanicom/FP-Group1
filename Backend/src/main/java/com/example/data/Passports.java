package com.example.data;

import java.math.BigInteger;

public class Passports {

	private BigInteger passportNumber;
	private String surname;
	private String givenName;
	private String nationality;
	private String dob;
	private String sex;
	private String placeOfBirth;
	private String issuingCountry;
	private String dateOfIssue;
	private String dateOfExpiry;

	public Passports(BigInteger passportNumber, String surname, String givenName, String nationality, String dob,
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

	public BigInteger getPassportNumber() {
		return passportNumber;
	}

	public void setPassportNumber(BigInteger passportNumber) {
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
