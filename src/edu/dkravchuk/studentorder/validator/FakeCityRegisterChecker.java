package edu.dkravchuk.studentorder.validator;

import edu.dkravchuk.studentorder.domain.Adult;
import edu.dkravchuk.studentorder.domain.CityRegisterCheckerResponse;
import edu.dkravchuk.studentorder.domain.Person;
import edu.dkravchuk.studentorder.exception.CityRegisterExsception;

public class FakeCityRegisterChecker implements CityRegisterChecker {

	private static final String GOOD_1 = "1000";
	private static final String GOOD_2 = "2000";
	private static final String BAD_1 = "1000";
	private static final String BAD_2 = "2000";

	public CityRegisterCheckerResponse checkPerson(Person person) throws CityRegisterExsception {

		CityRegisterCheckerResponse res = new CityRegisterCheckerResponse();

		if (person instanceof Adult) {
			Adult t = (Adult) person;
			String ps = t.getPassportSeria();
			if (ps.equals(GOOD_1) || ps.equals(GOOD_2)) {
				res.setExisting(true);
				res.setIsTemporal(false);
			}
		}

		return res;
	}
}
