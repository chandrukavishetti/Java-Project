package com.chandru.collection.queue;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class QueueDeepDive {
	public static void main(String[] args) {

		System.out.println("--- Standard FIFO Queue ---");
		// We use a LinkedList to instantiate a standard Queue
		Queue<String> validationRequests = new LinkedList<>();

		validationRequests.offer("Request 1: Check Row 1");
		validationRequests.offer("Request 2: Check Column 3");
		validationRequests.offer("Request 3: Check Grid 4");

		// peek() lets us look at the head without removing it
		System.out.println("Next to process: " + validationRequests.peek());

		// poll() removes and returns the head
		while (!validationRequests.isEmpty()) {
			System.out.println("Processing: " + validationRequests.poll());
		}

		System.out.println("\n--- PriorityQueue ---");
		// PriorityQueue sorts elements automatically.
		// For Integers, the lowest number becomes the head (highest priority).
		Queue<Integer> taskPriorities = new PriorityQueue<>();

		taskPriorities.offer(50);
		taskPriorities.offer(10);
		taskPriorities.offer(30);

		// Even though 10 was added second, PriorityQueue moves it to the front
		System.out.println("Highest priority task pulled: " + taskPriorities.poll());
		System.out.println("Next highest task pulled: " + taskPriorities.poll());
	}
}