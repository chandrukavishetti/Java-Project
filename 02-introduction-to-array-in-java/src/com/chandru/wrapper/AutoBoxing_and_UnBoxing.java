package com.chandru.wrapper;

import java.util.ArrayList;

public class AutoBoxing_and_UnBoxing {
	public static void main(String[] args) {
		char ch = 'a';

		// Autoboxing: char -> Character
		Character c = ch;

		ArrayList<Integer> list = new ArrayList<>();
		// Autoboxing: int -> Integer
		list.add(25);
		System.out.println(list.get(0));
	}
}

/*
 * UnBoxing
 * 
import java.util.ArrayList;

class AutoBoxing_and_UnBoxing{
    public static void main(String[] args) {

        Character ch = 'a';
        // Unboxing: Character -> char
        char c = ch;

        ArrayList<Integer> list = new ArrayList<>();
        list.add(24);
        // Unboxing: Integer -> int
        int num = list.get(0);

        System.out.println(num);
    }
}
 */

/*
 * Autoboxing
 * 
 * The automatic conversion of primitive types to the object of their
 * corresponding wrapper classes is known as autoboxing. For example: conversion
 * of int to Integer, long to Long, double to Double, etc.
 * 
 * Java program to demonstrate the automatic conversion of primitive to wrapper
 * class (Autoboxing).
 */