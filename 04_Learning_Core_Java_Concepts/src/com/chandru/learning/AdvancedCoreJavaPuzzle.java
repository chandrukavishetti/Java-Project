package com.chandru.learning;

public class AdvancedCoreJavaPuzzle {

    static class Base {
        static String msg = "BaseStatic";
        String tag = "BaseTag";

        static {
            System.out.print("BaseInit ");
        }

        Base() {
            System.out.print(getTag() + " ");
        }

        String getTag() {
            return tag;
        }
    }

    static class Derived extends Base {
        static String msg = "DerivedStatic";
        String tag = "DerivedTag";

        static {
            System.out.print("DerivedInit ");
        }

        Derived() {
            // Implicit super() executes Base() first
        }

        @Override
        String getTag() {
            return tag;
        }
    }

    @SuppressWarnings("finally")
    public static int processExecutionFlow() {
        int val = 10;
        try {
            val = val / 0;
            return val;
        } catch (ArithmeticException e) {
            val = 20;
            throw new RuntimeException("Uncaught Exception");
        } finally {
            val = 30;
            return val;
        }
    }

    public static void testStringPoolMechanics() {
        final String s1 = "Java";
        String s2 = "Core";
        String s3 = s1 + s2; 
        
        String s4 = "JavaCore";
        
        final String s5 = "Core";
        String s6 = s1 + s5; 

        System.out.print((s3 == s4) + " " + (s6 == s4) + " ");
    }

    public static void main(String[] args) {
        // Phase 1: Inheritance, Class Loading & Initialization
        Base b = new Derived();
        System.out.print(b.tag + " ");

        // Phase 2: Exception Handling & Finally Return
        System.out.print(processExecutionFlow() + " ");

        // Phase 3: String Pool & Compile-Time Constants
        testStringPoolMechanics();
    }
}