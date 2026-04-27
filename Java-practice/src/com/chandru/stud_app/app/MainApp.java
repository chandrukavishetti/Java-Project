package com.chandru.stud_app.app;

import com.chandru.stud_app.dao.StudentDAO;
import com.chandru.stud_app.model.Student;
import com.chandru.stud_app.service.Stud_Service;
import com.chandru.stud_app.util.InputValidator;

public class MainApp {
	public static void main(String[] args) {
		StudentDAO sdao = new StudentDAO();
		InputValidator input = new InputValidator();
		Stud_Service service = new Stud_Service();

		while (true) {
			try {
				System.out.println("select one option : ");
				System.out.println("1.Add student");
				System.out.println("2.View all students ");
				System.out.println("3.update student");
				System.out.println("4.delete student by id ");
				System.out.println("5.Exit");

				int choice = InputValidator.readFromMenu(1, 4);

				switch (choice) {
				case 1:
					System.out.println("enter the student id");
					int id = input.readInt();
					String name = input.readName("entetr the name of the student");
					double marks = input.readMarks("enter the student marks");
					System.out.println("enter the age of the student");
					int age = input.readInt();
					String branch = input.readName("enter the branch name ");
					service.addStudent(new Student(id, name, marks, age, branch));
					break;
				case 2:
					sdao.viewAll();
					break;
				case 3:
					System.out.println("enter the updated studentid : ");
					int id1 = input.readInt();
					String name1 = input.readName("enter the new name : ");
					System.out.println("enter the new updated age : ");
					int age1 = input.readInt();
					double marks1 = input.readMarks("enter the new updated marks : ");
					String branch1 = input.readName("enter the new brach name : ");
					service.updateStudent(id1, name1, age1, marks1, branch1);
					break;
				case 4:
					System.out.println("enter the student id to delete");
					int studentid = input.readInt();
					service.deleteStudentById(studentid);
					break;
				case 5:
					System.out.println("exiting ");
					return;
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}

		}

	}
}
