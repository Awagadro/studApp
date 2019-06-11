package edu.dkravchuk.studentorder.validator;

import edu.dkravchuk.studentorder.domain.AnswerCityRegister;
import edu.dkravchuk.studentorder.domain.CityRegisterCheckerResponse;
import edu.dkravchuk.studentorder.domain.StudentOrder;
import edu.dkravchuk.studentorder.exception.CityRegisterExsception;

public class CityRegisterValidator {
	public String hostName;
	public String login;
	public String password;

	private CityRegisterChecker personChecker;

	public CityRegisterValidator() {
		personChecker = new FakeCityRegisterChecker();
		// personChecker = new RealCityRegisterChecker();
	}

	public AnswerCityRegister checkCityRegister(StudentOrder so) {
		try {
			CityRegisterCheckerResponse hans = personChecker.checkPerson(so.getHusband());
			CityRegisterCheckerResponse wans = personChecker.checkPerson(so.getWife());
			CityRegisterCheckerResponse cans = personChecker.checkPerson(so.getChild());
		} catch (CityRegisterExsception ex) {
			ex.printStackTrace(System.out);
		}
		AnswerCityRegister ans = new AnswerCityRegister();
		return ans;
	}
}
