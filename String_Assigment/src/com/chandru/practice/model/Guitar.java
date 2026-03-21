package com.chandru.practice.model;

public class Guitar implements Playable {
	@Override
	public void play() {
		System.out.println("Strumming the guitar!");
	}
}
