package com.chandru.Stream_API_Assignment_Skip;

import java.util.Arrays;
import java.util.List;

public class FilterLengthMoreThan3AndSkip3 {
	public static void main(String[] args) {
		List<String> words = Arrays.asList("chandrashekhar", "ok", "mother", "hi", "dhurandhar", "toxic", "titanic",
				"stockmarket");

		words.stream().filter(w -> w.length() > 3).skip(3).forEach(System.out::println);
	}

}
