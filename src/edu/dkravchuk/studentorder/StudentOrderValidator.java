package edu.dkravchuk.studentorder;

import edu.dkravchuk.studentorder.domain.AnswerChildren;
import edu.dkravchuk.studentorder.domain.AnswerCityRegister;
import edu.dkravchuk.studentorder.domain.AnswerStudent;
import edu.dkravchuk.studentorder.domain.AnswerWedding;
import edu.dkravchuk.studentorder.domain.StudentOrder;
import edu.dkravchuk.studentorder.exception.CityRegisterExsception;
import edu.dkravchuk.studentorder.mail.MailSender;
import edu.dkravchuk.studentorder.validator.ChildrenValidator;
import edu.dkravchuk.studentorder.validator.CityRegisterValidator;
import edu.dkravchuk.studentorder.validator.StudentValidator;
import edu.dkravchuk.studentorder.validator.WeddingValidator;

public class StudentOrderValidator {
	private CityRegisterValidator cityRegisterVal;
	private WeddingValidator weddingVal;
	private ChildrenValidator childrenVal;
	private StudentValidator studentVal;
	private MailSender mailSender;

	public StudentOrderValidator() {
		cityRegisterVal = new CityRegisterValidator();
		weddingVal = new WeddingValidator();
		childrenVal = new ChildrenValidator();
		studentVal = new StudentValidator();
		mailSender = new MailSender();
	}

	public static void main(String[] args) throws CityRegisterExsception {

		StudentOrderValidator sov = new StudentOrderValidator();
		sov.checkAll();

	}

	public void checkAll() throws CityRegisterExsception {
		StudentOrder[] soArray = readStudentOrders();

		// for (int c = 0; c < soArray.length; c++) {
		// System.out.println();
		// checkOneOrder(soArray[c]);
		// }

		for (StudentOrder so : soArray) {
			System.out.println();
			checkOneOrder(so);
		}

	}

	public StudentOrder[] readStudentOrders() {
		StudentOrder[] soArray = new StudentOrder[3];
		for (int c = 0; c < soArray.length; c++) {
			soArray[c] = SaveStudentOrder.buildStudentOrder(c);
		}

		return soArray;
	}

	public void checkOneOrder(StudentOrder so) throws CityRegisterExsception {
		AnswerCityRegister cityAnswer = checkCityRegister(so);
		AnswerWedding wedAnswer = checkWedding(so);
		AnswerChildren childAnswer = checkChildren(so);
		AnswerStudent studentAnswer = checkStudent(so);
		sendMail(so);
	}

	public void sendMail(StudentOrder so) {
		mailSender.sendMail(so);
		;
	}

	public AnswerStudent checkStudent(StudentOrder so) {
		return studentVal.checkStudent(so);
	}

	public AnswerChildren checkChildren(StudentOrder so) {
		return childrenVal.checkChildren(so);
	}

	public AnswerWedding checkWedding(StudentOrder so) {
		return weddingVal.checkWedding(so);
	}

	public AnswerCityRegister checkCityRegister(StudentOrder so) throws CityRegisterExsception {
		return cityRegisterVal.checkCityRegister(so);
	}

}
