package edu.dkravchuk.studentorder;

import edu.dkravchuk.studentorder.domain.Adult;
import edu.dkravchuk.studentorder.domain.StudentOrder;

public class SaveStudentOrder {
	public static void main(String[] args) {
		
		StudentOrder so = buildStudentOrder();

		long ans = saveStudentOrder(so);
		System.out.println(ans);
	}

	private static long saveStudentOrder(StudentOrder studentOrder) {
		long answer;
		answer = 199;
		System.out.println("saveStudentOrder:");
		return answer;
	}

	public static StudentOrder buildStudentOrder() {
		StudentOrder so = new StudentOrder();
		Adult husband = new Adult();
//		husband.setSurName("Петров");
//		so.setHusband(husband);

		return so;

	}

}
