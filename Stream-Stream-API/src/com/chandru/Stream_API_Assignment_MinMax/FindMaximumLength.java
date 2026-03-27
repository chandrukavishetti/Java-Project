package com.chandru.Stream_API_Assignment_MinMax;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class FindMaximumLength {
	public static void main(String[] args) {
		List<String> names = Arrays.asList("chandrashekhar", "pruthviraj", "megharaj", "monocept");

		Optional<String> maxLengthName = names.stream().max((a, b) -> a.length() - b.length());

		System.out.println("maximuml length student name : " + maxLengthName.get());

	}

}
