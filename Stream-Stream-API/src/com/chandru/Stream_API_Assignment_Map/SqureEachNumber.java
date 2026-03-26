package com.chandru.Stream_API_Assignment_Map;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SqureEachNumber {
	public static void main(String[] args) {
		List<Integer> numbers = Arrays.asList(10, 15, 25, 3, 6, 26);

		List<Integer> squre = numbers.stream().map(number -> number * number).collect(Collectors.toList());

		System.out.println("After squaring each number : ");
		squre.forEach(System.out::println);

	}

}
