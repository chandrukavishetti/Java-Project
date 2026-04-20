package com.chandru.junittesting;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SumUnit {

	@Test
	void test() {
		UnitTesting obj1=new UnitTesting();
		int output_f=obj1.sum(10, 20);
		assertEquals(30,output_f);
	}

}
