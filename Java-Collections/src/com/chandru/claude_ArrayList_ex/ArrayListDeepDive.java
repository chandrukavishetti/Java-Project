package com.chandru.claude_ArrayList_ex;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ArrayListDeepDive {
	public static void main(String[] args) {
		// Best practice: Program to the interface (List) rather than the concrete
		// implementation
		List<String> frameworks = new ArrayList<>();

		frameworks.add("Spring");
		frameworks.add("Hibernate");
		frameworks.add("Struts");

		// Fast random access
		System.out.println("Framework at index 1: " + frameworks.get(1));

		// Safely removing elements while iterating
		// Using a standard for-each loop to remove elements here throws a
		// ConcurrentModificationException
		Iterator<String> iterator = frameworks.iterator();
		while (iterator.hasNext()) {
			String framework = iterator.next();
			if (framework.equals("Struts")) {
				iterator.remove(); // Safely removes "Struts" and shifts remaining elements left
			}
		}

		System.out.println("Modern Stack: " + frameworks);
	}
}