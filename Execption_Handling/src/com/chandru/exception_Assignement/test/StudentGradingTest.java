package com.chandru.exception_Assignement.test;

import com.chandru.exception_Assignement.model.StudentGrading;
import com.chandru.exception_Assignement.model.InvalidMarksException;

public class StudentGradingTest {

	public static void main(String[] args) {

		String name = "chandru";
		int marks = 85;

		try {
			StudentGrading.validateStudent(name, marks);

		} catch (InvalidMarksException e) {
			System.out.println("Invalid Marks: " + e.getMessage());

		} catch (NullPointerException e) {
			System.out.println("Name Error: " + e.getMessage());

		} finally {
			System.out.println("Grading process completed");
		}
	}
}