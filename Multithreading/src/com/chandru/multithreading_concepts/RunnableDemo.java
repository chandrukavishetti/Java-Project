package com.chandru.multithreading_concepts;

class cookingTask implements Runnable {
	private String dishName;

	public cookingTask(String dish) {
		this.dishName = dish;
	}

	@Override
	public void run() {
		for (int i = 0; i <= 3; i++) {
			System.out.println(Thread.currentThread().getName() + " making " + dishName + " step " + i);
		}
	}
}

public class RunnableDemo {
	public static void main(String[] args) {
		Runnable task1 = () -> {
			System.out.println("lambda thread : uploading the photo ");
		};
		Thread t1 = new Thread(new cookingTask("chapati"), "kartik");
		Thread t2 = new Thread(new cookingTask("sambar"), "chandru");
		Thread t3 = new Thread(new cookingTask("Rice"), "Rupa");

		t1.start();
		t2.start();
		t3.start();
	}
}
