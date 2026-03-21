package com.chandru.comparator_comparable_assignment.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.InputMismatchException;
import com.chandru.comparator_comparable_assignment.model.Flight;

public class FlightSorterTest {

	public static class FareDescendingComparator implements Comparator<Flight> {
		@Override
		public int compare(Flight f1, Flight f2) {
			return Double.compare(f2.getFare(), f1.getFare());
		}
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		List<Flight> flights = new ArrayList<>();
		int numberOfFlights = 0;

		System.out.println("=== Flight Fare Sorter ===");
		System.out.println("This program sorts flights by fare (highest to lowest)\n");

		while (true) {
			try {
				System.out.print("How many flights do you want to enter? ");
				numberOfFlights = scanner.nextInt();

				if (numberOfFlights <= 0) {
					System.out.println("Error: Please enter a positive number.");
					continue;
				}

				scanner.nextLine();
				break;

			} catch (InputMismatchException e) {
				System.out.println("Error: Please enter a valid positive integer.");
				scanner.nextLine();
			}
		}

		System.out.println("\n--- Enter Flight Details ---");

		for (int i = 0; i < numberOfFlights; i++) {
			System.out.println("\nFlight " + (i + 1) + ":");

			String airline = "";
			while (true) {
				System.out.print("Enter Airline Name: ");
				airline = scanner.nextLine().trim();

				if (airline.isEmpty()) {
					System.out.println("Error: Airline name cannot be empty.");
				} else {
					break;
				}
			}

			double price = 0;
			while (true) {
				try {
					System.out.print("Enter Fare Price: $");
					price = scanner.nextDouble();

					if (price <= 0) {
						System.out.println("Error: Price must be greater than zero.");
						continue;
					}

					scanner.nextLine();
					break;

				} catch (InputMismatchException e) {
					System.out.println("Error: Please enter a valid number for price.");
					scanner.nextLine();
				}
			}

			flights.add(new Flight(airline, price));
		}

		System.out.println("\n======================================");
		System.out.println("Original Flight List (Before Sorting):");
		System.out.println("======================================");
		printFlights(flights);

		Collections.sort(flights, new FareDescendingComparator());

		System.out.println("\n======================================");
		System.out.println("Sorted Flight List (After Sorting by Fare - Highest First):");
		System.out.println("======================================");
		printFlights(flights);

		scanner.close();
	}

	public static void printFlights(List<Flight> flights) {
		System.out.println("\nAirline\t\t\tFare");
		System.out.println("--------------------------------------");
		for (int i = 0; i < flights.size(); i++) {
			Flight f = flights.get(i);
			System.out.printf("%d. %-15s $%.2f\n", (i + 1), f.getAirline(), f.getFare());
		}
	}
}