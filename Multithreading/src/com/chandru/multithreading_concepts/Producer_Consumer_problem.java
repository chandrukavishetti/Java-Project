package com.chandru.multithreading_concepts;

import java.util.LinkedList;

public class Producer_Consumer_problem {
	public static void main(String[] args) {
		Desk desk = new Desk();

		Thread producer = new Thread(() -> {
			int bookId = 1;
			while (true) {
				desk.produce(bookId++);
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
				}
			}
		});
		Thread consumer = new Thread(() -> {
			while (true) {
				desk.consume();
				try {
					Thread.sleep(1500);
				} catch (InterruptedException e) {
				}
			}
		});
		producer.start();
		consumer.start();
	}

}

class Desk {
	private LinkedList<Integer> buffer = new LinkedList<>();
	private final int CAPACITY = 2;

	// producer method
	public synchronized void produce(int id) {
		while (buffer.size() == CAPACITY) {
			try {
				System.out.println("desk full producer waiting");
				wait();

			} catch (InterruptedException e) {
			}
		}
		buffer.add(id);
		System.out.println("book added : " + id);
		notify();
	}

	// consumer method
	public synchronized void consume() {
		while (buffer.isEmpty()) {
			try {
				System.out.println("desk empty consumer waiting");
				wait();
			} catch (InterruptedException e) {
			}
		}

		int id = buffer.removeFirst();
		System.out.println("book issued : " + id);
		notify();

	}
}