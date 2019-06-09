package edu.dkravchuk.studentorder.validator;

import edu.dkravchuk.studentorder.domain.CityRegisterCheckerResponse;
import edu.dkravchuk.studentorder.domain.Person;
import edu.dkravchuk.studentorder.exception.CityRegisterExsception;

public class FakeCityRegisterChecker implements CityRegisterChecker{
	public CityRegisterCheckerResponse checkPerson(Person person) throws CityRegisterExsception{

		return null;
	}
}
