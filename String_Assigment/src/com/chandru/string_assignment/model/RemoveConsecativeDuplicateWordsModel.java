package com.chandru.string_assignment.model;

public class RemoveConsecativeDuplicateWordsModel {
	private String sentence;

	public RemoveConsecativeDuplicateWordsModel(String sentence) {
		this.sentence = sentence;
	}

	public void duplicateWord() {
		try {

			if (sentence == null || sentence.trim().isEmpty()) {
				throw new Exception("Input sentence cannot be null or empty.");
			}

			String trimmedInput = sentence.trim();

			String[] words = trimmedInput.split("\\s+");

			if (words.length == 0) {
				return;
			}

			StringBuilder result = new StringBuilder();
			int totalRemoved = 0;

			for (int i = 0; i < words.length; i++) {

				if (i == words.length - 1 || !words[i].equalsIgnoreCase(words[i + 1])) {
					result.append(words[i]).append(" ");
				} else {
					totalRemoved++;
				}
			}

			System.out.println("Original Sentence: " + trimmedInput);
			System.out.println("Cleaned Sentence: " + result.toString().trim());
			System.out.println("Consecutive duplicates removed: " + totalRemoved);

		} catch (Exception e) {
			System.out.println("error : " + e.getMessage());
		}
	}
}