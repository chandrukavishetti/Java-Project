package com.chandru.string_assignment.model;

public class IPv4ValidatorModel {
	private String ipAddress;

	public IPv4ValidatorModel(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	public void validateIP() {
		try {
			if (ipAddress == null || ipAddress.trim().isEmpty()) {
				throw new Exception("IP Address cannot be empty.");
			}

			String trimmedIP = ipAddress.trim();
			// Split using "\\." because dot is a special character in regex
			String[] parts = trimmedIP.split("\\.");

			// Check if there are exactly 4 parts
			if (parts.length != 4) {
				throw new Exception("IPv4 must have exactly 4 octets separated by dots.");
			}

			for (String part : parts) {

				if (part.isEmpty()) {
					throw new Exception("Octet cannot be empty.");
				}

				for (char c : part.toCharArray()) {
					if (!Character.isDigit(c)) {
						throw new Exception("Octet contains invalid characters: " + part);
					}
				}

				// Convert to integer and check range (0-255)
				int value = Integer.parseInt(part);
				if (value < 0 || value > 255) {
					throw new Exception("Octet value " + value + " is out of range (0-255).");
				}

				if (part.length() > 1 && part.startsWith("0")) {
					throw new Exception("Octet cannot have leading zeros: " + part);
				}
			}

			System.out.println("The IP Address " + trimmedIP + " is VALID.");

		} catch (NumberFormatException e) {
			System.out.println("Error: Octet is not a valid number.");
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}
	}
}