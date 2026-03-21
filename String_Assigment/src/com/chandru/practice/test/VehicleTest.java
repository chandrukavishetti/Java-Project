package com.chandru.practice.test;

import java.util.Scanner;
import com.chandru.practice.model.Vehicle;
import com.chandru.practice.model.Car;
import com.chandru.practice.model.Bike;

public class VehicleTest {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.println("enter the car brand name : ");
		String cname = scanner.nextLine();

		System.out.println("enter the car speed : ");
		int cSpeed = scanner.nextInt();

		System.out.println("enter the bike speed name : ");
		int bspeed = scanner.nextInt();

		System.out.println("enter the bike brand neame : ");
		String bname = scanner.nextLine();

		Car car = new Car(cname, cSpeed);
		car.move();

		Bike bike = new Bike(bname, bspeed);
		bike.move();

	}

}
