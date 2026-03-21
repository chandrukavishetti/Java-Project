package com.chandru.collection.model1;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class LibraryRepository {

	private Set<Book> books = new TreeSet<>();

	public void addBook(Book book) throws DuplicateBookException {

		if (!books.add(book)) {
			throw new DuplicateBookException("Duplicate Book ID : " + book.getBookId());
		}
	}

	public void displayBooks() {

		for (Book b : books) {
			b.display();
		}
	}

	public void removeBook(int id) {

		Iterator<Book> itr = books.iterator();

		while (itr.hasNext()) {

			Book b = itr.next();

			if (b.getBookId() == id) {
				itr.remove();
			}
		}
	}

	public Book findBook(int id) {

		for (Book b : books) {
			if (b.getBookId() == id)
				return b;
		}
		return null;
	}
}