package com.chandru.Stream_API_Assignment_anyMatch;

import java.util.Arrays;
import java.util.List;

public class EntireWordIsInUpperCase {
	public static void main(String[] args) {
		List<String> words = Arrays.asList("Red", "Green", "yellow", "pink", "WHITE", "SKUBLUE");

		boolean result = words.stream().anyMatch(word -> word.equals(word.toUpperCase()));

		System.out.println("In the list of word any word completly written in the UpperCase? : " + result);
	}

}
