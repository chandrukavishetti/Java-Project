package com.chandru.assignment.code;

public class StringUtility {

	public boolean isEmpty(String str) {
		if (str == null) {
			return true;
		}
		return str.trim().isEmpty();
	}

	public String toUpperCase(String str) {
		if (str == null) {
			return null;
		}
		return str.toUpperCase();
	}

	public Integer getLength(String str) {
		if (str == null) {
			return null;
		}
		return str.length();
	}
}
