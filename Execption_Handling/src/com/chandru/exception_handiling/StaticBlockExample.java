package com.chandru.exception_handiling;

public class StaticBlockExample {
    // Static variable
    static int count;
    
    // First static block
    static {
        System.out.println("First static block executed.");
        count = 10;
    }
    
    // Second static block
    static {
        System.out.println("Second static block executed. Count is now: " + count);
        // Can call a static method
        initializeSettings(); 
    }

    static void initializeSettings() {
        System.out.println("Initializing settings...");
    }

    public static void main(String[] args) {
        System.out.println("Main method executed.");
        // We can access the static variable initialized in the block
        System.out.println("Final count value in main: " + count); 
    }
}
