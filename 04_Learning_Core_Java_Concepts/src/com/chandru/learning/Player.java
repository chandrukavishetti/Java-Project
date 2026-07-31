package com.chandru.learning;

import java.util.ArrayList;
import java.util.Collections;

public class Player implements Comparable<Player> {
	String name;
	int score;

	public Player(String name, int score) {
		this.name = name;
		this.score = score;
	}

	public int compareTo(Player other) {
//		return Integer.compare(this.score, other.score); //ascending
		return Integer.compare(other.score, this.score); // descending
	}

	public String toString() {
		return name + "(" + score + ")";
	}

	// Main method moved inside Player
	public static void main(String[] args) {
		ArrayList<Player> players = new ArrayList<>();
		players.add(new Player("Rupa", 85));
		players.add(new Player("Chandrashekhar", 86));
		players.add(new Player("Sumit", 70));

		Collections.sort(players);
		System.out.println(players);
	}
}