package com.chandru.Interface.test;

import java.util.Scanner;
import com.chandru.Interface.model.TheoryExam;
import com.chandru.Interface.model.OnlineQuiz;
import com.chandru.Interface.model.PracticalExam;
import com.chandru.Interface.model.ExamEvaluator;

public class ExamTest {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		ExamEvaluator exam = null;

		System.out.println("====== Exam Evaluation System ======");

		int choice = 0;

		while (choice < 1 || choice > 3) {

			System.out.println("Select Exam Type:");
			System.out.println("1. Theory Exam");
			System.out.println("2. Practical Exam");
			System.out.println("3. Online Quiz");

			if (scanner.hasNextInt()) {
				choice = scanner.nextInt();

				if (choice < 1 || choice > 3) {
					System.out.println("Invalid choice. Select between 1 and 3.");
				}
			} else {
				System.out.println("Invalid input. Enter numbers only.");
				scanner.next();
			}
		}

		switch (choice) {

		case 1:
			exam = new TheoryExam();
			break;

		case 2:
			exam = new PracticalExam();
			break;

		case 3:
			exam = new OnlineQuiz();
			break;
		}

		double marks = getValidMarks(scanner);

		exam.evaluateMarks(marks);
		exam.calculateGrade();

		scanner.close();
	}

	private static double getValidMarks(Scanner scanner) {

		double marks = -1;

		while (marks < 0 || marks > 100) {

			System.out.println("Enter Marks (0 - 100):");

			if (scanner.hasNextDouble()) {
				marks = scanner.nextDouble();

				if (marks < 0 || marks > 100) {
					System.out.println("Marks must be between 0 and 100.");
				}
			} else {
				System.out.println("Invalid input. Enter numbers only.");
				scanner.next();
			}
		}

		return marks;
	}
}