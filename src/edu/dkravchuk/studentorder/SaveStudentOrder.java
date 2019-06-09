package edu.dkravchuk.studentorder;

import edu.dkravchuk.studentorder.domain.Adult;
import edu.dkravchuk.studentorder.domain.StudentOrder;

public class SaveStudentOrder {
	public static void main(String[] args) {

		StudentOrder so = buildStudentOrder(199);

		long ans = saveStudentOrder(so);
		System.out.println(ans);
	}

	private static long saveStudentOrder(StudentOrder studentOrder) {
		long answer;
		answer = 199;
		System.out.println("saveStudentOrder:");
		return answer;
	}

	public static StudentOrder buildStudentOrder(long id) {
		StudentOrder so = new StudentOrder();
		so.setStudentOrderId(id);

		Adult husband = new Adult("Васильев", "Андрей", "Петрович", null);
		Adult wife = new Adult("Васильева", "Алина", "Петровна", null);
		Adult child = new Adult("Васильева", "Кира", "Андреевна", null);

		return so;

	}

}
