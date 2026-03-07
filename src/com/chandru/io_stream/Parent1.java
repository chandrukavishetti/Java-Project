package com.chandru.io_stream;

 class Parent {
	Parent() {
		System.out.println("parent");
	}
}

class Child extends Parent {
	Child() {
		this(10);
		System.out.println("child default constructor");
	}

	Child(int x) {
		super();
		System.out.println("child parameterized");
	}
}
public class Parent1{
	public static void main(String[] args) {
		Child object=new Child();
	}
}