package com.chandru.string_assignment.test;

import java.util.Scanner;
import com.chandru.string_assignment.model.IPv4ValidatorModel;

public class IPv4ValidatorTest {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		try {
			System.out.println("Enter an IPv4 address to validate (e.g., 192.168.1.1):");
			String input = scanner.nextLine();

			IPv4ValidatorModel validator = new IPv4ValidatorModel(input);
			validator.validateIP();

		} catch (Exception e) {
			System.out.println("An unexpected error occurred: " + e.getMessage());
		} finally {
			scanner.close();
		}
	}
}