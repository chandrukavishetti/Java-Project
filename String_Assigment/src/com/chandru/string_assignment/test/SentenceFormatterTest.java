package com.chandru.string_assignment.test;

import com.chandru.string_assignment.model.SentenceFormatterModel;

public class SentenceFormatterTest {
	public static void main(String[] args) {
		
		String sentence = "java programming is FUN and powerful";
		
		SentenceFormatterModel formatter= new SentenceFormatterModel(sentence);
		formatter.formatingSentence();

	}
}