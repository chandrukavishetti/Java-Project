package com.chandru.numberGuesserGame.model;

import java.util.concurrent.ThreadLocalRandom;

public class RandomNumberGenerator {

	public int generateNumber() {
		return ThreadLocalRandom.current().nextInt(1, 101);
	}
}