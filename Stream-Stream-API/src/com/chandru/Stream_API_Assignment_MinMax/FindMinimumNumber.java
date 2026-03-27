package com.chandru.Stream_API_Assignment_MinMax;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class FindMinimumNumber {
	public static void main(String[] args) {
		List<Integer> numbers = Arrays.asList(10, 30, 20, 70, 5);

		Optional<Integer> min = numbers.stream().min(Integer::compareTo);

		System.out.println("minimum number : " + min.get());

	}

}
