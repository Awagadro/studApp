package edu.dkravchuk.studentorder.domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class StudentOrder {

	private long studentOrderId;
	private Adult husband;
	private Adult wife;
	private List<Child> children;
	private String marriageCertificateId;
	private LocalDate marriageDate;
	private RegisterOffice registerOffice;

	public String getMarriageCertificateId() {
		return marriageCertificateId;
	}

	public void setMarriageCertificateId(String string) {
		this.marriageCertificateId = string;
	}

	public LocalDate getMarriageDate() {
		return marriageDate;
	}

	public void setMarriageDate(LocalDate marriageDate) {
		this.marriageDate = marriageDate;
	}


	public RegisterOffice getRegisterOffice() {
		return registerOffice;
	}

	public void setRegisterOffice(RegisterOffice registerOffice) {
		this.registerOffice = registerOffice;
	}

	public long getStudentOrderId() {
		return studentOrderId;
	}

	public void setStudentOrderId(long studentOrderId) {
		this.studentOrderId = studentOrderId;
	}

	public Adult getHusband() {
		return husband;
	}

	public void setHusband(Adult husband) {
		this.husband = husband;
	}

	public Adult getWife() {
		return wife;
	}

	public void setWife(Adult wife) {
		this.wife = wife;
	}

	public List<Child> getChildren() {
		return children;
	}

	public void addChild(Child child) {
		if (children == null) {
			children = new ArrayList<>(5);
		}
		children.add(child);
	}

}
