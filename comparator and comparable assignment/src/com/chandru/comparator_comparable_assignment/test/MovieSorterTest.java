package com.chandru.comparator_comparable_assignment.test;

import java.util.ArrayList;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.InputMismatchException;
import com.chandru.comparator_comparable_assignment.model.Movie;

public class MovieSorterTest {

	public static class YearDescTitleAscComparator implements Comparator<Movie> {
		@Override
		public int compare(Movie m1, Movie m2) {
			// First compare by year (descending - latest first)
			int yearComparison = Integer.compare(m2.getYear(), m1.getYear());

			if (yearComparison != 0) {
				return yearComparison;
			}

			// If same year, compare by title (ascending A-Z)
			return m1.getTitle().compareTo(m2.getTitle());
		}
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		List<Movie> movies = new ArrayList<>();
		int numberOfMovies = 0;

		System.out.println("=== Movie Sorter ===");
		System.out.println("This program sorts movies by year (latest first) and then by title (A-Z)\n");

		while (true) {
			try {
				System.out.print("How many movies do you want to enter? ");
				numberOfMovies = scanner.nextInt();

				if (numberOfMovies <= 0) {
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

		System.out.println("\n--- Enter Movie Details ---");

		for (int i = 0; i < numberOfMovies; i++) {
			System.out.println("\nMovie " + (i + 1) + ":");

			String title = "";
			while (true) {
				System.out.print("Enter Movie Title: ");
				title = scanner.nextLine().trim();

				if (title.isEmpty()) {
					System.out.println("Error: Title cannot be empty.");
				} else {
					break;
				}
			}

			int year = 0;
			while (true) {
				try {
					System.out.print("Enter Release Year: ");
					year = scanner.nextInt();

					if (year < 1888) { // First movie was made in 1888
						System.out.println("Error: Please enter a valid year (1888 or later).");
						continue;
					}

					if (year > 2026) { // Current year +1 as future movies might be planned
						System.out.println("Error: Please enter a valid year (up to 2026).");
						continue;
					}

					scanner.nextLine();
					break;

				} catch (InputMismatchException e) {
					System.out.println("Error: Please enter a valid integer for year.");
					scanner.nextLine();
				}
			}

			movies.add(new Movie(title, year));
		}

		System.out.println("\n======================================");
		System.out.println("Original Movie List (Before Sorting):");
		System.out.println("======================================");
		printMovies(movies);

		Collections.sort(movies, new YearDescTitleAscComparator());

		System.out.println("\n======================================");
		System.out.println("Sorted Movie List (After Sorting by Year - Latest First, then Title A-Z):");
		System.out.println("======================================");
		printMovies(movies);

		scanner.close();
	}

	public static void printMovies(List<Movie> movies) {
		System.out.println("\nTitle\t\t\t\tYear");
		System.out.println("--------------------------------------");
		for (int i = 0; i < movies.size(); i++) {
			Movie m = movies.get(i);
			System.out.printf("%d. %-30s %d\n", (i + 1), m.getTitle(), m.getYear());
		}
	}
}