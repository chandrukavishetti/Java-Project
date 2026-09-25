package com.chandru.claude_ArrayList_ex;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ArrayListDeepDive {
	public static void main(String[] args) {
		List<String> frameworks = new ArrayList<>();

		frameworks.add("Chandrashekhar");
		frameworks.add("Rupa");

		System.out.println("index 1 is : " + frameworks.get(1));

		Iterator<String> iterator = frameworks.iterator();

		while (iterator.hasNext()) {
			String framework = iterator.next();
			if (framework.equals("Rupa")) {
				iterator.remove();
			}
		}
		System.out.println("modern stack " + frameworks);

	}

}
