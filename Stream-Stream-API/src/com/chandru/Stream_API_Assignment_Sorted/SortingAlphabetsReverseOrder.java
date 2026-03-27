package com.chandru.Stream_API_Assignment_Sorted;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SortingAlphabetsReverseOrder {
	public static void main(String[] args) {
		List<String> sorting = Arrays.asList("chandrashekhar", "kartik", "aryan", "bhuvanesh", "chandan");

		sorting.stream().sorted(Collections.reverseOrder()).forEach(System.out::println);
	}

}
