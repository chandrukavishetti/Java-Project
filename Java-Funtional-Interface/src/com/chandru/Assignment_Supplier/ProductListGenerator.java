package com.chandru.Assignment_Supplier;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

public class ProductListGenerator {
	public static void main(String[] args) {
		Supplier<List<String>> productsupplier = () -> Arrays.asList("mobile", "laptop", "keyboard", "monitor",
				"charger");

		List<String> products = productsupplier.get();

		for (String product : products) {
			System.out.println(product);
		}

	}

}
