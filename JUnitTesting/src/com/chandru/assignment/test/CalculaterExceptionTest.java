package com.chandru.assignment.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.chandru.assignment.code.Calculater;

class CalculaterExceptionTest {

	Calculater calculater;

	@BeforeEach
	void setUp() {
		calculater = new Calculater();
	}

	// Main Assignment Test
	@Test
	void shouldThrowArithmeticExceptionWhenDividingByZero() {

		ArithmeticException exception = assertThrows(ArithmeticException.class, () -> calculater.divide(10, 0));

		assertEquals("Cannot divide by zero", exception.getMessage());
	}

	// Valid division
	@Test
	void shouldNotThrowExceptionWhenDivisionIsValid() {
		assertDoesNotThrow(() -> calculater.divide(10, 2));
	}

	@Test
	void shouldReturnCorrectResultWhenDivisionIsValid() {
		assertEquals(5, calculater.divide(10, 2));
	}
}