package com.chandru.Interface.test;

import java.util.Scanner;
import com.chandru.Interface.model.Car1;
import com.chandru.Interface.model.VehicleControl;
import com.chandru.Interface.model.Bike1;
import com.chandru.Interface.model.Truck;

public class VehicleTest1 {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		VehicleControl vehicle = null;

		System.out.println("====== Vehicle Control System ======");

		int choice = 0;

		while (choice < 1 || choice > 3) {

			System.out.println("Select Vehicle:");
			System.out.println("1. Car");
			System.out.println("2. Bike");
			System.out.println("3. Truck");

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
			vehicle = new Car1();
			break;

		case 2:
			vehicle = new Bike1();
			break;

		case 3:
			vehicle = new Truck();
			break;
		}

		boolean continueOperation = true;

		while (continueOperation) {

			System.out.println("\nChoose Operation:");
			System.out.println("1. Start");
			System.out.println("2. Change Gear");
			System.out.println("3. Stop");
			System.out.println("4. Exit");

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
				vehicle.start();
				break;

			case 2:
				int gear = getValidGear(scanner);
				vehicle.changeGear(gear);
				break;

			case 3:
				vehicle.stop();
				break;

			case 4:
				continueOperation = false;
				System.out.println("Exiting Vehicle Control System.");
				break;

			default:
				System.out.println("Invalid operation. Choose between 1 and 4.");
			}
		}

		scanner.close();
	}

	private static int getValidGear(Scanner scanner) {

		int gear = 0;

		while (gear <= 0) {

			System.out.println("Enter Gear Number:");

			if (scanner.hasNextInt()) {
				gear = scanner.nextInt();

				if (gear <= 0) {
					System.out.println("Gear must be greater than 0.");
				}
			} else {
				System.out.println("Invalid input. Enter numbers only.");
				scanner.next();
			}
		}

		return gear;
	}
}