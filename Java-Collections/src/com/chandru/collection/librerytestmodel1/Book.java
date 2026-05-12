package com.chandru.collection.librerytestmodel1;

public abstract class Book implements Comparable<Book> {

	private int bookId;
	private String title;
	private String author;

	public Book(int bookId, String title, String author) {
		this.bookId = bookId;
		this.title = title;
		this.author = author;
	}

	public int getBookId() {
		return bookId;
	}

	public String getTitle() {
		return title;
	}

	public String getAuthor() {
		return author;
	}

	@Override
	public int compareTo(Book o) {
		return Integer.compare(this.bookId, o.bookId);
	}

	@Override
	public int hashCode() {
		return Integer.hashCode(bookId);
	}

	@Override
	public boolean equals(Object obj) {

		if (obj instanceof Book) {
			Book b = (Book) obj;
			return this.bookId == b.bookId;
		}
		return false;
	}

	public abstract void display();
}