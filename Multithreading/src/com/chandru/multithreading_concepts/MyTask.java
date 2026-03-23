package com.chandru.multithreading_concepts;

public class MyTask implements Runnable {
	@Override
	public void run() {
		System.out.println("implementing the runnable ");
	}

	public static void main(String[] args) {
		MyTask task = new MyTask();
		Thread t = new Thread(task);
		t.start();
	}
}

/*
 * 
 * MyTask implements the Runnable interface The run() method contains the code
 * executed by the thread A Thread object is created by passing the Runnable
 * object Calling start() creates a new thread and internally calls run()
 */
