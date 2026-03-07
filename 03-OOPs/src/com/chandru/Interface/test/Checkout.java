package com.chandru.Interface.test;

import java.util.Scanner;
import com.chandru.Interface.model.UPI;
import com.chandru.Interface.model.PaymentGateway;
import com.chandru.Interface.model.NetBanking;
import com.chandru.Interface.model.CreditCard;

public class Checkout {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		PaymentGateway gateway = null;

		System.out.println("====== E-Commerce Checkout ======");

		int choice = 0;

		while (choice < 1 || choice > 3) {

			System.out.println("Select Payment Method:");
			System.out.println("1. Credit Card");
			System.out.println("2. UPI");
			System.out.println("3. NetBanking");

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
			gateway = new CreditCard();
			break;

		case 2:
			gateway = new UPI();
			break;

		case 3:
			gateway = new NetBanking();
			break;
		}

		boolean continueTransaction = true;

		while (continueTransaction) {

			System.out.println("\nChoose Operation:");
			System.out.println("1. Pay");
			System.out.println("2. Refund");
			System.out.println("3. Exit");

			int operation = 0;

			if (scanner.hasNextInt()) {
				operation = scanner.nextInt();
			} else {
				System.out.println("Invalid input. Enter numbers only.");
				scanner.next();
				continue;
			}

			switch (operation) {

			case 1:
				double payAmount = getValidAmount(scanner);
				gateway.pay(payAmount);
				break;

			case 2:
				double refundAmount = getValidAmount(scanner);
				gateway.refund(refundAmount);
				break;

			case 3:
				continueTransaction = false;
				System.out.println("Thank you for shopping with us!");
				break;

			default:
				System.out.println("Invalid operation. Choose between 1 and 3.");
			}
		}

		scanner.close();
	}

	private static double getValidAmount(Scanner scanner) {

		double amount = 0;

		while (amount <= 0) {

			System.out.println("Enter Amount:");

			if (scanner.hasNextDouble()) {
				amount = scanner.nextDouble();

				if (amount <= 0) {
					System.out.println("Amount must be greater than 0.");
				}
			} else {
				System.out.println("Invalid input. Enter numbers only.");
				scanner.next();
			}
		}

		return amount;
	}
}