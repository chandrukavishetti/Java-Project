package com.chandru.claude_HashMap_ex;

import java.util.HashMap;
import java.util.Map;

public class WordFrequencyCounter {
	public static void main(String[] args) {
		String sentence = "java is fun and java is easy";
		String[] words = sentence.split(" ");

		// Count frequency using getOrDefault()
		HashMap<String, Integer> freqMap = new HashMap<>();
		for (String word : words) {
			freqMap.put(word, freqMap.getOrDefault(word, 0) + 1);
		}

		// Print count of 'java'
		System.out.println("Count of 'java': " + freqMap.get("java"));

		// Find word with highest frequency
		String maxWord = "";
		int maxCount = 0;
		for (Map.Entry<String, Integer> entry : freqMap.entrySet()) {
			if (entry.getValue() > maxCount) {
				maxCount = entry.getValue();
				maxWord = entry.getKey();
			}
		}
		System.out.println("Highest frequency word: '" + maxWord + "' (" + maxCount + " times)");

		// Print all words appearing more than once
		System.out.print("Words appearing more than once: ");
		for (Map.Entry<String, Integer> entry : freqMap.entrySet()) {
			if (entry.getValue() > 1) {
				System.out.print("'" + entry.getKey() + "' (" + entry.getValue() + ") ");
			}
		}
		System.out.println();
	}
}
