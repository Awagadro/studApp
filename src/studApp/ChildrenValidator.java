package studApp;

public class ChildrenValidator {
	AnswerChildren checkChildren(StudentOrder so) {
		System.out.println("Children check is running");
		AnswerChildren ans = new AnswerChildren();
		ans.success = true;
		return ans;
	}
}
