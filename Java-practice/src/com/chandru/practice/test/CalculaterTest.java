package com.chandru.practice.test;

import com.chandru.practice.model.Calculater;

public class CalculaterTest {
	public static void main(String[] args) {
		Calculater operation = new Calculater();

		operation.add(20.1, 2.7);
		operation.add(10, 20);
		operation.add("hi", 100);
		operation.add(10, 20, 30);

	}

}
