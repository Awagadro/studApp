package edu.dkravchuk.studentorder;

import java.time.LocalDate;
import java.util.List;

import edu.dkravchuk.studentorder.dao.DictionaryDaoImpl;
import edu.dkravchuk.studentorder.domain.Address;
import edu.dkravchuk.studentorder.domain.Adult;
import edu.dkravchuk.studentorder.domain.Child;
import edu.dkravchuk.studentorder.domain.Street;
import edu.dkravchuk.studentorder.domain.StudentOrder;

public class SaveStudentOrder {
	public static void main(String[] args) throws Exception {
		List<Street> d = new DictionaryDaoImpl().findStreets("sec");
		for (Street street : d) {
			System.out.println(street.getStreetName());
		}

		// StudentOrder so = buildStudentOrder(199);
		// long ans = saveStudentOrder(so);
		// System.out.println(ans);
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
		so.setMarriageCertificateId("" + 123456000 + id);
		so.setMarriageDate(LocalDate.of(2016, 7, 4));
		so.setMarriageOffice("Отдел ЗАГС");
		Street street = new Street(1L, "First street");
		Address address = new Address("195000", street, "12", "А", "142");

		// Муж
		Adult husband = new Adult("Петров", "Виктор", "Сергеевич", LocalDate.of(1997, 8, 24));
		husband.setPassportSeria("" + (1000 + id));
		husband.setPassportNumber("" + (100000 + id));
		husband.setIssueDate(LocalDate.of(2017, 9, 15));
		husband.setIssueDepartment("Отдел милиции №" + id);
		husband.setStudentId("" + (100000 + id));
		husband.setAddress(address);
		so.setHusband(husband);
		// Жена
		Adult wife = new Adult("Петрова", "Вероника", "Алексеевна", LocalDate.of(1998, 8, 24));
		wife.setPassportSeria("" + (2000 + id));
		wife.setPassportNumber("" + (200000 + id));
		wife.setIssueDate(LocalDate.of(2018, 9, 15));
		wife.setIssueDepartment("Отдел милиции №" + id);
		wife.setStudentId("" + (200000 + id));
		wife.setAddress(address);
		so.setWife(wife);

		// Ребенок
		Child child = new Child("Петрова", "Ирина", "Викторовна", LocalDate.of(2018, 6, 29));
		child.setCertificateNumber("" + (300000 + id));
		child.setIssueDate(LocalDate.of(2018, 7, 19));
		child.setIssueDepartment("Отдел ЗАГС №" + id);
		child.setAddress(address);
		so.addChild(child);

		// Ребенок2
		Child child2 = new Child("Петров", "Евгений", "Викторович", LocalDate.of(2018, 6, 29));
		child2.setCertificateNumber("" + (400000 + id));
		child2.setIssueDate(LocalDate.of(2018, 7, 19));
		child2.setIssueDepartment("Отдел ЗАГС №" + id);
		child2.setAddress(address);
		so.addChild(child2);

		return so;

	}

}
