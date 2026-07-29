package com.chandru.learning;

public class CoreJavaChallenge {

	static class A {
		static void show() {
			System.out.print("StaticA ");
		}

		void display() {
			System.out.print("InstanceA ");
		}
	}

	static class B extends A {
		static void show() {
			System.out.print("StaticB ");
		}

		@Override
		void display() throws IllegalArgumentException {
			System.out.print("InstanceB ");
			throw new IllegalArgumentException();
		}
	}

	public void process(Object o) {
		System.out.print("Obj ");
	}

	public void process(String s) {
		System.out.print("Str ");
	}

	public static void main(String[] args) {
		A ref = new B();
		CoreJavaChallenge challenge = new CoreJavaChallenge();

		try {
			// Concept 1: Static Method Hiding
			ref.show();

			// Concept 2: Method Overloading Resolution
			challenge.process(null);

			// Concept 3: Dynamic Method Dispatch & Exceptions
			ref.display();

		} catch (IllegalArgumentException e) {
			System.out.print("Catch-IAE ");
			throw new RuntimeException("Rethrown Exception");
		} catch (RuntimeException e) {
			System.out.print("Catch-RE ");
		} finally {
			System.out.print("Finally ");
		}

		System.out.println("End");
	}
}