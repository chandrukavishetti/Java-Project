package com.chandru.string_assignment.test;

import java.util.Scanner;
import com.chandru.string_assignment.model.FileNameValidatorModel;

public class FileNameValidatorTest {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		try {
			System.out.println("Enter the file name : ");
			String validator = scanner.nextLine();

			FileNameValidatorModel filevalidator = new FileNameValidatorModel(validator);
			filevalidator.fileChecker();

		} catch (Exception e) {
			System.out.println("error : " + e.getMessage());
		} finally {
			scanner.close();
		}

	}

}
