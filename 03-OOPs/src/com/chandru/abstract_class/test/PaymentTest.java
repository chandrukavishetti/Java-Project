package com.chandru.abstract_class.test;

import java.util.Scanner;
import com.chandru.abstract_class.model.UPIPayment;
import com.chandru.abstract_class.model.WalletPayment;
import com.chandru.abstract_class.model.CreditCardPayment;
import com.chandru.abstract_class.model.Payment;

public class PaymentTest {

	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {

		Payment[] payments = new Payment[3];

		payments[0] = createCreditCardPayment();
		payments[1] = createUPIPayment();
		payments[2] = createWalletPayment();

		System.out.println("\n======= Processing Payments =======\n");

		for (Payment payment : payments) {
			payment.processPayment();
			payment.generateReceipt();
		}
	}

	public static double getValidAmount() {
		double amount = 0;
		boolean valid = false;

		while (!valid) {
			System.out.print("Enter Amount: ");

			if (scanner.hasNextDouble()) {
				amount = scanner.nextDouble();

				if (amount > 0) {
					valid = true;
				} else {
					System.out.println("Amount must be greater than 0.");
				}
			} else {
				System.out.println("Invalid Input! Enter numeric value only.");
				scanner.next();
			}
		}
		return amount;
	}

	public static String getValidName(String message) {
		String name = "";
		boolean valid = false;

		while (!valid) {
			System.out.print(message);
			name = scanner.next();

			if (name.matches("[a-zA-Z]+")) {
				valid = true;
			} else {
				System.out.println("Invalid Name! Only alphabets allowed.");
			}
		}
		return name;
	}

	public static String getValidUPI() {
		String upi = "";
		boolean valid = false;

		while (!valid) {
			System.out.print("Enter UPI ID: ");
			upi = scanner.next();

			if (upi.contains("@")) {
				valid = true;
			} else {
				System.out.println("Invalid UPI ID! Must contain '@'");
			}
		}
		return upi;
	}

	public static Payment createCreditCardPayment() {
		System.out.println("\n--- Credit Card Payment ---");
		double amount = getValidAmount();
		String name = getValidName("Enter Card Holder Name: ");
		return new CreditCardPayment(amount, name);
	}

	public static Payment createUPIPayment() {
		System.out.println("\n--- UPI Payment ---");
		double amount = getValidAmount();
		String upi = getValidUPI();
		return new UPIPayment(amount, upi);
	}

	public static Payment createWalletPayment() {
		System.out.println("\n--- Wallet Payment ---");
		double amount = getValidAmount();
		String wallet = getValidName("Enter Wallet Name: ");
		return new WalletPayment(amount, wallet);
	}
}