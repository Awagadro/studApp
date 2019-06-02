package studApp;

public class StudentOrderValidator {

	public static void main(String[] args) {
		checkAll();

	}

	private static void checkAll() {
		StudentOrder so = readStudentOrder();
		AnswerCityRegister cityAnswer = checkCityRegister(so);
		AnswerWedding wedAnswer = checkWedding(so);
		AnswerChildren childAnswer = checkChildren(so);
		checkStudent(so);

		sendMail(so);
	}

	private static void sendMail(StudentOrder so) {
		// TODO Auto-generated method stub

	}

	private static StudentOrder readStudentOrder() {
		StudentOrder so = new StudentOrder();
		return so;
	}

	private static void checkStudent(StudentOrder so) {
		System.out.println("Студенты проверяются");
	}

	private static AnswerChildren checkChildren(StudentOrder so) {
		System.out.println("Children check is running");
		return new AnswerChildren();
	}

	private static AnswerWedding checkWedding(StudentOrder so) {
		System.out.println("Wedding запущен");
		return new AnswerWedding();
	}

	private static AnswerCityRegister checkCityRegister(StudentOrder so) {
		System.out.println("CityRegister is running");
		AnswerCityRegister ans = new AnswerCityRegister();
		return ans;
	}

}
