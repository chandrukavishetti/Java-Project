//Question 12 — Coding (Static + OOPs combined):
//
//Create a Singleton class DatabaseConnection that:
//
//Allows only one instance of the class to be created ever
//Has a static method getInstance() that returns the same instance every time
//Has a method connect() that prints "Connected to Database"
//Has a static counter that tracks how many times getInstance() was called
//In main(), try creating the object 3 times using getInstance() and verify all three references point to the same object using ==
//
//
//Quick theory question along with it:
//
//
//What is the Singleton design pattern and why is it useful in real world Java applications?
//Why do we make the constructor private in a Singleton class?

package com.chandru.practice.test;

import com.chandru.practice.model.DatabaseConnection;

public class DatabaseTester {
	public static void main(String[] args) {
		// Attempting to create the object 3 times
		DatabaseConnection db1 = DatabaseConnection.getInstance();
		DatabaseConnection db2 = DatabaseConnection.getInstance();
		DatabaseConnection db3 = DatabaseConnection.getInstance();

		// 5. Verify all references point to the same object
		System.out.println("Is db1 same as db2? " + (db1 == db2));
		System.out.println("Is db2 same as db3? " + (db2 == db3));

		// Testing functionality
		db1.connect();

		// Check how many times getInstance was called
		System.out.println("Total calls to getInstance(): " + DatabaseConnection.getAccessCount());
	}
}
