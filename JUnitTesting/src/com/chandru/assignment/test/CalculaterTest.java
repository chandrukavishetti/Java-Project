package com.chandru.assignment.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.chandru.assignment.code.Calculater;

class CalculaterTest {

	Calculater calculater;

	@BeforeEach
	void setUp() {
		calculater = new Calculater();
	}

	@Test
	void shouldReturnCorrectSumForPositiveNumbers() {
		assertEquals(10, calculater.add(5, 5));
	}

	@Test
	void shouldReturnCorrectSumForNegativeNumbers() {
		assertEquals(-10, calculater.add(-5, -5));
	}

	@Test
	void shouldReturnZeroWhenAddingOppositeNumbers() {
		assertEquals(0, calculater.add(5, -5));
	}

	@Test
	void shouldReturnSameNumberWhenAddingZero() {
		assertEquals(5, calculater.add(5, 0));
	}

	@Test
	void shouldNotReturnWrongSum() {
		assertNotEquals(11, calculater.add(5, 5));
	}

	// subtract

	@Test
	void shouldReturnCorrectDifferenceForPositiveNumbers() {
		assertEquals(2, calculater.subtract(7, 5));
	}

	@Test
	void shouldReturnCorrectDifferenceForNegativeNumbers() {
		assertEquals(0, calculater.subtract(-5, -5));
	}

	@Test
	void shouldHandleNegativeResult() {
		assertEquals(-2, calculater.subtract(5, 7));
	}

	@Test
	void shouldReturnSameNumberWhenSubtractingZero() {
		assertEquals(5, calculater.subtract(5, 0));
	}

	@Test
	void shouldNotReturnWrongDifference() {
		assertNotEquals(3, calculater.subtract(7, 5));
	}

	// multiply

	@Test
	void shouldReturnCorrectProductForPositiveNumbers() {
		assertEquals(25, calculater.multiply(5, 5));
	}

	@Test
	void shouldReturnPositiveWhenBothNumbersNegative() {
		assertEquals(25, calculater.multiply(-5, -5));
	}

	@Test
	void shouldReturnNegativeWhenAnyOneNumberNegative() {
		assertEquals(-25, calculater.multiply(5, -5));
	}

	@Test
	void shouldReturnZeroWhenMultiplyingWithZero() {
		assertEquals(0, calculater.multiply(5, 0));
	}

	@Test
	void shouldNotReturnWrongProduct() {
		assertNotEquals(30, calculater.multiply(5, 5));
	}

	// divide

	@Test
	void shouldReturnCorrectQuotientForPositiveNumbers() {
		assertEquals(2, calculater.divide(10, 5));
	}

	@Test
	void shouldReturnCorrectQuotientForNegativeNumbers() {
		assertEquals(2, calculater.divide(-10, -5));
	}

	@Test
	void shouldReturnNegativeWhenOneNumberNegative() {
		assertEquals(-2, calculater.divide(10, -5));
	}

	@Test
	void shouldReturnZeroWhenNumeratorIsZero() {
		assertEquals(0, calculater.divide(0, 5));
	}

	@Test
	void shouldNotReturnWrongQuotient() {
		assertNotEquals(3, calculater.divide(10, 5));
	}

	@Test
	void shouldThrowExceptionWhenDividingByZero() {
		assertThrows(ArithmeticException.class, () -> {
			calculater.divide(10, 0);
		});
	}

}