package com.chandru.assignment.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import com.chandru.assignment.code.Calculater;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
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

	@ParameterizedTest
	@Order(1)
	@CsvSource({ "1,2,3", "-2,-3,-5", "0,1,1", "11,1,12" })
	void shouldReturnSumWhenInputIsValid(int a, int b, int expected) {
		assertEquals(expected, calculater.add(a, b));
	}

	// subtract

	@ParameterizedTest
	@Order(2)
	@CsvSource({ "3,1,2", "-5,-5,0", "5,7,-2", "5,0,5" })
	void shouldReturnDifferenceWhenInputIsValid(int a, int b, int expected) {
		assertEquals(expected, calculater.subtract(a, b));
	}

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

	@ParameterizedTest
	@Order(3)
	@CsvSource({ "5,5,25", "-5,-5,25", "5,-5,-25", "5,0,0" })
	void shouldReturnMultiplicationWhenInputIsValid(int a, int b, int expected) {
		assertEquals(expected, calculater.multiply(a, b));
	}

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

	@ParameterizedTest
	@Order(4)
	@CsvSource({ "10,5,2", "-10,-5,2", "10,-5,-2", "0,5,0" })
	void shouldReturnDivisionWhenInputIsValid(int a, int b, int expected) {
		assertEquals(expected, calculater.divide(a, b));
	}

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