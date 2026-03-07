package com.chandru.string_assignment.test;

import java.util.Scanner;
import com.chandru.string_assignment.model.EmailAnalyzer;

public class EmailAnalyzerTest {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		try {
			System.out.println("Enter email  :");
			String inputEmail = sc.nextLine();

			if (inputEmail == null || inputEmail.trim().isEmpty()) {
				throw new Exception("email cannot be empty");

			}

			EmailAnalyzer analyzer = new EmailAnalyzer(inputEmail);
			analyzer.analyzeEmail();
		} catch (Exception e) {
			System.out.println("Error " + e.getMessage());
		} finally {
			sc.close();
		}
	}

}
