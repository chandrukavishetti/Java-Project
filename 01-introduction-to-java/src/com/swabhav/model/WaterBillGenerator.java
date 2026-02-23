package com.swabhav.model;

import java.util.Scanner;

public class WaterBill {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("enter the electricity consumed in units : ");
		float userInput = scanner.nextFloat();
		float defaultMeterCharge = 75;
		float charge = 0;
		float total = 0;
		if(userInput<0) {
			System.out.println("enter the positive number : ");
		}
		else if (userInput <= 100) {
			charge = userInput * 5;
			total = charge + defaultMeterCharge;

		} else if (userInput <= 250) {
			charge = userInput * 10;
			total = charge + defaultMeterCharge;

		} else {
			charge = userInput * 20;
			total = charge + defaultMeterCharge;

		}
		System.out.println(" your total bill is : " + total);

		scanner.close();
	}

}
