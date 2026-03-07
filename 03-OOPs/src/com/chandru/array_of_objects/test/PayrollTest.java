package com.chandru.array_of_objects.test;

import java.util.Scanner;
import com.chandru.array_of_objects.model.Employee;
import com.chandru.array_of_objects.model.PartTimeEmployee;
import com.chandru.array_of_objects.model.Intern;
import com.chandru.array_of_objects.model.FullTimeEmployee;

public class PayrollTest {

	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {

		Employee[] employees = new Employee[1];

		for (int i = 0; i < employees.length; i++) {

			System.out.println("\nEnter details for Employee " + (i + 1));

			int id = readPositiveInt("Enter Employee ID: ");
			String name = readValidName("Enter Employee Name: ");

			System.out.println("Select Employee Type:");
			System.out.println("1. Full Time");
			System.out.println("2. Part Time");
			System.out.println("3. Intern");

			int choice = readChoice();

			switch (choice) {

			case 1:
				double salary = readPositiveDouble("Enter Monthly Salary: ");
				employees[i] = new FullTimeEmployee(id, name, salary);
				break;

			case 2:
				double hours = readPositiveDouble("Enter Hours Worked: ");
				double rate = readPositiveDouble("Enter Hourly Rate: ");
				employees[i] = new PartTimeEmployee(id, name, hours, rate);
				break;

			case 3:
				double stipend = readPositiveDouble("Enter Stipend: ");
				employees[i] = new Intern(id, name, stipend);
				break;

			default:
				System.out.println("Invalid choice. Defaulting to Intern.");
				employees[i] = new Intern(id, name, 0);
			}
		}

		System.out.println("\n===== Salary Details =====");

		for (Employee emp : employees) {
			emp.displayEmployee();
			System.out.println("Salary : " + emp.calculateSalary());
		}

		System.out.println("\nTotal Employees Created : " + Employee.getTotalEmployees());
	}

	private static int readPositiveInt(String message) {

		int value = 0;
		boolean valid = false;

		while (!valid) {

			System.out.print(message);

			if (scanner.hasNextInt()) {
				value = scanner.nextInt();
				scanner.nextLine();

				if (value > 0) {
					valid = true;
				} else {
					System.out.println("Value must be positive.");
				}

			} else {
				System.out.println("Invalid input. Enter numbers only.");
				scanner.nextLine();
			}
		}

		return value;
	}

	private static double readPositiveDouble(String message) {

		double value = 0;
		boolean valid = false;

		while (!valid) {

			System.out.print(message);

			if (scanner.hasNextDouble()) {
				value = scanner.nextDouble();
				scanner.nextLine();

				if (value >= 0) {
					valid = true;
				} else {
					System.out.println("Value cannot be negative.");
				}

			} else {
				System.out.println("Invalid input. Enter numeric value.");
				scanner.nextLine();
			}
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

			boolean invalid = false;

			for (int i = 0; i < name.length(); i++) {

				char ch = name.charAt(i);

				if (!Character.isLetter(ch) && ch != ' ') {
					invalid = true;
					break;
				}
			}

			if (!invalid) {
				valid = true;
			} else {
				System.out.println(
						"Name should contain only alphabets and spaces. No numbers or special symbols allowed.");
			}
		}

		return name;
	}

	private static int readChoice() {

		int choice = 0;
		boolean valid = false;

		while (!valid) {

			System.out.print("Enter choice (1-3): ");

			if (scanner.hasNextInt()) {
				choice = scanner.nextInt();
				scanner.nextLine();

				switch (choice) {
				case 1:
				case 2:
				case 3:
					valid = true;
					break;
				default:
					System.out.println("Invalid choice. Select 1, 2 or 3.");
				}

			} else {
				System.out.println("Enter numbers only.");
				scanner.nextLine();
			}
		}

		return choice;
	}
}