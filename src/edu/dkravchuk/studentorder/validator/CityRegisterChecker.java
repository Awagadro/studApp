package edu.dkravchuk.studentorder.validator;

import edu.dkravchuk.studentorder.domain.CityRegisterCheckerResponse;
import edu.dkravchuk.studentorder.domain.Person;
import edu.dkravchuk.studentorder.exception.CityRegisterExsception;

public interface CityRegisterChecker {
	CityRegisterCheckerResponse checkPerson(Person person) throws CityRegisterExsception;
}
