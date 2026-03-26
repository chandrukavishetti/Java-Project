package com.chandru.multithreading_concepts;

public class Multithreading_concepts {
	private Object lock = new Object();

	public void example() {
		Thread t1 = new Thread(() -> {
			synchronized (lock) {
				try {
					System.out.println("t1.is wainting ");
					lock.wait();
					System.out.println("t1 is resumed");
				} catch (InterruptedException e) {
					Thread.currentThread().interrupt();
				}
			}
		});
		t1.start();

		try {
			Thread.sleep(10000);
			synchronized (lock) {
				System.out.println("main signaling to t1");
				lock.notify();
			}
			t1.join();

		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
