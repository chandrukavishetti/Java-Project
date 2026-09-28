package com.chandru.collection.hashset_treeset;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

// 1. Implement Comparable so TreeSet knows how to sort this object
class SetDeepDive implements Comparable<SetDeepDive> {
	private int userId;
	private String username;

	public SetDeepDive(int userId, String username) {
		this.userId = userId;
		this.username = username;
	}

	// 2. Override equals() so HashSet knows how to identify a duplicate
	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		SetDeepDive that = (SetDeepDive) o;
		// Two users are considered identical if they have the same userId
		return userId == that.userId;
	}

	// 3. Override hashCode() to ensure equal objects end up in the same memory
	// bucket
	@Override
	public int hashCode() {
		return Objects.hash(userId);
	}

	// 4. Define the sorting logic for TreeSet (Sorting ascending by userId)
	@Override
	public int compareTo(SetDeepDive other) {
		return Integer.compare(this.userId, other.userId);
	}

	@Override
	public String toString() {
		return "[" + userId + "-" + username + "]";
	}
}

public class SetDeepDive {
	public static void main(String[] args) {
		System.out.println("--- HashSet (Fast, Unordered) ---");
		Set<SetDeepDive> activeSessions = new HashSet<>();

		activeSessions.add(new SetDeepDive(105, "admin"));
		activeSessions.add(new SetDeepDive(102, "guest"));
		activeSessions.add(new SetDeepDive(108, "moderator"));

		// Attempting to add a duplicate (Same ID, different name)
		boolean isAdded = activeSessions.add(new SetDeepDive(105, "admin_imposter"));

		System.out.println("Was duplicate added? " + isAdded);
		System.out.println("HashSet Output: " + activeSessions);
		// Notice the output order will not match the insertion order

		System.out.println("\n--- TreeSet (Slower, Sorted) ---");
		Set<SetDeepDive> sortedDirectory = new TreeSet<>();

		sortedDirectory.add(new SetDeepDive(105, "admin"));
		sortedDirectory.add(new SetDeepDive(102, "guest"));
		sortedDirectory.add(new SetDeepDive(108, "moderator"));

		System.out.println("TreeSet Output: " + sortedDirectory);
		// Output will strictly be [102-guest], [105-admin], [108-moderator]
	}
}