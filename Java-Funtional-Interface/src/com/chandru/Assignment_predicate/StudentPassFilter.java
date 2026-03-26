package com.chandru.Assignment_predicate;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Predicate;

public class StudentPassFilter {
	public static void main(String[] args) {
		Map<String, Integer> students = new HashMap<>();

		students.put("chandrashekhar", 76);
		students.put("Ravi", 26);
		students.put("Kanu", 66);
		students.put("Kartik", 45);
		students.put("Pruthviraj", 80);

		Predicate<Integer> isPass = marks -> marks >= 40;

		for (Map.Entry<String, Integer> entry : students.entrySet()) {
			if (isPass.test(entry.getValue())) {
				System.out.println("Name : " + entry.getKey() + " | marks : " + entry.getValue());
			}
		}
	}

}
