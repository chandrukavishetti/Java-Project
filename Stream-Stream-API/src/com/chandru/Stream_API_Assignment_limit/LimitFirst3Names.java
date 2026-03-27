package com.chandru.Stream_API_Assignment_limit;

import java.util.Arrays;
import java.util.List;

public class LimitFirst3Names {
	public static void main(String[] args) {
		List<String> names = Arrays.asList("chandrashekhar", "ibrahim", "nihal", "arbaaz", "shreenath");

		names.stream().limit(3).forEach(System.out::println);
	}

}
