package com.chandru.Stream_API_Assignment_limit;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FilterEvenLimit4AndCalculateTotal {
	public static void main(String[] args) {
		List<Integer> numbers = Arrays.asList(16, 57, 98, 77, 32, 48, 7, 51, 67, 18, 26);

		int total = numbers.stream().filter(num -> num % 2 == 0).limit(4).collect(Collectors.summingInt(i -> i));

		System.out.println("top 4 even number total : " + total);
	}

}
