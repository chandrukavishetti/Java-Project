package com.chandru.OCP.Education_LMS.model;

public class ArticleContent implements Content {

	private String title;
	private String author;

	public ArticleContent(String title, String author) {
		this.title = title;
		this.author = author;
	}

	@Override
	public void render() {
		System.out.println("Reading Article: " + title + " by " + author);
	}
}