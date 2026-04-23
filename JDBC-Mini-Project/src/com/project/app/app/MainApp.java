package com.project.app.app;

import java.util.Scanner;
import com.project.app.model.*;
import com.project.app.service.*;
import com.project.app.dao.*;

public class MainApp {

	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws Exception {
		StudentService service = new StudentService();
		RegistrationDAO rdao = new RegistrationDAO();

		while (true) {
			System.out.println("\n--- Student Management System ---");
			System.out.println("1. Add Student ");
			System.out.println("2. Register Course");
			System.out.println("3. View All       ");
			System.out.println("4. Search by ID");
			System.out.println("5. Update Student (Name,Branch) ");
			System.out.println("6. Update Fee");
			System.out.println("7. Cancel Registration");
			System.out.println("8. Delete Student");
			System.out.println("9. High Paying ");
			System.out.println("10. Course Count");
			System.out.println("11. Exit");
			System.out.print("Select an option (1-11): ");

			int ch = readInt();

			if (ch < 1 || ch > 11) {
				System.out.println("Error: Please enter a number between 1 and 11.");
				continue;
			}

			switch (ch) {
			case 1:
				int id = readValidId("Enter Student ID: ");
				String name = readValidName("Enter Name (Alphabets only): ");
				int age = readValidAge("Enter Age: ");
				System.out.print("Enter Branch: ");
				String branch = scanner.nextLine();
				service.addStudent(new Student(id, name, age, branch));
				break;

			case 2:
				int sid = readValidId("Enter Student ID: ");
				System.out.print("Enter Course: ");
				String course = scanner.nextLine();
				double fee = readValidDouble("Enter Fee: ");
				service.registerCourse(sid, course, fee);
				break;

			case 3:
				rdao.viewAll();
				break;

			case 4:
				rdao.searchById(readValidId("Enter ID to search: "));
				break;

			case 5:
				int uid = readValidId("Enter Student ID: ");
				String uname = readValidName("Enter New Name: ");
				System.out.print("Enter New Branch: ");
				String ubranch = scanner.nextLine();
				service.updateStudent(uid, uname, ubranch);
				break;

			case 6:
				int fid = readValidId("Enter Student ID: ");
				System.out.print("Enter Course Name: ");
				String fc = scanner.nextLine();
				double f = readValidDouble("Enter New Fee: ");
				service.updateCourseFee(fid, fc, f); // Using service layer as suggested previously
				break;

			case 7:
				int cid = readValidId("Enter Student ID: ");
				System.out.print("Enter Course Name to Cancel: ");
				String cc = scanner.nextLine();
				service.cancelRegistration(cid, cc);
				break;

			case 8:
				service.deleteStudent(readValidId("Enter ID to delete: "));
				break;

			case 9:
				rdao.highPaying(readValidDouble("Enter Minimum Fee Amount: "));
				break;

			case 10:
				rdao.courseWiseCount();
				break;

			case 11:
				System.out.println("Exiting System...");
				System.exit(0);
			}
		}
	}

	// --- VALIDATION HELPER METHODS ---

	private static int readInt() {
		while (true) {
			try {
				return Integer.parseInt(scanner.nextLine());
			} catch (NumberFormatException e) {
				System.out.print("Invalid input! Please enter a valid number: ");
			}
		}
	}

	private static int readValidId(String prompt) {
		while (true) {
			System.out.print(prompt);
			int val = readInt();
			if (val > 0)
				return val;
			System.out.println("ID must be a positive integer.");
		}
	}

	private static int readValidAge(String prompt) {
		while (true) {
			System.out.print(prompt);
			int val = readInt();
			if (val > 0 && val < 120)
				return val;
			System.out.println("Invalid Age! Please enter a realistic age (>0).");
		}
	}

	private static String readValidName(String prompt) {
		while (true) {
			System.out.print(prompt);
			String input = scanner.nextLine().trim();
			if (input.matches("^[a-zA-Z\\s]+$") && !input.isEmpty()) {
				return input;
			}
			System.out.println("Invalid Name! Only alphabets and spaces are allowed.");
		}
	}

	private static double readValidDouble(String prompt) {
		while (true) {
			System.out.print(prompt);
			try {
				double val = Double.parseDouble(scanner.nextLine());
				if (val > 0)
					return val;
				System.out.println("Amount must be greater than 0.");
			} catch (NumberFormatException e) {
				System.out.println("Invalid input! Please enter a valid decimal amount.");
			}
		}
	}
}