package com.chandru.exception_Assignement.model;

public class PasswordValidator {
	public static void checkPassword(String pwd) throws InvalidPasswordException {
		if (pwd.length() < 8) {
			throw new InvalidPasswordException("Password must be at lease 8 charecter");
		}
		boolean hasDigit = false;

		for (int i = 0; i < pwd.length(); i++) {
			if (Character.isDigit(pwd.charAt(i))) {
				hasDigit = true;
				break;
			}
		}
		if (!hasDigit) {
			throw new InvalidPasswordException("password must contaim at least one digit");
		}

	}
}
