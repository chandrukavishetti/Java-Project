package com.chandru.assignment.code;

public class MarksValidator {
	public boolean isValidMarks(int marks) {
		if (marks < 0 || marks > 100) {
			return false;
		}
		return true;
	}

}
