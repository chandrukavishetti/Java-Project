package com.chandru.collection.librerytestmodel1;

import java.util.LinkedList;
import java.util.Queue;

public class IssueQueueManager {

	private Queue<Book> issueQueue = new LinkedList<>();

	public void addIssueRequest(Book book) {

		issueQueue.add(book);
	}

	public void processIssue() {

		if (issueQueue.isEmpty()) {
			System.out.println("No issue requests");
			return;
		}

		Book book = issueQueue.poll();

		System.out.println("Processing issue for : " + book.getTitle());
	}

	public void displayQueue() {

		for (Book book : issueQueue) {
			System.out.println(book.getTitle());
		}
	}
}