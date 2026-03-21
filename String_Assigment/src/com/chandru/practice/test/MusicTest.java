package com.chandru.practice.test;

import com.chandru.practice.model.Playable;
import com.chandru.practice.model.Guitar;
import com.chandru.practice.model.Piano;

public class MusicTest {
	public static void main(String[] args) {
		// Create objects
		Playable myGuitar = new Guitar();
		Playable myPiano = new Piano();

		// Call the play() method for each
		myGuitar.play();
		myPiano.play();
	}
}
