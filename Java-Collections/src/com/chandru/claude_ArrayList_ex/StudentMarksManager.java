package com.chandru.claude_ArrayList_ex;

import java.util.ArrayList;
import java.util.Collections;

public class StudentMarksManager {
	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(40);
		list.add(600);
		list.add(50);
		list.add(70);
		list.add(80);

		System.out.println("original list : " + list);

		list.remove(2);
		System.out.println("after removing 2nd index element : " + list);

		System.out.println("maximum element in the array is : " + Collections.max(list));

		Collections.sort(list);
		System.out.println("sorted element : " + list);

		System.out.println(list.contains(95));
	}

}
