package studApp;

public class SaveStudentOrder {
	public static void main(String[] args) {
		StudentOrder so = new StudentOrder();
		so.hFirstName = "Алексей";
		so.hLastName = "Петров";
		so.wFirstName = "Галина";
		so.wLastName = "Петрова";
		long ans = saveStudentOrder(so);
		System.out.println(ans);
	}

	private static long saveStudentOrder(StudentOrder studentOrder) {
		long answer;
		answer = 199;
		System.out.println("saveStudentOrder:" + studentOrder.hLastName);
		return answer;
	}
}
