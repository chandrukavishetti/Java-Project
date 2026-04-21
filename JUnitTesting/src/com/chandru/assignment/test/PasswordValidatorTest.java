package com.chandru.assignment.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.chandru.assignment.code.PasswordValidator;

class PasswordValidatorTest {

	PasswordValidator validator;

	@BeforeEach
	void setUp() {
		validator = new PasswordValidator();
	}

	// Valid password
	@Test
	void shouldReturnTrueForValidPassword() {
		assertTrue(validator.isValidPassword("Password1"));
	}

	// Less than 8 characters
	@Test
	void shouldReturnFalseWhenPasswordIsTooShort() {
		assertFalse(validator.isValidPassword("Pass1"));
	}

	// No uppercase
	@Test
	void shouldReturnFalseWhenNoUpperCasePresent() {
		assertFalse(validator.isValidPassword("password1"));
	}

	// No number
	@Test
	void shouldReturnFalseWhenNoNumberPresent() {
		assertFalse(validator.isValidPassword("Password"));
	}

	// Null input
	@Test
	void shouldReturnFalseWhenPasswordIsNull() {
		assertFalse(validator.isValidPassword(null));
	}

	// Empty string
	@Test
	void shouldReturnFalseWhenPasswordIsEmpty() {
		assertFalse(validator.isValidPassword(""));
	}
}