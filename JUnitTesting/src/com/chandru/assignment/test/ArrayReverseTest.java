package com.chandru.assignment.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.chandru.assignment.code.ArrayReverse;

class ArrayReverseTest {

	ArrayReverse arrayReverse;

	@BeforeEach
	void setUp() {
		arrayReverse = new ArrayReverse();
	}

	// Normal array
	@Test
	void shouldReverseNormalArray() {
		int[] input = { 10, 20, 30 };
		int[] expected = { 30, 20, 10 };

		assertArrayEquals(expected, arrayReverse.reverseArray(input));
	}

	// Single element
	@Test
	void shouldReturnSameArrayForSingleElement() {
		int[] input = { 90 };
		int[] expected = { 90 };

		assertArrayEquals(expected, arrayReverse.reverseArray(input));
	}

	// Empty array
	@Test
	void shouldReturnEmptyArray() {
		int[] input = {};
		int[] expected = {};

		assertArrayEquals(expected, arrayReverse.reverseArray(input));
	}

	// Null case
	@Test
	void shouldReturnNullWhenInputIsNull() {
		assertNull(arrayReverse.reverseArray(null));
	}
}