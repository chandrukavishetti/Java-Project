package com.chandru.Stream_API_Library_Book.model;

public class Book {
	private int id;
	private String title;
	private String author;
	private int generation;
	private boolean available;
	private double price;

	public Book(int id, String title, String author, int generation, boolean available, double price) {
		this.id = id;
		this.title = title;
		this.author = author;
		this.generation = generation;
		this.available = available;
		this.price = price;
	}

	public int getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public String getAuthor() {
		return author;
	}

	public int getGeneration() {
		return generation;
	}

	public boolean getAvailable() {
		return available;
	}

	public double getPrice() {
		return price;
	}

	@Override
	public String toString() {
		return "Id is : " + id + " Title : " + title + " Author : " + author + " generation : "
				+ (available ? "available" : "no") + " price : " + price;
	}

}
