package com.chandru.abstract_interface_exception.model1;

public class InvalidLoanException extends Exception {

	public InvalidLoanException(String message) {
		super(message);
	}
}