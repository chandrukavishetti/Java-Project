package com.chandru.string_assignment.model;

public class SentenceFormatterModel {
	private String sentence;

	public SentenceFormatterModel(String sentence) {
		this.sentence = sentence;
	}

	public void formatingSentence() {

		String trimmedSentence = sentence.trim();

		String lowerCaseSentence = trimmedSentence.toLowerCase();

		String firstLetterCapital = lowerCaseSentence.substring(0, 1).toUpperCase() + lowerCaseSentence.substring(1);

		String replacedSentence = firstLetterCapital.replace("fun", "interesting");

		String[] eachWord = replacedSentence.split(" ");
		int totalWords = eachWord.length;

		String firstWord = eachWord[0];
		String lastWord = eachWord[totalWords - 1];

		System.out.println("Formatted Sentence: " + replacedSentence);
		System.out.println("Total words: " + totalWords);
		System.out.println("First word: " + firstWord);
		System.out.println("Last word: " + lastWord);

	}

}
