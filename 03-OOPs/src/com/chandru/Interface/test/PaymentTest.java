package com.chandru.Interface.test;

import java.util.Scanner;
import com.chandru.Interface.model.CreditCardPayment;
import com.chandru.Interface.model.DebitCardPayment;
import com.chandru.Interface.model.Payment;
import com.chandru.Interface.model.UPIPayment;

public class PaymentTest {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Payment payment = null;

		System.out.println("==payment system==");
		int choice = 0;
		while (choice < 1 || choice > 3) {
			System.out.println("choose Payment method");
			System.out.println("1. credit card");
			System.out.println("2. debit card");
			System.out.println("3. UPI");

			if (scanner.hasNextInt()) {
				choice = scanner.nextInt();
				if (choice < 1 || choice > 3) {
					System.out.println("invlaid choice");
				}

			} else {

				System.out.println("enter the number only");
				scanner.next();
			}
		}
		switch (choice) {
		case 1:
			payment = new CreditCardPayment();
			break;
		case 2:
			payment = new DebitCardPayment();
			break;
		case 3:
			payment = new UPIPayment();
			break;
		}
		double amount = 0;
		while (amount <= 0) {
			System.out.println("enter the amount : ");
			if (scanner.hasNextDouble()) {
				amount = scanner.nextDouble();
				if (amount <= 0) {
					System.out.println("amount must be positive");
				}
			} else {
				System.out.println("enter number only");
				scanner.next();
			}
		}
		System.out.println();
		payment.processPayment(amount);
		scanner.close();
	}
}
