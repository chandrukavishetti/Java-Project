package com.chandru.collection.collegestudentmodel3;

import java.util.Scanner;

public class StudentValidator {

	private Scanner sc = new Scanner(System.in);

	public int readInt(String msg) {

		while (true) {
			System.out.print(msg);
			try {
				return Integer.parseInt(sc.nextLine());
			} catch (Exception e) {
				System.out.println("Invalid number.");
			}
		}
	}

	public double readDouble(String msg) {

		while (true) {
			System.out.print(msg);
			try {
				return Double.parseDouble(sc.nextLine());
			} catch (Exception e) {
				System.out.println("Invalid amount.");
			}
		}
	}

	public String readString(String msg) {

		while (true) {
			System.out.print(msg);
			String val = sc.nextLine();

			if (val.trim().isEmpty()) {
				System.out.println("Cannot be empty.");
				continue;
			}
			return val;
		}
	}

	public int readOrderType() {

		while (true) {

			System.out.println("\n1. Regular Order");
			System.out.println("2. Priority Order");

			try {
				int ch = Integer.parseInt(sc.nextLine());

				if (ch == 1 || ch == 2)
					return ch;

				System.out.println("Choose 1 or 2");

			} catch (Exception e) {
				System.out.println("Invalid input");
			}
		}
	}

}
