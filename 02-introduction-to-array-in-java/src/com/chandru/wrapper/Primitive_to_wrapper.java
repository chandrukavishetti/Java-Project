package com.chandru.wrapper;

public class Primitive_to_wrapper {
	public static void main(String[] args) {

		        Integer b = 357;
		        
		        // Autoboxing: primitive int -> Integer object
		        int a = b;

		        System.out.println("The primitive int b is: " + b);
		        System.out.println("The Integer object a is: " + a);
		    }
		}
	
/*
Why Wrapper Classes Are Needed
Wrapper classes are required in Java for the following reasons:

=>Java collections (ArrayList, HashMap, etc.) store only objects, not primitives.
=>Wrapper objects allow primitives to be used in object-oriented features like methods, synchronization, and serialization.
=>Objects support null values, while primitives do not.
=>Wrapper classes provide utility methods such as compareTo(), equals(), and toString().
*/