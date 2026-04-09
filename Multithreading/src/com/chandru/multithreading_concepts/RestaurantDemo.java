package com.chandru.multithreading_concepts;

class chefThread extends Thread {
	private String chefName;

	public chefThread(String chefName) {
		this.chefName = chefName;
	}

	public void run() {
		for (int i = 0; i <= 3; i++) {
			System.out.println(chefName + " cooking dist  :" + i);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

public class RestaurantDemo {
	public static void main(String[] args) {
		chefThread chef1 = new chefThread("chandrashekhar");
		chefThread chef2 = new chefThread("Rupa");

		chef1.start();
		chef2.start();
	}

}
