package com.chandru.exception_Assignement.model;

import java.util.Scanner;
import java.util.InputMismatchException;

public class Finally_block {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int balance = 10000;

		try {
			while (true) {
				System.out.println("enter the amount to withdraw");
				int withdraw = scanner.nextInt();

				if (withdraw > 10000) {
					throw new ArithmeticException("enter the amount less than 10000");
				} else {
					balance = balance - withdraw;
					System.out.println("balance amount is : " + balance);
					break;
				}
			}
		} catch (InputMismatchException e) {
			System.out.println("enter the integer only");
		} catch (ArithmeticException e) {
			System.out.println(e.getMessage());
		} finally {
			System.out.println("Transaction session ended");
			scanner.close();
		}
	}
}