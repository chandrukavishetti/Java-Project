package com.chandru.collection.collegestudentmodel3;

import java.util.Map;

public class StudentValidator {

	public static void validate(int id, String name, String department, Map<String, Integer> marks)
			throws InvalidStudentDataException {

		if (id <= 0)
			throw new InvalidStudentDataException("Invalid student ID");

		if (name == null || name.trim().isEmpty())
			throw new InvalidStudentDataException("Name cannot be empty");

		if (department == null || department.trim().isEmpty())
			throw new InvalidStudentDataException("Department cannot be empty");

		if (marks.isEmpty())
			throw new InvalidStudentDataException("Marks cannot be empty");

		for (Integer value : marks.values()) {

			if (value < 0 || value > 100)
				throw new InvalidStudentDataException("Marks must be between 0 and 100");
		}
	}
}