package com.chandru.exception_Assignement.model;

import java.util.Scanner;

public class Try_catch {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		try {
			System.out.println("enter the number 1 to divide : ");
			if (!scanner.hasNextInt()) {
				System.out.println("enter the integer only");
				scanner.next();

			}
			int num1 = scanner.nextInt();

			System.out.println("enter the 2nd number to divide : ");
			if (!scanner.hasNextInt()) {
				System.out.println("enter the integer only");
				scanner.next();

			}
			int num2 = scanner.nextInt();

			int result = num1 / num2;
			System.out.println("Result : " + result);

		} catch (ArithmeticException e) {
			System.out.println("error do not enter the 2nd number 0");
		} finally {
			System.out.println("finally block");
		}
		scanner.close();

	}
}
