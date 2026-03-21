package com.chandru.collection.model1;

public class AcademicBook extends Book {

	public AcademicBook(int id, String title, String author) {
		super(id, title, author);
	}

	@Override
	public void display() {
		System.out.println("Academic Book -> ID:" + getBookId() + " Title:" + getTitle() + " Author:" + getAuthor());
	}
}