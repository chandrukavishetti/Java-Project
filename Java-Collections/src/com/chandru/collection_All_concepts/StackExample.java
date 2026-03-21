package com.chandru.collection_All_concepts;

import java.util.*;

public class StackExample {
	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<>();

		stack.push(10);
		stack.push(20);
		stack.push(30);
		stack.push(40);

		System.out.println("original stack : " + stack);
		
		System.out.println("top of the stack element : "+stack.peek());
		
		System.out.println("poping the element one by one ");
		while (!stack.isEmpty()) {
			System.out.println(stack.pop());
		}

	}

}
