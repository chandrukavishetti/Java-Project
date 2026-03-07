package com.chandru.string_assignment.model;

public class ProductCodeParserModel {

	private String input;

	public ProductCodeParserModel(String input) {
		this.input = input;
	}

	public void ProductCodeParser() {
		try {

			String trimmedInput = input.trim();
			String[] data = trimmedInput.split("-");

			if (data.length != 3) {
				throw new Exception("Input must be in the format: CAT-ITEMCODE-YEAR");
			}

			String category = data[0];
			String prodname = data[1];
			String manufacture_year = data[2];

			category = category.toUpperCase();

			boolean startsWithTV = prodname.startsWith("TV");

			boolean endsWith2023 = trimmedInput.endsWith("2023");

			String modifiedCode = trimmedInput.replace("-", " ");

			int firstHyphenPos = trimmedInput.indexOf("-");

			System.out.println("Category: " + category);
			System.out.println("Product: " + prodname);
			System.out.println("Year: " + manufacture_year);
			System.out.println("Starts with TV: " + (startsWithTV ? "Yes" : "No"));
			System.out.println("Ends with 2023: " + (endsWith2023 ? "Yes" : "No"));
			System.out.println("Modified Code: " + modifiedCode);
			System.out.println("Position of first hyphen: " + firstHyphenPos);

		} catch (Exception e) {
			System.out.println("error : " + e.getMessage());
		}
	}
}