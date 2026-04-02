package com.chandru.Stream_API_Library_Book.model;

import java.util.*;
import java.util.stream.Collectors;

public class BookServices {

	// 1. Get all available books
	public List<Book> getAllAvailableBook(List<Book> list) {
		return list.stream().filter(Book::getAvailable).collect(Collectors.toList());
	}

	// 2. Group books by genre
	public Map<Integer, List<Book>> groupByGeneration(List<Book> list) {
		return list.stream().collect(Collectors.groupingBy(Book::getGeneration));
	}

	// 3. Count books generation-wise
	public Map<Integer, Long> countByGeneration(List<Book> list) {
		return list.stream().collect(Collectors.groupingBy(Book::getGeneration, Collectors.counting()));
	}

	// 4. Most expensive book
	public Optional<Book> getMostExpensiveBook(List<Book> list) {
		return list.stream().max(Comparator.comparingDouble(Book::getPrice));
	}

	// 5. Sort by price ascending (titles)
	public List<String> getSortedByTitlePrice(List<Book> list) {
		return list.stream().sorted(Comparator.comparingDouble(Book::getPrice)).map(Book::getTitle)
				.collect(Collectors.toList());
	}

	// 6. Check any unavailable book exists
	public boolean hasUnavailableBook(List<Book> list) {
		return list.stream().anyMatch(b -> !b.getAvailable());
	}

	// 7. Unique authors
	public Set<String> getUniqueAuthors(List<Book> list) {
		return list.stream().map(Book::getAuthor).collect(Collectors.toSet());
	}
}

//package com.chandru.Stream_API_Library_Book.model;
//
//import java.util.*;
//import java.util.stream.Collectors;
//import java.util.stream.Stream;
//
//public class BookServices {
//	//1.get all available book
//	public boolean getAllAvailableBook(List<Book>list){
//		return list.stream().filter(b->b.getAvailable()).equals("available");
//	}
//	
//	//2.book group by generation
//	public Map<Integer,List<Book>>groupByGeneration(List<Book>list){
//		return list.stream().collect(Collectors.groupingBy(Book::getGeneration));
//	}
//	
//	//3.count book generation wise
//	public Map<Integer,Long>countByGeneration(List<Book>list){
//		return list.stream().collect(Collectors.groupingBy(Book::getGeneration,Collectors.counting()));
//	}
//	
//	//4.find the most expensive book
//	public Optional<Book> getMostExpensiveBook(List<Book>list){
//		return list.stream().max(Comparator.comparingDouble(Book::getPrice));
//	}
//	
//	//5.create a sorted list of titles by price ascending 
//	public Stream<Book> getSortedByTitlePrice(List<Book>list){
//		return list.stream().sorted(Comparator.comparing(Book::getPrice));
//	}
//	
//	//6.check weather the unavailable book is present or not
//	public boolean getAllUnavailableBook(List<Book>list) {
//		return list.stream().filter(n->n.getAvailable()).equals("no");
//	}
//	
//	//7.create a set of all unique authors
//	public Stream<Book> getUniqueAuthors(Set<Book>set){
//		return set.stream().filter(s->s.getAuthor()).distinct();
//	}
//}
