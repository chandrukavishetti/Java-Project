package com.chandru.collection.hashset_treeset;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

// 1. SystemUser class (Not public, so it can live in the same file)
class SystemUser implements Comparable<SystemUser> {
	private int userId;
	private String username;

	public SystemUser(int userId, String username) {
		this.userId = userId;
		this.username = username;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		SystemUser that = (SystemUser) o;
		return userId == that.userId;
	}

	@Override
	public int hashCode() {
		return Objects.hash(userId);
	}

	@Override
	public int compareTo(SystemUser other) {
		return Integer.compare(this.userId, other.userId);
	}

	@Override
	public String toString() {
		return "[" + userId + "-" + username + "]";
	}
}

// 2. Main execution class
public class SetDeepDive {
	public static void main(String[] args) {
		System.out.println("--- HashSet (Fast, Unordered) ---");
		Set<SystemUser> activeSessions = new HashSet<>();

		activeSessions.add(new SystemUser(105, "admin"));
		activeSessions.add(new SystemUser(102, "guest"));
		activeSessions.add(new SystemUser(108, "moderator"));

		boolean isAdded = activeSessions.add(new SystemUser(105, "admin_imposter"));

		System.out.println("Was duplicate added? " + isAdded);
		System.out.println("HashSet Output: " + activeSessions);

		System.out.println("\n--- TreeSet (Slower, Sorted) ---");
		Set<SystemUser> sortedDirectory = new TreeSet<>();

		sortedDirectory.add(new SystemUser(105, "admin"));
		sortedDirectory.add(new SystemUser(102, "guest"));
		sortedDirectory.add(new SystemUser(108, "moderator"));

		System.out.println("TreeSet Output: " + sortedDirectory);
	}
}