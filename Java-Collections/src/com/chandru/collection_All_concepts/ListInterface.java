package com.chandru.collection_All_concepts;

import java.util.*;

public class ListInterface {
	public static void main(String[] args) {
		List<String> list=new ArrayList<>();
		
		list.add("rolls royce");
		list.add("range rover");
		list.add("creta");
		list.add("rolls royce");
		list.add("lamborgini");
		
		System.out.println("before the updating "+list);
		
		//setting the element or updating
		list.set(1, "virtus");
		System.out.println("after updating  : "+list);
		
		//getting the index position
		System.out.println("first index of the rolls royces car : "+list.indexOf("rolls royce"));
		System.out.println("last index of the rolls royces car : "+list.lastIndexOf("rolls royce"));
		
		//removing the list items
		list.remove(2);
		System.out.println("after removing the creta : "+list );
		
		//accessing the element by get()
		System.out.println("getting the element by position : "+list.get(1));
		
		//checking the element weather the element containig or not
		System.out.println("lamborgini is present in the list : "+list.contains("lamborgini"));
		
		//iterating the list elements
		for (int i=0;i<list.size();i++) {
			System.out.println("list elements : "+list.get(i)+" ");
		}
		
		//for each loop
		for(String str:list) {
			System.out.println(str+" ");
		}
	}

}
