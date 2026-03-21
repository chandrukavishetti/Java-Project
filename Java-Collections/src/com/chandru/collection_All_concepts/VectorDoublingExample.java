package com.chandru.collection_All_concepts;

import java.util.Vector;

public class VectorDoublingExample {

	public static void main(String[] args) {
		Vector<Integer> vector = new Vector<>(2); // initial capacity = 2
		System.out.println("Initial capacity: " + vector.capacity());

		// Add elements to trigger capacity increase
		vector.add(10);
		vector.add(20);
		System.out.println("Capacity after adding 2 elements: " + vector.capacity());

		vector.add(30); // Triggers resize (2 → 4)
		System.out.println("Capacity after adding 3rd element: " + vector.capacity());

		vector.add(40);
		vector.add(50); // Triggers resize again (4 → 8)
		System.out.println("Capacity after adding 5 elements: " + vector.capacity());

		Vector<Integer> v = new Vector<Integer>();

		v.add(12);
		v.add(23);
		v.add(22);
		v.add(10);
		v.add(20);

		System.out.println("Initial vector : " + v);

		System.out.println("the object that is replaced is : " + v.set(0, 26));

		v.remove(v.size() - 1);
		System.out.println("afte removing the element 20 : " + v);
	}
}
