package com.project.app.app;

import com.project.app.model.Student;
import com.project.app.service.StudentService;
import com.project.app.dao.*;
import com.project.app.util.InputValidator;

public class MainApp {

	public static void main(String[] args) {
		StudentService service = new StudentService();
		RegistrationDAO rdao = new RegistrationDAO();
		StudentDAO sdao = new StudentDAO();

		while (true) {
			try {
				System.out.println("\n--- Student Course & Fee Management System ---");
				System.out.println("1. Add Student ");
				System.out.println("2. Register Course");
				System.out.println("3. View All Students ");
				System.out.println("4. Search Student by ID");
				System.out.println("5. Update Student ");
				System.out.println("6. Update Course Fee");
				System.out.println("7. Cancel Registration ");
				System.out.println("8. Delete Student");
				System.out.println("9. High Paying Report ");
				System.out.println("10. Course-wise Count");
				System.out.println("11. Exit");
				System.out.print("Select Option (1-11): ");

				int choice = InputValidator.readMenuChoice(1, 11);

				switch (choice) {
				case 1:
					int id = InputValidator.readUniqueId("Enter New Student ID: ");
					String name = InputValidator.readValidName("Enter Name: ");
					System.out.print("Enter Age: ");
					int age = InputValidator.readInt();
					String branch = selectFromDB(sdao, "branches", "branch_name");
					service.addStudent(new Student(id, name, age, branch));
					break;

				case 2:
					// Only proceeds if student ID exists
					int sid = InputValidator.readExistingId("Enter Student ID to Register: ");
					String course = selectFromDB(sdao, "courses", "course_name");
					double fee = InputValidator.readValidDouble("Enter Fee: ");
					service.registerCourse(sid, course, fee);
					break;

				case 3:
					rdao.viewAll();
					break;

				case 4:
					// Search by any ID (doesn't have to exist for a search)
					System.out.print("Enter ID to Search: ");
					rdao.searchById(InputValidator.readInt());
					break;

				case 5:
					int uid = InputValidator.readExistingId("Enter Student ID to Update: ");
					String uname = InputValidator.readValidName("Enter New Name: ");
					String ubranch = selectFromDB(sdao, "branches", "branch_name");
					service.updateStudent(uid, uname, ubranch);
					break;

				case 6:
					int fid = InputValidator.readExistingId("Enter Student ID for Fee Update: ");
					String fcourse = selectFromDB(sdao, "courses", "course_name");
					double famount = InputValidator.readValidDouble("Enter New Fee: ");
					service.updateCourseFee(fid, fcourse, famount);
					break;

				case 7:
					int cid = InputValidator.readExistingId("Enter Student ID to Cancel: ");
					String ccourse = selectFromDB(sdao, "courses", "course_name");
					service.cancelRegistration(cid, ccourse);
					break;

				case 8:
					int did = InputValidator.readExistingId("Enter Student ID to Delete: ");
					service.deleteStudent(did);
					break;

				case 9:
					rdao.highPaying(InputValidator.readValidDouble("Enter Amount: "));
					break;

				case 10:
					rdao.courseWiseCount();
					break;

				case 11:
					System.out.println("Exiting...");
					return;
				}
			} catch (Exception e) {
				// This catches the "Student not found" exception and prints it nicely
				System.out.println("System Message: " + e.getMessage());
			}
		}
	}

	private static String selectFromDB(StudentDAO sdao, String table, String col) throws Exception {
		java.util.List<String> items = sdao.getLookupItems(table, col);
		System.out.println("\nSelect " + table + ":");
		for (int i = 0; i < items.size(); i++) {
			System.out.println((i + 1) + ". " + items.get(i));
		}
		System.out.print("Choice: ");
		int choice = InputValidator.readMenuChoice(1, items.size());
		return items.get(choice - 1);
	}
}