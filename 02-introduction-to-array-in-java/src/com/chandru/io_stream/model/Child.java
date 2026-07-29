package com.chandru.io_stream.model;

public class Child extends Parent {
	Child(){
		super();
		this(10);
		System.out.println("child default constuctor");
	}
	Child(int x){
		System.out.println("child parametrized constuctor");
	}

}
