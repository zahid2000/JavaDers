package core.Utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class emailValidate {
	public static boolean validateWithRegex(String email) {
		String regex = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";

		Pattern pattern = Pattern.compile(regex);

		Matcher matcher = pattern.matcher(email);
		System.out.println("Regex validate "+email + " : " + matcher.matches());
		return matcher.matches();
	}
}
