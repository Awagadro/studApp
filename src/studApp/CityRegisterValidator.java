package studApp;

public class CityRegisterValidator {
	String hostName;
	String login;
	String password;

	AnswerCityRegister checkCityRegister(StudentOrder so) {
		System.out.printf("CityRegister is running on host: %s, by login: %s, with password: %s", hostName, login,
				password);
		System.out.println();
		AnswerCityRegister ans = new AnswerCityRegister();
		ans.success = true;
		return ans;
	}
}
