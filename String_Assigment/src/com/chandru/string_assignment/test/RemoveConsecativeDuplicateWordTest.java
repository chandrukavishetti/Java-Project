package com.chandru.string_assignment.test;

import java.util.Scanner;
import com.chandru.string_assignment.model.RemoveConsecativeDuplicateWordsModel;

public class RemoveConsecativeDuplicateWordTest {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		try {
			System.out.print("enter the sentence to remove duplicate words : ");
			String sentence = scanner.nextLine();

			RemoveConsecativeDuplicateWordsModel duplicate = new RemoveConsecativeDuplicateWordsModel(sentence);
			duplicate.duplicateWord();
		} catch (Exception e) {
			System.out.println("error : " + e.getMessage());
		} finally {
			scanner.close();
		}
	}

}
