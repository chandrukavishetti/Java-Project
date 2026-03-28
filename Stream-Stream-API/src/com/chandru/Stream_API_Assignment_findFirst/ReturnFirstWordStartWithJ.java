package com.chandru.Stream_API_Assignment_findFirst;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class ReturnFirstWordStartWithJ {
	public static void main(String[] args) {
		List<String> words = Arrays.asList("Mango", "Rasmalai", "JackFruit", "StrawBerry", "Jully");

		Optional<String> result = words.stream().filter(word -> word.toUpperCase().startsWith("J")).findFirst();

		if (result.isPresent()) {
			System.out.println("first word start with 'J' : " + result.get());
		}

	}

}
