package com.chandru.Stream_API_Assignment_limit;

import java.util.Arrays;
import java.util.List;

public class SortByDescendingDisplyTop3 {
	public static void main(String[] args) {
		List<String> names = Arrays.asList("chandrashekhar", "kavishetti", "motivation", "diciplane", "hardworking",
				"male", "cycle");

		names.stream().sorted((a, b) -> a.length() - b.length()).limit(3).forEach(System.out::println);
	}

}
