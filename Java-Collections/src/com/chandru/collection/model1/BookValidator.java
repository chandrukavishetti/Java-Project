package com.chandru.collection.model1;

public class BookValidator {

	public static void validate(int id, String title, String author) throws InvalidBookDataException {

		if (id <= 0) {
			throw new InvalidBookDataException("Book ID must be positive");
		}
		if (title == null || title.trim().isEmpty()) {
			throw new InvalidBookDataException("Title cannot be empty");
		}
		if (author == null || author.trim().isEmpty()) {
			throw new InvalidBookDataException("Author cannot be empty");
		}
	}
}