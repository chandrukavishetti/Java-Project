package com.chandru.Interface.test;

import java.util.Scanner;

import com.chandru.Interface.model.Vehicle;
import com.chandru.Interface.model.Car;
import com.chandru.Interface.model.Bike;

public class VehicleTest {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		Vehicle[] vehicles = new Vehicle[2];
		int carChoice = 0;

		while (carChoice != 1 && carChoice != 2) {
			System.out.println("choose car fuel type");
			System.out.println("1. petrol");
			System.out.println("2. diesel");

			if (scanner.hasNextInt()) {
				carChoice = scanner.nextInt();
				if (carChoice != 1 && carChoice != 2) {
					System.out.println("invalid choice");
				}
			} else {
				System.out.println("enter number only");
				scanner.next();

			}

		}
		String fuel = (carChoice == 1) ? "petrol" : "diesel";

		vehicles[0] = new Car(fuel);
		vehicles[1] = new Bike();

		System.out.println("----------vehicle details-----");
		for (Vehicle vehicle : vehicles) {
			vehicle.start();
			System.out.println("fuel type : " + vehicle.fuelType());
			vehicle.stop();
			System.out.println();
		}
		scanner.close();
	}

}
