package com.chandru.multithreading_concepts;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallCenter_ExecutorService_Ex {
	public static void main(String[] args) {
		ExecutorService callCenter = Executors.newFixedThreadPool(3);

		for (int i = 1; i <= 8; i++) {
			final int callId = i;
			callCenter.submit(() -> {
				System.out.println(Thread.currentThread().getName() + " handling call # " + callId);
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
				}
				System.out.println("call : " + callId + " resolved");
			});
		}
		callCenter.shutdown();

		ExecutorService workers = Executors.newFixedThreadPool(2);

		Callable<Integer> priceCalculation = () -> {
			Thread.sleep(500);
			return 1499;
		};
		Future<Integer> futurePrice = workers.submit(priceCalculation);

		System.out.println("calculating price in background");

		Integer price = null;
		try {
			price = futurePrice.get();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("price calculated : " + price);
		workers.shutdown();
	}

}
