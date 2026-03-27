package com.chandru.Stream_API_Assignment_Skip;

import java.util.Arrays;
import java.util.List;

public class FilterEvenAndSkipTwo {
	public static void main(String[] args) {
		List<Integer> numbers = Arrays.asList(10, 29, 47, 88, 96, 62);

		numbers.stream().filter(num -> num % 2 == 0).skip(2).forEach(System.out::println);
	}

}
