package edu.dkravchuk.studentorder.validator;

import edu.dkravchuk.studentorder.domain.AnswerStudent;
import edu.dkravchuk.studentorder.domain.StudentOrder;

public class StudentValidator {
	public AnswerStudent checkStudent(StudentOrder so) {
		System.out.println("Студенты проверяются");
		AnswerStudent ans = new AnswerStudent();
		ans.success = true;
		return ans;
	}
}
