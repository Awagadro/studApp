package edu.dkravchuk.studentorder;

import java.time.LocalDate;

import edu.dkravchuk.studentorder.dao.StudentOrderDao;
import edu.dkravchuk.studentorder.dao.StudentOrderDaoImpl;
import edu.dkravchuk.studentorder.domain.Address;
import edu.dkravchuk.studentorder.domain.Adult;
import edu.dkravchuk.studentorder.domain.Child;
import edu.dkravchuk.studentorder.domain.PassportOffice;
import edu.dkravchuk.studentorder.domain.RegisterOffice;
import edu.dkravchuk.studentorder.domain.Street;
import edu.dkravchuk.studentorder.domain.StudentOrder;

public class SaveStudentOrder {
	public static void main(String[] args) throws Exception {
//		List<Street> d = new DictionaryDaoImpl().findStreets("про");
//		for (Street street : d) {
//			System.out.println(street.getStreetName());
//		}

//		List<PassportOffice> po = new DictionaryDaoImpl().findPassportOffices("010020000000");
//		for (PassportOffice p : po) {
//			System.out.println(p.getOfficeName());
//		}

//		List<RegisterOffice> ro = new DictionaryDaoImpl().findRegisterOffices("010010000000");
//		for (RegisterOffice r : ro) {
//			System.out.println(r.getOfficeName());
//		}

//		List<CountryArea> ca1 = new DictionaryDaoImpl().findAreas("");
//		for (CountryArea a : ca1) {
//			System.out.println(a.getAreaId() + ":" + a.getAreaName());
//		}

//		System.out.println("-------->");
//		List<CountryArea> ca2 = new DictionaryDaoImpl().findAreas("020000000000");
//		for (CountryArea a : ca2) {
//			System.out.println(a.getAreaId() + ":" + a.getAreaName());
//		}

//		System.out.println("-------->");
//		List<CountryArea> ca3 = new DictionaryDaoImpl().findAreas("020010000000");
//		for (CountryArea a : ca3) {
//			System.out.println(a.getAreaId() + ":" + a.getAreaName());
//		}

//		System.out.println("-------->");
//		List<CountryArea> ca4 = new DictionaryDaoImpl().findAreas("020010010000");
//		for (CountryArea a : ca4) {
//			System.out.println(a.getAreaId() + ":" + a.getAreaName());
//		}

		StudentOrder so = buildStudentOrder(10);
		StudentOrderDao dao = new StudentOrderDaoImpl();
		Long id = dao.saveStudentOrder(so);

		System.out.println(id);
		// long ans = saveStudentOrder(so);
		// System.out.println(ans);

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
		RegisterOffice ro1 = new RegisterOffice(1L, "", "");
		so.setRegisterOffice(ro1);
		Street street = new Street(1L, "First street");
		Address address = new Address("195000", street, "12", "А", "142");

		// Муж
		Adult husband = new Adult("Петров", "Виктор", "Сергеевич", LocalDate.of(1997, 8, 24));
		husband.setPassportSeria("" + (1000 + id));
		husband.setPassportNumber("" + (100000 + id));
		husband.setIssueDate(LocalDate.of(2017, 9, 15));
		PassportOffice po1 = new PassportOffice(1L, "", "");
		husband.setPassportOffice(po1);
		;
		husband.setStudentId("" + (100000 + id));
		husband.setAddress(address);
		so.setHusband(husband);
		// Жена
		Adult wife = new Adult("Петрова", "Вероника", "Алексеевна", LocalDate.of(1998, 8, 24));
		wife.setPassportSeria("" + (2000 + id));
		wife.setPassportNumber("" + (200000 + id));
		wife.setIssueDate(LocalDate.of(2018, 9, 15));
		PassportOffice po2 = new PassportOffice(2L, "", "");
		wife.setPassportOffice(po2);
		;
		wife.setStudentId("" + (200000 + id));
		wife.setAddress(address);
		so.setWife(wife);

		// Ребенок
		Child child = new Child("Петрова", "Ирина", "Викторовна", LocalDate.of(2018, 6, 29));
		child.setCertificateNumber("" + (300000 + id));
		child.setIssueDate(LocalDate.of(2018, 7, 19));
		RegisterOffice ro2 = new RegisterOffice(2L, "", "");
		so.setRegisterOffice(ro2);
		child.setAddress(address);
		so.addChild(child);

		// Ребенок2
		Child child2 = new Child("Петров", "Евгений", "Викторович", LocalDate.of(2018, 6, 29));
		child2.setCertificateNumber("" + (400000 + id));
		child2.setIssueDate(LocalDate.of(2018, 7, 19));
		RegisterOffice ro3 = new RegisterOffice(3L, "", "");
		so.setRegisterOffice(ro3);
		child2.setAddress(address);
		so.addChild(child2);

		return so;

	}

}
