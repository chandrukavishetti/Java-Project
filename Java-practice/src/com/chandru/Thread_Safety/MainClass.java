package com.chandru.Thread_Safety;

public class MainClass {
	public static void main(String[] args) {
		B b = new B();

		Thread t1 = new Thread(b);

		Thread t2 = new Thread(b);

		t1.setName("thread 1");

		t2.setName("thread 2");

		t1.start();
		t2.start();
	}
}
