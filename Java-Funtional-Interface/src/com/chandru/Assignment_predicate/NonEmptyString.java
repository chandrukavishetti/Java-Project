package com.chandru.Assignment_predicate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class NonEmptyString {
	public static void main(String[] args) {
		Predicate<String> isValid = str -> str != null && !str.isEmpty();

		List<String> list = Arrays.asList("", "Java", null, "");

		for (String s : list) {
			if (isValid.test(s)) {
				System.out.println(s);
			}
		}
	}
}