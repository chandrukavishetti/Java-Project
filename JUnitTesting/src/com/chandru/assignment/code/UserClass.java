package com.chandru.assignment.code;

public class UserClass {

	public String name;
	public int age;

	// Validate username
	public String validUser(String str) {
		if (str == null || str.trim().isEmpty()) {
			return null;
		}
		return str;
	}

	// Validate age
	public String validAge(int age) {
		if (age < 0 || age > 100) {
			return "invalid";
		}
		return "valid";
	}
}