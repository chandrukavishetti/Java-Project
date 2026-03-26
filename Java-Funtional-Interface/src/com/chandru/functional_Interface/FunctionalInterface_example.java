package com.chandru.functional_Interface;

@FunctionalInterface
interface Square {
	int calulate(int x);
}

class FunctionalInterface_example {
	public static void main(String[] args) {
		int a = 5;

		Square s = (int x) -> x * x;

		int answer = s.calulate(a);
		System.out.println(answer);
	}
}
