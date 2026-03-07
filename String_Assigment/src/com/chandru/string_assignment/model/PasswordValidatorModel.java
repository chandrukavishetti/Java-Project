package com.chandru.string_assignment.model;

public class PasswordValidatorModel {
	private String input;

	public PasswordValidatorModel(String input) {
		this.input = input;
	}

	public void passwordChecker() {
		try {
			if (input == null || input.trim().isEmpty()) {
				throw new Exception("cannot be empty");
			}

			String trimmedInput = input.trim();
			int lengthOfInput = trimmedInput.length();

			boolean hasUpper = containsUppercase(trimmedInput);
			boolean hasLower = containsLowercase(trimmedInput);
			boolean hasDigit = containsDigit(trimmedInput);
			boolean isLengthValid = lengthOfInput >= 8;

			System.out.println("Password: " + input);
			System.out.println("Length valid: " + (isLengthValid ? "Yes" : "No"));
			System.out.println("Contains uppercase: " + (hasUpper ? "Yes" : "No"));
			System.out.println("Contains lowercase: " + (hasLower ? "Yes" : "No"));
			System.out.println("Contains digit: " + (hasDigit ? "Yes" : "No"));
			System.out.println("replaced spaces if available : "+trimmedInput.replace(" ",""));

			if (isLengthValid && hasUpper && hasLower && hasDigit) {
				System.out.println("Password is VALID");
			} else {
				System.out.println("Password is INVALID");
			}

		} catch (Exception e) {
			System.out.println("error : " + e.getMessage());
		}
	}

	public static boolean containsUppercase(String input) {
		for (char ch : input.toCharArray()) {
			if (Character.isUpperCase(ch))
				return true;
		}
		return false;
	}

	public static boolean containsLowercase(String input) {
		for (char ch : input.toCharArray()) {
			if (Character.isLowerCase(ch))
				return true;
		}
		return false;
	}

	public static boolean containsDigit(String input) {
		for (char ch : input.toCharArray()) {
			if (Character.isDigit(ch))
				return true;
		}
		return false;
	}
}