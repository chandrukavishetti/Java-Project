package com.chandru.array_of_objects.test;

import java.util.*;

import com.chandru.array_of_objects.model.Course;
import com.chandru.array_of_objects.model.OnlineCourse;
import com.chandru.array_of_objects.model.RegularCourse;

public class CourseTest {
	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		Course[] courses = new Course[4];
		for (int i = 0; i < courses.length; i++) {
			System.out.println("\nEnter details for course " + (i + 1));
			int id = readPositiveInt("Enter course ID : ");
			String name = readValidName("Enter course Name : ");
			double baseFee = readPositiveDouble("Enter Base Fee : ");

			System.out.println("Select course Type : ");
			System.out.println("1. Regular Course");
			System.out.println("2. Online Course");

			int choice = readChoice();

			switch (choice) {
			case 1:
				double labFee = readPositiveDouble("Enter Lab Fee : ");
				courses[i] = new RegularCourse(id, name, baseFee, labFee);
				break;

			case 2:
				double platformFee = readPositiveDouble("Enter Platform Fee : ");
				courses[i] = new OnlineCourse(id, name, baseFee, platformFee);
				break;

			default:
				System.out.println("Invalid choice.Defaulting to Regular Course");
				courses[i] = new RegularCourse(id, name, baseFee, 0);
			}

		}
		System.out.println("\n =======Course Fee Details====");
		for (Course course : courses) {
			course.displayCourse();
			System.out.println("Final Fee : " + course.calculateFee());
		}
		System.out.println("\n Total courses Created : " + Course.getTotalCourses());

	}

	private static int readPositiveInt(String message) {
		int value = 0;
		boolean valid = false;
		while (!valid) {
			System.out.print(message);

			if (!scanner.hasNextInt()) {
				System.out.println("invalid input enter number only");
				scanner.nextLine();
				continue;
			}

			value = scanner.nextInt();
			scanner.nextLine();

			if (value <= 0) {
				System.out.println("value must be positive");
				continue;
			}

			valid = true;
		}
		return value;
	}

	private static double readPositiveDouble(String message) {
		double value = 0;
		boolean valid = false;
		while (!valid) {
			System.out.print(message);

			if (!scanner.hasNextDouble()) {
				System.out.println("invalid input enter numeric value");
				scanner.nextLine();
				continue;
			}

			value = scanner.nextDouble();
			scanner.nextLine(); 

			if (value < 0) {
				System.out.println("value cannot be negative");
				continue;
			}

			valid = true;
		}
		return value;
	}

	private static String readValidName(String message) {
		String name = "";
		boolean valid = false;
		while (!valid) {
			System.out.print(message);
			name = scanner.nextLine().trim();

			if (name.isEmpty()) {
				System.out.println("Name cannot be blank.");
				continue;
			}

			boolean hasInvalidChar = false;
			for (int i = 0; i < name.length(); i++) {
				char ch = name.charAt(i);
				if (!Character.isLetter(ch) && ch != ' ') {
					hasInvalidChar = true;
					break;
				}
			}

			if (hasInvalidChar) {
				System.out.println(
						"Name should contain only alphabets and spaces. No numbers or special symbols allowed.");
				continue;
			}

			valid = true;
		}
		return name;
	}

	private static int readChoice() {
		int choice = 0;
		boolean valid = false;
		while (!valid) {
			System.out.print("enter choice (1 or 2) : ");

			if (!scanner.hasNextInt()) {
				System.out.println("enter numbers only ");
				scanner.nextLine();
				continue;
			}

			choice = scanner.nextInt();
			scanner.nextLine();

			switch (choice) {
			case 1:
			case 2:
				valid = true;
				break;
			default:
				System.out.println("invalid choice serlect (1 or 2) : ");
			}
		}
		return choice;
	}
}