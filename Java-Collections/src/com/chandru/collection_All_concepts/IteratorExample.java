package com.chandru.collection_All_concepts;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class IteratorExample {
	public static void main(String[] args) {
		Collection<String> list = new ArrayList<>();

		list.add("Rahul");
		list.add("Priya");
		list.add("Amit");

		Iterator<String> itr = list.iterator();

		while (itr.hasNext()) {
			System.out.println(itr.next());
		}
	}
}