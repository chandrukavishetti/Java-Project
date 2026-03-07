package com.chandru.string_assignment.model;

public class WordFrequencyCounterModel {
	private String sentence;

	public WordFrequencyCounterModel(String sentence) {
		this.sentence = sentence;
	}

	public void countFrequency() {
		try {
			String lowerCaseSentence = sentence.toLowerCase().trim();

			if (lowerCaseSentence.isEmpty()) {
				throw new Exception("Sentence cannot be empty.");
			}

			// regex "\\s+" handles multiple spaces between words
			String[] words = lowerCaseSentence.split("\\s+");
			boolean[] visited = new boolean[words.length];

			System.out.println("--- Word Frequencies ---");

			for (int i = 0; i < words.length; i++) {
				// Skip this word if it has already been counted
				if (visited[i]) {
					continue;
				}

				int count = 1;
				for (int j = i + 1; j < words.length; j++) {
					if (words[i].equals(words[j])) {
						count++;
						visited[j] = true; // Mark as counted
					}
				}

				System.out.println(words[i] + ": " + count);
			}

		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}
	}
}