package edu.dkravchuk.studentorder.domain;

public class Address {
	private String postCode;
	private String street;
	private String buildung;
	private String extension;
	private String apartment;

	public String getPostCode() {
		return postCode;
	}

	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getBuildung() {
		return buildung;
	}

	public void setBuildung(String buildung) {
		this.buildung = buildung;
	}

	public String getExtension() {
		return extension;
	}

	public void setExtension(String extension) {
		this.extension = extension;
	}

	public String getApartment() {
		return apartment;
	}

	public void setApartment(String apartment) {
		this.apartment = apartment;
	}

}
