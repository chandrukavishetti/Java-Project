package com.chandru.functional_Interface;

public class Funtional_Interface_Lambda {
	public static void main(String[] args) {
		new Thread(() -> System.out.println("new thread is created ")).start();
	}
}

/*
 * Above program demonstrates use of lambda expression with the Runnable
 * functional interface. Runnable has one abstract method run(), so it qualifies
 * as a functional interface. Lambda ()->
 * System.out.println("New thread created") defines the run() method. new
 * Thread().start() starts a new thread that executes the lambda body
 */