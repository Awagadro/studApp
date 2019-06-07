package edu.dkravchuk.studentorder.validator;

import edu.dkravchuk.studentorder.domain.AnswerChildren;
import edu.dkravchuk.studentorder.domain.StudentOrder;

public class ChildrenValidator {
	public AnswerChildren checkChildren(StudentOrder so) {
		System.out.println("Children check is running");
		AnswerChildren ans = new AnswerChildren();
		ans.success = true;
		return ans;
	}
}
