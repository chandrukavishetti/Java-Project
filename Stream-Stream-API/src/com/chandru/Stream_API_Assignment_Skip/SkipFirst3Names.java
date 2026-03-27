package com.chandru.Stream_API_Assignment_Skip;

import java.util.Arrays;
import java.util.List;

public class SkipFirst3Names {
	public static void main(String[] args) {
		List<String> names = Arrays.asList("chandrashekhar", "swaraj", "sampath", "laxmi", "shashwat", "prartana");

		names.stream().skip(3).forEach(System.out::println);
	}

}
