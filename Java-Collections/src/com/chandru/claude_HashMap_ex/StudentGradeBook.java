package com.chandru.claude_HashMap_ex;

import java.util.HashMap;

public class StudentGradeBook {
	public static void main(String[] args) {
		HashMap<String, Integer> hashmap = new HashMap<String, Integer>();
		hashmap.put("chandru", 85);
		hashmap.put("pruthviraj", 75);
		hashmap.put("Ram", 45);
		hashmap.put("sham", 25);
		hashmap.put("lakshman", 55);

		System.out.println("original hashmap : " + hashmap);

		System.out.println("students marks : " + hashmap.values());

		hashmap.put("pruthviraj", 99);
		System.out.println("after updating the pruthviraj marks : " + hashmap);

		System.out.println("is bob is present in the list : " + hashmap.containsKey("bob"));

		System.out.println("after removing the sham : " + hashmap.remove("sham"));

		System.out.println("printing using entrySet : " + hashmap.entrySet());
	}

}
