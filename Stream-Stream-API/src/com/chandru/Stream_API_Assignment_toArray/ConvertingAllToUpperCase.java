package com.chandru.Stream_API_Assignment_toArray;

import java.util.Arrays;

public class ConvertingAllToUpperCase {
	public static void main(String[] args) {
		String[] array = { "chandrashkhar", "monocept", "cognizant", "TCS" };

		String[] uppercaseLetters = Arrays.stream(array).map(String::toUpperCase).toArray(String[]::new);

		for (String letters : uppercaseLetters) {
			System.out.println(letters);
		}
	}

}
