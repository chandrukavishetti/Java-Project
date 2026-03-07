package com.chandru.string_assignment.model;

public class FileNameValidatorModel {
	private String validator;

	public FileNameValidatorModel(String validator) {
		this.validator = validator;
	}

	public void fileChecker() {
		try {
			String trimmedValidator = validator.trim();

			boolean isPdf = trimmedValidator.toLowerCase().endsWith(".pdf");

			// 3. Find the last dot to separate name and extension
			int dotIndex = trimmedValidator.lastIndexOf(".");

			if (dotIndex == -1) {
				throw new Exception("The file name must contain a dot (.) extension");
			}
			if (dotIndex == 0) {
				throw new Exception("Invalid input: filename cannot start with a dot");
			}

			String fileName = trimmedValidator.substring(0, dotIndex);

			String extension = trimmedValidator.substring(dotIndex + 1);

			String replacedName = fileName.replace("_", " ");

			boolean containsFinal = replacedName.toLowerCase().contains("final");

			System.out.println("File Name: " + replacedName);
			System.out.println("Extension: " + extension);
			System.out.println("Is PDF file: " + (isPdf ? "Yes" : "No"));
			System.out.println("Contains 'final': " + (containsFinal ? "Yes" : "No"));

		} catch (Exception e) {
			System.out.println("error : " + e.getMessage());
		}
	}
}