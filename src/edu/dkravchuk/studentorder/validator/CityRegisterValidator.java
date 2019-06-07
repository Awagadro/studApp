package edu.dkravchuk.studentorder.validator;

import edu.dkravchuk.studentorder.domain.AnswerCityRegister;
import edu.dkravchuk.studentorder.domain.StudentOrder;

public class CityRegisterValidator {
	public String hostName;
	public String login;
	public String password;

	public AnswerCityRegister checkCityRegister(StudentOrder so) {
		System.out.printf("CityRegister is running on host: %s, by login: %s, with password: %s", hostName, login,
				password);
		System.out.println();
		AnswerCityRegister ans = new AnswerCityRegister();
		ans.success = true;
		return ans;
	}
}
