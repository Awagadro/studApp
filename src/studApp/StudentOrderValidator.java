package studApp;

public class StudentOrderValidator {

	public static void main(String[] args) {
		checkAll();

	}

	private static void checkAll() {
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

	private static void sendMail(StudentOrder so) {
		MailSender ms = new MailSender();
		ms.sendMail(so);
	}

	private static StudentOrder readStudentOrder() {
		StudentOrder so = new StudentOrder();
		return so;

	}

	private static AnswerStudent checkStudent(StudentOrder so) {
		return new StudentValidator().checkStudent(so);
	}

	private static AnswerChildren checkChildren(StudentOrder so) {
		ChildrenValidator cv = new ChildrenValidator();
		AnswerChildren ans = cv.checkChildren(so);
		return ans;
	}

	private static AnswerWedding checkWedding(StudentOrder so) {
		WeddingValidator wd = new WeddingValidator();
		AnswerWedding ans = wd.checkWedding(so);
		return ans;
	}

	private static AnswerCityRegister checkCityRegister(StudentOrder so) {
		CityRegisterValidator crv1 = new CityRegisterValidator();
		crv1.hostName = "Host1";
		crv1.login = "Login1";
		crv1.password = "Pass1";
		CityRegisterValidator crv2 = new CityRegisterValidator();
		crv2.hostName = "Host2";
		crv2.login = "Login2";
		crv2.password = "Pass2";
		AnswerCityRegister ans1 = crv1.checkCityRegister(so);
		AnswerCityRegister ans2 = crv2.checkCityRegister(so);

		return ans1;
	}

}
