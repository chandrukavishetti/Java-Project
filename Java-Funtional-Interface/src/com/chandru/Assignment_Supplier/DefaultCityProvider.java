package com.chandru.Assignment_Supplier;

import java.util.Scanner;
import java.util.function.Supplier;

public class DefaultCityProvider {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		Supplier<String> defaultcity = () -> "pune";

		System.out.print("enter the city name : ");
		String city = scanner.nextLine();

		if (city == null || city.trim().isEmpty()) {
			city = defaultcity.get();

		}
		System.out.println("city : " + city);

		scanner.close();
	}

}
