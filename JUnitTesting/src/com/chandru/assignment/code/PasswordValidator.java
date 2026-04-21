package com.chandru.assignment.code;

public class PasswordValidator {

	public boolean hasMinLength(String str) {
		if (str == null)
			return false;
		return str.length() >= 8;
	}

	public boolean containsUpperCase(String str) {
		if (str == null)
			return false;
		return str.matches(".*[A-Z].*");
	}

	public boolean containsNumber(String str) {
		if (str == null)
			return false;
		return str.matches(".*[0-9].*");
	}

	public boolean isValidPassword(String str) {
		if (str == null || str.isEmpty()) {
			return false;
		}

		return hasMinLength(str) && containsUpperCase(str) && containsNumber(str);
	}
}