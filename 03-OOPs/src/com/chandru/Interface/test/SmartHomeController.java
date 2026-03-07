package com.chandru.Interface.test;

import java.util.Scanner;
import com.chandru.Interface.model.TV;
import com.chandru.Interface.model.Speaker;
import com.chandru.Interface.model.Light;
import com.chandru.Interface.model.Fan;
import com.chandru.Interface.model.Controllable;

public class SmartHomeController {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		boolean mainMenu = true;
		System.out.println("\n====smart home device controller===");
		while (mainMenu) {
			System.out.println("\n select device ");
			System.out.println("1. light");
			System.out.println("2. fan");
			System.out.println("3. tv");
			System.out.println("4. speaker");
			System.out.println("5. exit");

			int deviceChoice = getValidChoice(scanner, 1, 5);
			if (deviceChoice == 5) {
				System.out.println("exiting smart home controller");
				break;
			}

			Controllable device = null;

			switch (deviceChoice) {
			case 1:
				device = new Light();
				break;
			case 2:
				device = new Fan();
				break;
			case 3:
				device = new TV();
				break;
			case 4:
				device = new Speaker();
				break;
			}
			boolean deviceMenu = true;
			while (deviceMenu) {
				System.out.println("\ndevice menu: ");
				System.out.println("1. turn on");
				System.out.println("2. turn off");
				System.out.println("3. set mode");
				System.out.println("4. back to main menu");

				int actionChoice = getValidChoice(scanner, 1, 4);

				switch (actionChoice) {
				case 1:
					device.turnOn();
					break;
				case 2:
					device.turnOff();
					break;
				case 3:
					if (deviceChoice == 3) {

						System.out.println("select tv display mode");
						System.out.println("1. hd");
						System.out.println("2. full hd");
						System.out.println("3. quad hd");

						int tvMode = getValidChoice(scanner, 1, 3);

						String[] tvModes = { "hd", "full hd", "quad hd" };
						device.setMode(tvModes[tvMode - 1]);

					} else {

						while (true) {
							System.out.println("enter the mode (low / medium / high)");
							String mode = scanner.next().toLowerCase();

							if (mode.equals("low") || mode.equals("medium") || mode.equals("high")) {
								device.setMode(mode);
								break;
							}

							System.out.println("invalid mode. enter only low, medium, high");
						}
					}
					break;
				case 4:
					deviceMenu = false;
					break;
				}
			}
		}
		scanner.close();
	}

	private static int getValidChoice(Scanner scanner, int min, int max) {
		int choice = 0;
		while (choice < min || choice > max) {
			if (scanner.hasNextInt()) {
				choice = scanner.nextInt();

				if (choice < min || choice > max) {
					System.out.println("invlid choice select between " + min + "and" + max + ".");

				}
			} else {
				System.out.println("enter the number only");
				scanner.next();
			}
		}
		return choice;
	}
}
