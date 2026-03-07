package com.chandru.inheritance.test;

import java.util.Scanner;
import com.chandru.inheritance.model.*;

public class PayrollApp {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		int size;
		while (true) {
			System.out.print("Enter number of employees: ");
			String input = scanner.nextLine().trim();
			
			boolean valid = !input.isEmpty();
			for (int i = 0; i < input.length(); i++) {
				if (!Character.isDigit(input.charAt(i))) { valid = false; break; }
			}
			
			if (!valid || (input.length() > 1 && input.startsWith("0"))) {
				System.out.println("Invalid input. Enter a positive number.");
				continue;
			}
			size = Integer.parseInt(input);
			break;
		}

		Employee[] employees = new Employee[size];

		for (int i = 0; i < size; i++) {

			int choice;
			while (true) {
				System.out.println("\nSelect Employee Type:\n1. Full Time\n2. Part Time\n3. Contract");
				System.out.print("Enter choice: ");
				String input = scanner.nextLine().trim();
				if (input.equals("1") || input.equals("2") || input.equals("3")) {
					choice = Integer.parseInt(input);
					break;
				}
				System.out.println("Invalid choice. Select 1, 2, or 3.");
			}

			int id;
			while (true) {
				System.out.print("Enter Employee ID: ");
				String input = scanner.nextLine().trim();
				boolean valid = !input.isEmpty();
				for (int k = 0; k < input.length(); k++) {
					if (!Character.isDigit(input.charAt(k))) { valid = false; break; }
				}
				if (!valid || (input.length() > 1 && input.startsWith("0"))) {
					System.out.println("Invalid ID. Enter numbers only.");
					continue;
				}
				id = Integer.parseInt(input);
				break;
			}

			String name;
			while (true) {
				System.out.print("Enter Name: ");
				name = scanner.nextLine().trim();
				boolean valid = !name.isEmpty();
				for (int k = 0; k < name.length(); k++) {
					char ch = name.charAt(k);
					if (!Character.isLetter(ch) && ch != ' ') { valid = false; break; }
				}
				if (!valid) {
					System.out.println("Invalid name. Use alphabets only.");
					continue;
				}
				break;
			}

			if (choice == 1) {
				double basic = getValidDouble(scanner, "Enter Basic: ");
				double hra = getValidDouble(scanner, "Enter HRA: ");
				double da = getValidDouble(scanner, "Enter DA: ");
				employees[i] = new FullTimeEmployee(id, name, basic, hra, da);
			} else if (choice == 2) {
				int hours;
				while (true) {
					System.out.print("Enter Hours Worked: ");
					String input = scanner.nextLine().trim();
					boolean valid = !input.isEmpty();
					for (int k = 0; k < input.length(); k++) {
						if (!Character.isDigit(input.charAt(k))) { valid = false; break; }
					}
					if (!valid) { System.out.println("Invalid hours."); continue; }
					hours = Integer.parseInt(input);
					break;
				}
				double rate = getValidDouble(scanner, "Enter Hourly Rate: ");
				employees[i] = new PartTimeEmployee(id, name, hours, rate);
			} else if (choice == 3) {
				double fixed = getValidDouble(scanner, "Enter Fixed Amount: ");
				double tax = getValidDouble(scanner, "Enter Tax: ");
				employees[i] = new ContractEmployee(id, name, fixed, tax);
			}
		}

		System.out.println("\n------ PAYSLIP ------");
		for (Employee emp : employees) {
			if (emp == null) continue;
			emp.displayEmployee();
			System.out.println("Salary : " + emp.calculateSalary());
			System.out.println("---------------------");
		}
		scanner.close();
	}

	// Helper logic to validate Double inputs without exceptions
	private static double getValidDouble(Scanner sc, String prompt) {
		while (true) {
			System.out.print(prompt);
			String input = sc.nextLine().trim();
			if (input.length() > 1 && input.startsWith("0") && !input.startsWith("0.")) {
				System.out.println("Invalid format. No leading zeros.");
				continue;
			}
			boolean isNumeric = !input.isEmpty();
			int dots = 0;
			for (int i = 0; i < input.length(); i++) {
				char ch = input.charAt(i);
				if (ch == '.') { dots++; continue; }
				if (!Character.isDigit(ch)) { isNumeric = false; break; }
			}
			if (!isNumeric || dots > 1) {
				System.out.println("Invalid numeric amount.");
				continue;
			}
			return Double.parseDouble(input);
		}
	}
}