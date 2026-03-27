package com.chandru.Stream_API_Assignment_Sorted;

import java.util.Arrays;
import java.util.List;

public class SortNumberAscending {
	public static void main(String[] args) {
		List<Integer> sortedNumbers = Arrays.asList(10, 36, 21, 2, 51, 67, 13);

		sortedNumbers.stream().sorted().forEach(System.out::println);
	}

}
