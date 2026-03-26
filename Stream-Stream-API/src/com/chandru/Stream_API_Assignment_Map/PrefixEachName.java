package com.chandru.Stream_API_Assignment_Map;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PrefixEachName {
	public static void main(String[] args) {
		List<String> names = Arrays.asList("Sweta", "soumy", "Aishwary", "Rupa", "priyanka");

		String prefix = "Ms";
		List<String> fullName = names.stream().map(name -> prefix + " " + name).collect(Collectors.toList());

		System.out.println("All names with prefix : ");
		fullName.forEach(System.out::println);
	}

}
