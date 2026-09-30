package com.chandru.collection.hashset_treeset;

import java.util.TreeSet;

public class TreeSetNavigation {
	public static void main(String[] args) {
		// Must declare as TreeSet (not just Set) to expose the NavigableSet methods
		TreeSet<Integer> availableSeats = new TreeSet<>();

		// We add these completely out of order
		availableSeats.add(25);
		availableSeats.add(5);
		availableSeats.add(15);
		availableSeats.add(10);
		availableSeats.add(20);

		// 1. Automatic Sorting
		System.out.println("Available Seats: " + availableSeats);
		// Output: [5, 10, 15, 20, 25]

		// 2. Finding closest matches (The real power of TreeSet)
		int requestedSeat = 12;

		// ceiling(): Finds the lowest element that is >= requested match
		System.out.println("Closest seat rounding up: " + availableSeats.ceiling(requestedSeat));
		// Output: 15

		// floor(): Finds the highest element that is <= requested match
		System.out.println("Closest seat rounding down: " + availableSeats.floor(requestedSeat));
		// Output: 10

		// 3. Strict greater/less than lookups
		// higher(): Strictly greater than 15
		System.out.println("Next seat after 15: " + availableSeats.higher(15));
		// Output: 20

		// lower(): Strictly less than 15
		System.out.println("Seat right before 15: " + availableSeats.lower(15));
		// Output: 10

		// 4. Subsets (Grabbing a specific range of data)
		// Gets all seats from 10 (inclusive) to 20 (exclusive)
		System.out.println("Seats in middle section: " + availableSeats.subSet(10, 20));
		// Output: [10, 15]
	}
}