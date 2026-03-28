package com.chandru.Stream_API_Assignment_findFirst;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class GetFirstEvenNumber {
	public static void main(String[] args) {
		List<Integer> numbers = Arrays.asList(11, 23, 26, 80, 36);

		Optional<Integer> firstEvenNumber = numbers.stream().filter(num -> num % 2 == 0).findFirst();

		System.out.println("first even number in the list is : " + firstEvenNumber.get());
	}

}
