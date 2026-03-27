package com.chandru.Stream_API_Assignment_Count;

import java.util.Arrays;
import java.util.List;

public class CountingNumberStartsWithA {
	public static void main(String[] args) {
		List<String> startsWithA = Arrays.asList("akash", "chandrashekhar", "amitesh", "Sheshachal", "aryan");

		long total = startsWithA.stream().filter(word -> word.toUpperCase().startsWith("A")).count();

		System.out.println("number of words which starts with A : " + total);

	}

}
