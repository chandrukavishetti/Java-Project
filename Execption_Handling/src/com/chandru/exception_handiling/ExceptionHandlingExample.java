package com.chandru.exception_handiling;

import java.util.Scanner;

public class ExceptionHandlingExample {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		try {
			System.out.println("enter the number 1 to divide : ");
			int num1 = scanner.nextInt();
			System.out.println("enter the number 2 to divide : ");
			int num2 = scanner.nextInt();
			int division = num1 / num2;
			System.out.println("Questient : " + division);

		} catch (ArithmeticException e) {
			System.out.println("Error do no enter 2nd number 0");
		} finally {
			scanner.close();
			System.out.println("exception finished");
		}
	}

}
