package com.chandru.claude_ArrayList_ex;

import java.util.ArrayList;
import java.util.Collections;

public class AttendanceTracker {
	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<>();
		list.add("raju");
		list.add("chandru");
		list.add("pruthviraj");
		list.add("kartik");

		System.out.println("list : " + list);

		list.add(3, "meghraj");
		System.out.println("after adding the element by late : " + list);

		System.out.println("is Alice is present : " + list.contains("Alice"));

		System.out.println("sublist of element 1 to 3 : " + list.subList(1, 3));

		Collections.reverse(list);// reversing the collection
		System.out.println("after reversing the list : " + list);

	}

}
