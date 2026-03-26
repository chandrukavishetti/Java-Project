package com.chandru.Stream_API_Assignment_filter;

import java.util.Arrays;
import java.util.List;

public class EvenNumberFilter {
	public static void main(String[] args) {
		List<Integer> numbers = Arrays.asList(10, 20, 14, 28, 95, 11);

		System.out.println("numbers are : " + numbers);

		numbers.stream().filter(num -> num % 2 == 0).forEach(System.out::println);
	}

}
