package com.chandru.claude_ArrayList_ex;

import java.util.ArrayList;

public class ShopingCartSystem {
	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<>();
		list.add("watermelon");
		list.add("mango");
		list.add("dark chocolate");
		list.add("flour");
		System.out.println("list of elements : " + list);

		System.out.println("using get : " + list.get(1));

		System.out.println("setting the element : " + list.set(0, "papaya"));

		System.out.println("after removing element : " + list.remove(2));

		System.out.println("size of the list : " + list.size());

		list.clear();
		System.out.println("clearing the list using clear : " + list);
	}

}
