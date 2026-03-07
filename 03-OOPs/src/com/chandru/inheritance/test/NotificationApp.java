package com.chandru.inheritance.test;

import java.util.Scanner;

import com.chandru.inheritance.model.EmailNotification;
import com.chandru.inheritance.model.PushNotification;
import com.chandru.inheritance.model.SMSNotification;
import com.chandru.inheritance.model.Notification;

public class NotificationApp {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int choice;
		while (true) {
			System.out.println("Select Notification Type:\n1. Email\n2. SMS\n3. Push");
			System.out.print("Enter choice: ");
			String choiceInput = scanner.nextLine().trim();

			if (choiceInput.isEmpty()) {
				System.out.println("Choice cannot be blank.");
				continue;
			}

			boolean isDigit = true;
			for (int i = 0; i < choiceInput.length(); i++) {
				if (!Character.isDigit(choiceInput.charAt(i))) {
					isDigit = false;
					break;
				}
			}

			if (!isDigit) {
				System.out.println("Error: Input must be a number (1, 2, or 3).");
				continue;
			}

			choice = Integer.parseInt(choiceInput);
			if (choice >= 1 && choice <= 3) {
				break;
			}
			System.out.println("Invalid choice. Please select 1, 2, or 3.");
		}

		String recipient;
		while (true) {
			System.out.print("Enter Recipient: ");
			recipient = scanner.nextLine().trim();

			if (recipient.isEmpty()) {
				System.out.println("Error: Recipient cannot be blank.");
				continue;
			}

			
			if (choice == 1) { 
				if (recipient.indexOf('@') == -1 || recipient.indexOf('.') == -1) {
					System.out.println("Invalid Email format. Must contain '@' and '.'.");
					continue;
				}
			} else if (choice == 2) { 
				boolean onlyDigits = true;
				for (int i = 0; i < recipient.length(); i++) {
					if (!Character.isDigit(recipient.charAt(i))) {
						onlyDigits = false;
						break;
					}
				}
				if (!onlyDigits) {
					System.out.println("Invalid SMS recipient. Please enter numbers only.");
					continue;
				}
			}
			break;
		}

		String message;
		while (true) {
			System.out.print("Enter Message: ");
			message = scanner.nextLine().trim();

			if (message.isEmpty()) {
				System.out.println("Error: Message cannot be blank.");
				continue;
			}
			break;
		}

		Notification notification = null;
		if (choice == 1) {
			notification = new EmailNotification(recipient, message);
		} else if (choice == 2) {
			notification = new SMSNotification(recipient, message);
		} else if (choice == 3) {
			notification = new PushNotification(recipient, message);
		}

		if (notification != null) {
			notification.send();
		}

		scanner.close();
	}
}