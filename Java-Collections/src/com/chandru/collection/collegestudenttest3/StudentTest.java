package com.chandru.collection.collegestudenttest3;

import java.util.HashMap;
import java.util.Map;

import com.chandru.collection.collegestudentmodel3.DepartmentGroupingManager;
import com.chandru.collection.collegestudentmodel3.DuplicateStudentException;
import com.chandru.collection.collegestudentmodel3.InvalidStudentDataException;
import com.chandru.collection.collegestudentmodel3.PostgraduateStudent;
import com.chandru.collection.collegestudentmodel3.Student;
import com.chandru.collection.collegestudentmodel3.StudentRepository;
import com.chandru.collection.collegestudentmodel3.StudentValidator;
import com.chandru.collection.collegestudentmodel3.UnderGraduateStudent;
import com.chandru.collection.collegestudentmodel3.UserInputHandler;

public class StudentTest {

	public static void main(String[] args) {

		StudentRepository repository = new StudentRepository();

		DepartmentGroupingManager departmentManager = new DepartmentGroupingManager();

		UserInputHandler input = new UserInputHandler();

		try {

			int studentId = input.readInt("Enter Student ID : ");

			String name = input.readString("Enter Student Name : ");

			String department = input.readString("Enter Department : ");

			Map<String, Integer> marks = new HashMap<>();

			String subject1 = input.readString("Enter Subject 1 Name : ");

			int marks1 = input.readMarks("Enter Subject 1 Marks : ");

			marks.put(subject1, marks1);

			String subject2 = input.readString("Enter Subject 2 Name : ");

			int marks2 = input.readMarks("Enter Subject 2 Marks : ");

			marks.put(subject2, marks2);

			String subject3 = input.readString("Enter Subject 3 Name : ");

			int marks3 = input.readMarks("Enter Subject 3 Marks : ");

			marks.put(subject3, marks3);

			int type = input.readStudentType();

			Student student = createStudent(type, input, studentId, name, department, marks);

			StudentValidator.validate(studentId, name, department, marks);

			repository.addStudent(student);

			departmentManager.addStudent(student);

			System.out.println("\nStudent Added Successfully\n");

			System.out.println("All Students");
			repository.displayStudents();

			System.out.println("\nDepartment Wise Students");
			departmentManager.displayDepartmentWiseStudents();

		} catch (DuplicateStudentException e) {

			System.out.println(e.getMessage());
		} catch (InvalidStudentDataException e) {

			System.out.println(e.getMessage());
		} catch (Exception e) {

			System.out.println("Something went wrong");
		}
	}

	private static Student createStudent(int type, UserInputHandler input, int studentId, String name,
			String department, Map<String, Integer> marks) {

		if (type == 1) {

			int semester = input.readInt("Enter Semester : ");

			return new UnderGraduateStudent(studentId, name, department, marks, semester);
		}

		String specialization = input.readString("Enter Specialization : ");

		return new PostgraduateStudent(studentId, name, department, marks, specialization);
	}
}