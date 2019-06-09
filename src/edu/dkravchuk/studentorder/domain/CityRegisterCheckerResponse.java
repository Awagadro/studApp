package edu.dkravchuk.studentorder.domain;

public class CityRegisterCheckerResponse {
	private boolean isExisting;
	private Boolean isTemporal;
	public boolean isExisting() {
		return isExisting;
	}
	public void setExisting(boolean isExisting) {
		this.isExisting = isExisting;
	}
	public Boolean getIsTemporal() {
		return isTemporal;
	}
	public void setIsTemporal(Boolean isTemporal) {
		this.isTemporal = isTemporal;
	}
	
	
}
