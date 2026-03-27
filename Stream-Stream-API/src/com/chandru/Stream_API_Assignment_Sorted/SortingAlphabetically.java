package com.chandru.Stream_API_Assignment_Sorted;

import java.util.Arrays;
import java.util.List;

public class SortingAlphabetically {
	public static void main(String[] args) {
		List<String> sorting = Arrays.asList("chandrashekhar", "kartik", "aryan", "bhuvanesh", "chandan");

		sorting.stream().sorted().forEach(System.out::println);
	}

}
