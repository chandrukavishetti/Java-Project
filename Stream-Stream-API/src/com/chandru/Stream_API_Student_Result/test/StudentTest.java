package com.chandru.Stream_API_Student_Result.test;

import com.chandru.Stream_API_Student_Result.model.InputHandler;
import com.chandru.Stream_API_Student_Result.model.Student;
import com.chandru.Stream_API_Student_Result.model.StudentService;

import java.util.*;

public class StudentTest {

	public static void main(String[] args) {

		InputHandler input = new InputHandler();
		StudentService service = new StudentService();

		List<Student> list = new ArrayList<>();

		int n = input.getInt("Enter number of students: ");

		for (int i = 0; i < n; i++) {
			System.out.println("\nEnter Student " + (i + 1) + " details:");

			int roll = input.getInt("Roll No: ");
			String name = input.getString("Name: ");
			int standard = input.getInt("Standard: ");
			double marks = input.getDouble("Marks: ");
			String section = input.getString("Section: ");

			list.add(new Student(roll, name, standard, marks, section));
		}

		double passMarks = input.getDouble("\nEnter pass marks: ");

		System.out.println("\n--- Passed Students ---");
		service.getPassedStudents(list, passMarks).forEach(System.out::println);

		System.out.println("\n--- Top 3 Students ---");
		service.getTop3Students(list).forEach(System.out::println);

		System.out.println("\n--- Group By Section ---");
		System.out.println(service.groupBySection(list));

		System.out.println("\n--- Count By Section ---");
		System.out.println(service.countBySection(list));

		System.out.println("\n--- Average Marks By Section ---");
		System.out.println(service.avgMarksBySection(list));

		System.out.println("\n--- Names in Uppercase ---");
		service.getNamesUpperCase(list).forEach(System.out::println);

		double fullMarks = input.getDouble("\nEnter full marks to check: ");
		System.out.println("\nAny student scored full marks? " + service.hasFullMarks(list, fullMarks));
	}
}