package com.chandru.Inventory_mng_sys.test;

import java.util.Scanner;

public class InputHandler {

	private Scanner sc = new Scanner(System.in);

	public int getInt(String msg) {
		while (true) {
			try {
				System.out.print(msg);
				return Integer.parseInt(sc.nextLine());
			} catch (Exception e) {
				System.out.println("Invalid number! Try again.");
			}
		}
	}

	public double getDouble(String msg) {
		while (true) {
			try {
				System.out.print(msg);
				return Double.parseDouble(sc.nextLine());
			} catch (Exception e) {
				System.out.println("Invalid input! Try again.");
			}
		}
	}

	public String getString(String msg) {
		System.out.print(msg);
		return sc.nextLine();
	}
}