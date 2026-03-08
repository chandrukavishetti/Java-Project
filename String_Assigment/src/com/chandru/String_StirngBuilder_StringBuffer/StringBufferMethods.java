package com.chandru.String_StirngBuilder_StringBuffer;

import java.io.*;

public class StringBufferMethods {
	public static void main(String args[]) {
		StringBuffer sb = new StringBuffer("Hello ");
		sb.append("Java"); // now original string is changed
		System.out.println(sb);

		StringBuffer sb1 = new StringBuffer("Hello ");
		sb.insert(1, "Java");
		// Now original string is changed
		System.out.println(sb1);

		StringBuffer sb2 = new StringBuffer("Hello");
		sb.replace(1, 3, "Java");
		System.out.println(sb2);

		StringBuffer sb3 = new StringBuffer("Hello");
		sb.delete(1, 3);
		System.out.println(sb3);

		StringBuffer sb4 = new StringBuffer("Hello");
		sb.reverse();
		System.out.println(sb4);

		StringBuffer sb5 = new StringBuffer();
		// default 16
		System.out.println(sb5.capacity());
		sb.append("Hello");
		// now 16
		System.out.println(sb5.capacity());
		sb.append("java is my favourite language");
		// (oldcapacity*2)+2
		System.out.println(sb5.capacity());

		// Creating and storing string by creating object of StringBuffer
		StringBuffer s = new StringBuffer("GeeksforGeeks");
		// Getting the length of the string
		int p = s.length();
		// Getting the capacity of the string
		System.out.println("Length of string GeeksforGeeks=" + p);

	}
}
