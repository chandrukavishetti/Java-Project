package com.chandru.collection_All_concepts;

import java.util.*;

public class CollectionObj {
	public static void main(String[] args) {
		Collection<Integer> numbers = new ArrayList<>();

		numbers.add(10);
		numbers.add(20);
		numbers.add(30);

		System.out.println("Initial ArrayList : " + numbers);

		Collection<Integer> moreNumbers = new ArrayList<>();

		moreNumbers.add(40);
		moreNumbers.add(50);
		moreNumbers.add(60);

		numbers.addAll(moreNumbers);

		System.out.println("after adding the more numbers : " + numbers);

		// removing elements
		Collection<String> fruits = new ArrayList<>();

		fruits.add("mango");
		fruits.add("banana");

		System.out.println("before deleting the fruits : " + fruits);

		fruits.remove("banana");

		System.out.println("After removing the banana : " + fruits);

		// accesing the elements
		int firstNumber = ((ArrayList<Integer>) numbers).get(0);
		System.out.println("first number is : " + firstNumber);

		int lastNumber = ((ArrayList<Integer>) numbers).get(numbers.size() - 1);
		System.out.println("getting the laast number : " + lastNumber);

		// Iterating over the collections
		Collection<String> list = (Collection<String>) new LinkedListExample();

		list.add("one");
		list.add("percent");
		list.add("better");

		System.out.println("initial list is : " + list);

		Iterator<String> it = list.iterator();

		System.out.println("iterator values : ");
		while (it.hasNext()) {
			System.out.println(it.next() + " ");
		}

	}
}
/*
 * the collection only adding removing and checking something weather the
 * element is present or not and size of the array
 * 
 * 
 * for example :
 * 
 * Think of Collection as a basic container - like a simple bag. A bag only
 * allows you to:
 * 
 * Put things in (add())
 * 
 * Take things out (remove())
 * 
 * Check if something is inside (contains())
 * 
 * Check how many things are inside (size())
 * 
 * But a bag doesn't let you:
 * 
 * Access items by position (like "give me the 3rd item")
 * 
 * Replace an item at a specific position
 * 
 * Find the index/position of an item
 */
