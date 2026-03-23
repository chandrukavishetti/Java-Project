package com.chandru.multithreading_concepts;

public class Runnable_with_Lamda {
	public static void main(String[] args) {

		Runnable task = () -> {
			System.out.println("lamda function with runnable");
		};
		Thread t = new Thread(task);
		t.start();
	}
}
