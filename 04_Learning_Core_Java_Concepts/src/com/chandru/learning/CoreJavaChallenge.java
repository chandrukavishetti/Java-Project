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

//Static method hiding in Java occurs when a subclass defines a static method with the exact same name and signature as a static method in its superclass.
//Instead of overriding it,
//the subclass method hides the parent class method

//1. StaticA (Static Method Hiding)

//The Code: ref.show();
//The Concept: Compile-time binding (Method Hiding).
//Even though the actual object is of type B, the reference variable ref is of type A (A ref = new B();). Static methods belong to the class, not the object. Because of this, the Java compiler looks strictly at the reference type (A) to decide which method to call during compile time. It completely ignores the runtime object type, executing A.show().
//

//2. Str (Method Overloading with Null)

//The Code: challenge.process(null);
//The Concept: Overload resolution and specificity.
//You have two process methods: one accepts an Object and one accepts a String. In Java, null is a valid literal for any reference type, meaning it could technically fit into either method. However, Java's compiler follows the "most specific type" rule. Because String is a subclass of Object, it is more specific. The compiler binds the call to process(String s).
//

//3. InstanceB -> Catch-IAE (Dynamic Dispatch & Exceptions)

//The Code: ref.display();
//The Concept: Runtime Polymorphism (Method Overriding).
//Unlike static methods, instance methods are resolved at runtime based on the actual object created in memory. Since ref points to a B object in memory, the JVM dynamically calls B.display().
//
//It prints InstanceB.
//
//It immediately throws an IllegalArgumentException.
//
//The try block stops executing instantly, skipping the rest of the code inside it.
//
//The JVM finds the first matching catch block for IllegalArgumentException and executes it, printing Catch-IAE.
//

//4. Finally -> Exception in thread "main" (Exception Re-throwing)

//The Code: throw new RuntimeException("Rethrown Exception");
//The Concept: Catch-block isolation and the Finally guarantee.
//Inside the first catch block, the code intentionally throws a brand new exception. Here is where many people get tricked: Sibling catch blocks do not catch exceptions thrown by each other. The catch (RuntimeException e) block is only looking for exceptions thrown inside the original try block.
//
//Because the new exception is unhandled, the program prepares to crash.
//
//However, before a method can forcefully exit due to a crash, the finally block is strictly guaranteed to run. It prints Finally.
//
//After the finally block finishes, the unhandled RuntimeException is passed up to the JVM. The JVM terminates the program and prints the red stack trace to your console.
//
//Because the program crashed at line 51, it never reached the final System.out.println("End"); statement!