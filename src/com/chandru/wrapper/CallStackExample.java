package com.chandru.wrapper;

public class CallStackExample {
	    public static void main(String[] args) {
	        System.out.println("Starting main...");
	        methodA();
	        System.out.println("Finished main.");
	    }

	    public static void methodA() {
	        System.out.println("Inside methodA...");
	        methodB();
	        System.out.println("Exiting methodA.");
	    }

	    public static void methodB() {
	        System.out.println("Inside methodB...");
	        methodC();
	        System.out.println("Exiting methodB.");
	    }

	    public static void methodC() {
	        System.out.println("Inside methodC. Inspecting the call stack:");
	        
	        // Retrieve the current call stack trace
	        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();

	        // Print the relevant parts of the stack trace
	        for (int i = 1; i < stackTrace.length; i++) {
	            StackTraceElement element = stackTrace[i];
	            System.out.println("Frame " + (i) + ": Class=" + element.getClassName() + 
	                               ", Method=" + element.getMethodName() + 
	                               ", Line=" + element.getLineNumber());
	        }
	        System.out.println("Exiting methodC.");
	    }
	}
