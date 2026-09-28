package com.chandru.claude_HashMap_ex;

import java.util.HashMap;
import java.util.Map;

public class HashMapDeepDive {
	public static void main(String[] args) {
		// Map<KeyType, ValueType>
		Map<String, String> projectTeam = new HashMap<>();

		// 1. Adding Data (put)
		projectTeam.put("EMP-001", "Senior Developer");
		projectTeam.put("EMP-002", "Analyst Trainee");
		projectTeam.put("EMP-003", "Database Admin");

		// 2. Fast Retrieval (get)
		// We instantly fetch the role without looping through the collection
		String myRole = projectTeam.get("EMP-002");
		System.out.println("Lookup EMP-002: " + myRole);

		// 3. The Overwrite Rule
		// EMP-001 gets promoted. Using the same key overwrites the existing value.
		projectTeam.put("EMP-001", "Tech Lead");

		// 4. Checking existence
		if (projectTeam.containsKey("EMP-003")) {
			System.out.println("We have a Database Admin on board.");
		}

		// 5. Iterating through a HashMap
		// We use entrySet() to get both the Key and the Value at the same time
		System.out.println("\n--- Full Team Roster ---");
		for (Map.Entry<String, String> entry : projectTeam.entrySet()) {
			System.out.println("ID: " + entry.getKey() + " | Role: " + entry.getValue());
		}
	}
}