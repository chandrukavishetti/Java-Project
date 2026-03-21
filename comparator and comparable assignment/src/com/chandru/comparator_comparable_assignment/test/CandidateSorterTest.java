package com.chandru.comparator_comparable_assignment.test;

import java.util.ArrayList;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.InputMismatchException;
import com.chandru.comparator_comparable_assignment.model.Candidate;

public class CandidateSorterTest {

	public static class NameThenAgeComparator implements Comparator<Candidate> {
		@Override
		public int compare(Candidate c1, Candidate c2) {
			int nameComparison = c1.getName().compareTo(c2.getName());

			if (nameComparison != 0) {
				return nameComparison;
			}

			return Integer.compare(c1.getAge(), c2.getAge());
		}
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		List<Candidate> candidates = new ArrayList<>();
		int numberOfCandidates = 0;

		System.out.println("=== Candidate Sorter ===");
		System.out.println("This program sorts candidates by name (A-Z) and then by age (youngest to oldest)\n");

		while (true) {
			try {
				System.out.print("How many candidates do you want to enter? ");
				numberOfCandidates = scanner.nextInt();

				if (numberOfCandidates <= 0) {
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

		System.out.println("\n--- Enter Candidate Details ---");

		for (int i = 0; i < numberOfCandidates; i++) {
			System.out.println("\nCandidate " + (i + 1) + ":");

			String name = "";
			while (true) {
				System.out.print("Enter Name: ");
				name = scanner.nextLine().trim();

				if (name.isEmpty()) {
					System.out.println("Error: Name cannot be empty.");
				} else if (!name.matches("[a-zA-Z\\s]+")) {
					System.out.println("Error: Name should contain only letters and spaces.");
				} else {
					break;
				}
			}

			int age = 0;
			while (true) {
				try {
					System.out.print("Enter Age: ");
					age = scanner.nextInt();

					if (age <= 0) {
						System.out.println("Error: Age must be greater than zero.");
						continue;
					}

					if (age > 120) {
						System.out.println("Error: Please enter a valid age (1-120).");
						continue;
					}

					scanner.nextLine();
					break;

				} catch (InputMismatchException e) {
					System.out.println("Error: Please enter a valid integer for age.");
					scanner.nextLine();
				}
			}

			candidates.add(new Candidate(name, age));
		}

		System.out.println("\n======================================");
		System.out.println("Original Candidate List (Before Sorting):");
		System.out.println("======================================");
		printCandidates(candidates);

		Collections.sort(candidates, new NameThenAgeComparator());

		System.out.println("\n======================================");
		System.out.println("Sorted Candidate List (After Sorting by Name, then Age):");
		System.out.println("======================================");
		printCandidates(candidates);

		scanner.close();
	}

	public static void printCandidates(List<Candidate> candidates) {
		System.out.println("\nName\t\t\tAge");
		System.out.println("--------------------------------------");
		for (int i = 0; i < candidates.size(); i++) {
			Candidate c = candidates.get(i);
			System.out.printf("%d. %-20s %d years\n", (i + 1), c.getName(), c.getAge());
		}
	}
}