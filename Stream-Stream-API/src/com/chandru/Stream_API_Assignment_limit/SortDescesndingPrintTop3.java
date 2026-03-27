package com.chandru.Stream_API_Assignment_limit;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;

public class SortDescesndingPrintTop3 {
	public static void main(String[] args) {
		List<Integer> numbers = Arrays.asList(100, 34, 90, 12, 42, 29, 66, 15);

		numbers.stream().sorted(Collections.reverseOrder()).limit(3).forEach(System.out::println);
	}

}
