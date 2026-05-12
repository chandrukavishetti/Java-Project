package com.chandru.collection.librerytest1;

import com.chandru.collection.librerytestmodel1.*;

public class LibraryTest {

	public static void main(String[] args) {

		LibraryRepository repo = new LibraryRepository();
		IssueQueueManager queue = new IssueQueueManager();
		UserInputHandler input = new UserInputHandler();

		boolean running = true;

		while (running) {
			System.out.println("\n--- Library Menu ---");
			System.out.println("1. Insert Book");
			System.out.println("2. Issue Book (by ID)");
			System.out.println("3. Display All Sorted Books");
			System.out.println("4. Exit");

			int choice = input.readInt("Enter your choice: ");

			switch (choice) {
			case 1:
				insertBookFlow(repo, input);
				break;

			case 2:
				issueBookFlow(repo, queue, input);
				break;

			case 3:
				System.out.println("\n--- Final Library Inventory (Sorted by ID) ---");
				repo.displayBooks();
				break;

			case 4:
				running = false;
				System.out.println("Exiting System...");
				break;

			default:
				System.out.println("Invalid choice. Please try again.");
			}
		}
	}

	private static void insertBookFlow(LibraryRepository repo, UserInputHandler input) {
		try {
			int id = input.readInt("Enter Book ID: ");
			String title = input.readString("Enter Title: ");
			String author = input.readAuthor("Enter Author: ");
			int type = input.readBookType();

			BookValidator.validate(id, title, author);

			Book book = createBook(type, id, title, author);
			repo.addBook(book);
			System.out.println("Book Added Successfully.");

		} catch (DuplicateBookException | InvalidBookDataException e) {
			System.err.println("Error: " + e.getMessage());
		}
	}

	private static void issueBookFlow(LibraryRepository repo, IssueQueueManager queue, UserInputHandler input) {
		int id = input.readInt("Enter Book ID to issue: ");
		Book bookFound = repo.findBook(id);

		if (bookFound != null) {
			queue.addIssueRequest(bookFound);
			queue.processIssue();
			repo.removeBook(id);
			System.out.println("Book with ID " + id + " has been issued and removed from inventory.");
		} else {
			System.out.println("Book not found.");
		}
	}

	private static Book createBook(int type, int id, String title, String author) {
		if (type == 1)
			return new AcademicBook(id, title, author); // [cite: 7]

		return new Magazine(id, title, author); // [cite: 7]
	}
}