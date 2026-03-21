package com.chandru.exception_handiling;

public class InstanceVariableExample {
	// Instance variables
	public String name;
	private int age;

	// Constructor to initialize instance variables
	public InstanceVariableExample(String name, int age) {
		this.name = name; // 'this' keyword refers to the current instance
		this.age = age;
	}

	// Instance method to access instance variables
	public void displayDetails() {
		System.out.println("Name: " + name + ", Age: " + age);
	}

	public static void main(String[] args) {
		// Create two objects, each with its own copy of name and age
		InstanceVariableExample person1 = new InstanceVariableExample("Alice", 30);
		InstanceVariableExample person2 = new InstanceVariableExample("Bob", 25);

		person1.displayDetails(); // Output: Name: Alice, Age: 30
		person2.displayDetails(); // Output: Name: Bob, Age: 25
	}
}

/*
 * An instance variable in Java is a non-static variable declared within a class
 * but outside of any method, constructor, or block. Each object (instance)
 * created from that class gets its own unique copy of the instance variables,
 * allowing each object to maintain its own state.
 * 
 * Key Characteristics
 * 
 * Declaration: Declared inside the class body, but not with the static keyword
 * and not within any specific method or block.
 * 
 * Lifetime: They are created when an object is instantiated using the new
 * keyword and destroyed when the object is garbage collected (no longer
 * referenced).
 * 
 * Memory: Memory for instance variables is allocated in the heap memory as part
 * of the object.
 * 
 * Scope & Access: They are accessible to all non-static methods, constructors,
 * and blocks within the class. They can be accessed from outside the class
 * using an object reference and the dot notation (e.g.,
 * objectName.variableName).
 * 
 * Access Modifiers: Access modifiers like public, private, or protected can be
 * applied to control their visibility to other classes.
 * 
 * Default Values: If not explicitly initialized, instance variables are
 * assigned default values by the Java Virtual Machine (JVM): 0 for numeric
 * types, false for booleans, and null for object references.
 */