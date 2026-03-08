package com.chandru.string_assignment.model;

public class ReverseWordModel {
	private String sentence;

	public ReverseWordModel(String sentence) {
		this.sentence = sentence;
	}

	public void reverseWord() {
		try {
			if (sentence == null || sentence.trim().isEmpty()) {
				throw new Exception("Sentence cannot be empty.");
			}

			String trimmedSentence = sentence.trim();

			String[] words = trimmedSentence.split("\\s+");

			StringBuilder finalResult = new StringBuilder();

			for (String word : words) {
				StringBuilder reversedWord = new StringBuilder();

				for (int i = word.length() - 1; i >= 0; i--) {
					reversedWord.append(word.charAt(i));
				}

				finalResult.append(reversedWord).append(" ");
			}

			System.out.println("Original sentence: " + trimmedSentence);
			System.out.println("Reversed each word: " + finalResult.toString().trim());

		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}
	}
}