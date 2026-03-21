
package com.chandru.collection_All_concepts;

import java.util.*;

public class LinkedListExample {
	public static void main(String[] args) {
		LinkedList<String> ll = new LinkedList<>();

		ll.add("gods");
		ll.add("plan");
		ll.add("always");

		System.out.println(ll);

		// updating
		ll.set(0, "god's");
		System.out.println("after editing : " + ll);

		// removing
		ll.remove(2);
		System.out.println("after removing : " + ll);

		// iterating
		for (int i = 0; i < ll.size(); i++) {
			System.out.println(ll.get(i) + " ");
		}
	}
}