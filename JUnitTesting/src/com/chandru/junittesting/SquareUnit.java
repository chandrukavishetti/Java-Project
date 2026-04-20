package com.chandru.junittesting;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class SquareUnit {

	@Test
	@DisplayName("squaring")
	@RepeatedTest(5)
	@Tag("important")
	
	void test() {
		UnitTesting obj1=new UnitTesting();
		int output_f=obj1.square(4);
		//test the output
		assertEquals(16,output_f);
	}

}
