package com.chandru.practice.test;

import com.chandru.practice.model.Student;
import java.util.Scanner;

public class StudentTest {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("enter the name of the student : ");
		String name = scanner.nextLine();

		System.out.println("enter the age of the student ");
		int age = scanner.nextInt();

		System.out.println("enter the five subject marks");
		double[] marks = new double[5];
		for (int i = 0; i < 5; i++) {
			marks[i] = scanner.nextDouble();
		}
		Student student = new Student(name, age, marks);

		System.out.println("student name is : " + student.getName());
		System.out.println("student age is : " + student.getAge());
		System.out.println("student marks is : " + student.getGrade());

	}

}

/*
 * Create a Student class that demonstrates strict encapsulation with the
 * following rules:
 * 
 * Properties: name, age, marks (array of 5 subjects) age should only accept
 * values between 15 and 25, otherwise throw an IllegalArgumentException marks
 * should only accept values between 0 and 100 per subject, with proper
 * validation Provide a method getGrade() that calculates and returns the grade
 * based on average marks:
 * 
 * 90+ → "A" 75–89 → "B" 60–74 → "C" Below 6 0 → "Fail"
 * 
 * 
 * The marks array should never be directly modifiable from outside — even after
 * getting it via getter (hint: think about defensive copying) In main(), create
 * a Student object, set values, and print the grade
 * 
 * 
 * Bonus challenge: What happens if you return the array directly in the getter
 * — why is that a problem in encapsulation?
 */