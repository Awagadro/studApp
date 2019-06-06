package studApp;

public class StudentValidator {
	AnswerStudent checkStudent(StudentOrder so) {
		System.out.println("Студенты проверяются");
		AnswerStudent ans = new AnswerStudent();
		ans.success = true;
		return ans;
	}
}
