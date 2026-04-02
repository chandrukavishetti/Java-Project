package com.chandru.Stream_API_Library_Book.test;

import java.util.ArrayList;
import java.util.List;

import com.chandru.Stream_API_Library_Book.model.Book;
import com.chandru.Stream_API_Library_Book.model.BookServices;
import com.chandru.Stream_API_Library_Book.model.InputHandler;

public class LibraryBookTest {

	public static void main(String[] args) {

		InputHandler input = new InputHandler();
		BookServices service = new BookServices();
		List<Book> list = new ArrayList<>();

		int n = input.getInt("Enter the number of books : ");

		for (int i = 0; i < n; i++) {
			System.out.println("\n------ Enter Book " + (i + 1) + " Details ------");

			int id = input.getInt("Enter book id : ");
			String title = input.getString("Enter book title : ");
			String author = input.getString("Enter author name : ");
			int generation = input.getInt("Enter generation : ");
			boolean available = input.getBoolean("Is book available");
			double price = input.getDouble("Enter price : ");

			list.add(new Book(id, title, author, generation, available, price));
		}

		// 1
		System.out.println("\n--- Available Books ---");
		service.getAllAvailableBook(list).forEach(System.out::println);

		// 2
		System.out.println("\n--- Group By Generation ---");
		System.out.println(service.groupByGeneration(list));

		// 3
		System.out.println("\n--- Count By Generation ---");
		System.out.println(service.countByGeneration(list));

		// 4
		System.out.println("\n--- Most Expensive Book ---");
		service.getMostExpensiveBook(list).ifPresent(System.out::println);

		// 5
		System.out.println("\n--- Titles Sorted By Price ---");
		service.getSortedByTitlePrice(list).forEach(System.out::println);

		// 6
		System.out.println("\nAny unavailable book? " + service.hasUnavailableBook(list));

		// 7
		System.out.println("\n--- Unique Authors ---");
		System.out.println(service.getUniqueAuthors(list));
	}
}

//package com.chandru.Stream_API_Library_Book.test;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import com.chandru.Stream_API_Library_Book.model.Book;
//import com.chandru.Stream_API_Library_Book.model.BookServices;
//import com.chandru.Stream_API_Library_Book.model.InputHandler;
//
//public class LibraryBookTest {
//public static void main(String[] args) {
//	InputHandler input =new InputHandler();
//	BookServices service=new BookServices();
//	List<Book> list=new ArrayList<>();
//	
//	int n=input.getInt("Enter the number of books : ");
//	
//	for(int i=1;i<n;i++) {
//		System.out.println("\n------enter the order "+(i+1)+" Details---");
//		
//		int id=input.getInt("enter the book id : ");
//		String name=input.getString("enter the book title : ");
//		String author=input.getString("enter the author name : ");
//		int generation=input.getInt("enter the generation of the book : ");
//		boolean available=input.getBoolean("is book available : ");
//		double price=input.getDouble("Enter the price of the book : ");
//		
//		list.add(new Book(id,name,author,generation,available,price));
//		
//		
//	}
//	
//	System.out.println("--all available books----");
//	service.getAllAvailableBook(list).forEach(System.out::println);
//	
//	System.out.println("");
//}
//}
