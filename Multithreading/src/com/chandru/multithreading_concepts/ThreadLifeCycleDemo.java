package com.chandru.multithreading_concepts;

public class ThreadLifeCycleDemo {
	public static void main(String[] args) throws InterruptedException {
		Thread player = new Thread(() -> {
			System.out.println("player is batting now ");
			try {
				Thread.sleep(2000);
				System.out.println("player back from the drinks");
			} catch (InterruptedException e) {
				System.out.println("player interrupted");
			}
		}, "cricketPlayer");
		System.out.println("state 1 : " + player.getState());
		player.start();
		System.out.println("state 2 : " + player.getState());
		player.sleep(1000);
		System.out.println("state 3 : " + player.getState());
		player.join();
		System.out.println("state 4 : " + player.getState());
	}
}
