package com.chandru.collection_All_concepts;

import java.util.LinkedList;
import java.util.ListIterator;

public class LinkedListDeepDive {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// Declaring as a LinkedList to access specific Deque methods
		LinkedList<String> executionQueue = new LinkedList<>();

		executionQueue.add("Validate Input");
		executionQueue.add("Process Data");
		executionQueue.add("Save to Database");

		// LinkedList specific methods (O(1) operations)
		executionQueue.addFirst("Initialize Logger");
		executionQueue.addLast("Send Confirmation Email");

		System.out.println("Current Sequence: " + executionQueue);

		// Removing the first and last elements
		String firstTask = executionQueue.removeFirst();
		String lastTask = executionQueue.removeLast();

		System.out.println("Completed: " + firstTask);
		System.out.println("Remaining Sequence: " + executionQueue);

		// to add in the inbetween
		executionQueue.add(1, "run the code");
		System.out.println("after adding at 1nth position : " + executionQueue);

		executionQueue.remove(2);
		System.out.println("after removing at 2nd position : " + executionQueue);

		System.out.println();
		System.out.println();
		// advanced topics in linkedlist
		LinkedList<String> moveHistory = new LinkedList<>();

		// 1. Using Deque methods for Stack behavior (Last-In, First-Out)
		// Pushing moves onto the top of the stack (the front of the list)
		moveHistory.push("Player X: Position 1,1");
		moveHistory.push("Player O: Position 1,2");
		moveHistory.push("Player X: Position 2,2");

		System.out.println("Current Move History: " + moveHistory);
		// Output: [Player X: Position 2,2, Player O: Position 1,2, Player X: Position
		// 1,1]

		// Peeking at the last move made (top of the stack)
		System.out.println("Last move made: " + moveHistory.peek());

		// 2. Using ListIterator to rewind the state (Undo functionality)
		System.out.println("\n--- Rewinding Moves ---");

		// Start the iterator at the beginning of the list
		ListIterator<String> historyIterator = moveHistory.listIterator();

		// Move forward to the end of our current list to set up reverse traversal
		while (historyIterator.hasNext()) {
			historyIterator.next();
		}

		// Now traverse backwards
		while (historyIterator.hasPrevious()) {
			String previousMove = historyIterator.previous();
			System.out.println("Undoing: " + previousMove);

			// We can even alter the list during traversal
			if (previousMove.contains("Position 1,2")) {
				historyIterator.set("Player O: Position 1,2 (REVERTED)");
			}
		}

		System.out.println("\nState after iterator modifications: " + moveHistory);

		// 3. Popping elements (removing the most recent move permanently)
		String revertedMove = moveHistory.pop();
		System.out.println("\nPopped off the stack permanently: " + revertedMove);
		System.out.println("Final History: " + moveHistory);
	}
}