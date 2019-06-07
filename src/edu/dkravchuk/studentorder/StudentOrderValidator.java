package edu.dkravchuk.studentorder;

import edu.dkravchuk.studentorder.domain.AnswerChildren;
import edu.dkravchuk.studentorder.domain.AnswerCityRegister;
import edu.dkravchuk.studentorder.domain.AnswerStudent;
import edu.dkravchuk.studentorder.domain.AnswerWedding;
import edu.dkravchuk.studentorder.domain.StudentOrder;
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

	public static void main(String[] args) {
		
		StudentOrderValidator sov = new StudentOrderValidator();
		sov.checkAll();

	}

	public void checkAll() {
		while (true) {
			StudentOrder so = readStudentOrder();
			if (so == null) {
				break;
			}
			AnswerCityRegister cityAnswer = checkCityRegister(so);
			if (!cityAnswer.success) {
				continue;
			}
			AnswerWedding wedAnswer = checkWedding(so);
			AnswerChildren childAnswer = checkChildren(so);
			checkStudent(so);

			sendMail(so);
		}
	}

	public void sendMail(StudentOrder so) {
		mailSender.sendMail(so);
		;
	}

	public StudentOrder readStudentOrder() {
		SaveStudentOrder.buildStudentOrder();
		StudentOrder so = new StudentOrder();
		return so;

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

	public AnswerCityRegister checkCityRegister(StudentOrder so) {
		return cityRegisterVal.checkCityRegister(so);
	}

}
