package com.chandru.collection.model1;

public class Magazine extends Book {

	public Magazine(int id, String title, String author) {
		super(id, title, author);
	}

	@Override
	public void display() {
		System.out.println("Magazine -> ID:" + getBookId() + " Title:" + getTitle() + " Author:" + getAuthor());
	}
}