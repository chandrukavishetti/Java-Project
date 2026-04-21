package com.chandru.assignment.code;

public class GroupedAssertion {

	public String userName(String str) {
		if (str == null || str.trim().isEmpty()) {
			return null;
		}
		return str;
	}

	public int userAge(int age) {
		if (age < 0) {
			return -1;
		}
		return age;
	}
}