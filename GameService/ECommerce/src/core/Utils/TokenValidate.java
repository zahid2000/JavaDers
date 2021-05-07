package core.Utils;

import java.util.Random;

public class TokenValidate {
	private static String createdToken;

	public static String createdToken() {
		int leftLimit = 97; // letter 'a'
		int rightLimit = 122; // letter 'z'
		int targetStringLength = 20;
		Random random = new Random();
		StringBuilder buffer = new StringBuilder(targetStringLength);
		for (int i = 0; i < targetStringLength; i++) {
			if (i % 2 == 0) {
				int randomLimitedInt = leftLimit + (int) (random.nextFloat() * (rightLimit - leftLimit + 1));
				buffer.append(randomLimitedInt);
			} else {
				int randomLimitedInt = leftLimit + (int) (random.nextFloat() * (rightLimit - leftLimit + 1));
				buffer.append((char) randomLimitedInt);
			}
		}
		String generatedString = buffer.toString();

		
		createdToken = generatedString;
		return generatedString;
	}

	public static boolean tokenValidate(String token) {
		if (createdToken.equals(token)) {
			return true;
		}
		System.out.println("Dogrulama yapilamadi");
		return false;
	}
}
