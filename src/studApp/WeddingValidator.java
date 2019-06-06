package studApp;

public class WeddingValidator {
	AnswerWedding checkWedding(StudentOrder so) {
		System.out.println("Wedding запущен");
		AnswerWedding ans = new AnswerWedding();
		ans.success = true;
		return ans;
	}
}
