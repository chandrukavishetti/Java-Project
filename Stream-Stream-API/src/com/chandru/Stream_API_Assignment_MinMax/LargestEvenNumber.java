package com.chandru.Stream_API_Assignment_MinMax;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class LargestEvenNumber {

	public static void main(String[] args) {

		List<Integer> numbers = Arrays.asList(10, 20, 55, 67, 90, 11, 68);

		Optional<Integer> maxEven = numbers.stream().filter(num -> num % 2 == 0).max(Integer::compareTo);

		System.out.println("Largest even number is: " + maxEven.get());

		// method 2
//		int max = numbers.stream()
//		        .filter(n -> n % 2 == 0)
//		        .sorted((a, b) -> b - a)  
//		        .findFirst()              
//		        .get();
	}
}