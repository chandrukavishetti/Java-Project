package com.chandru.mini_project.test;

import java.util.Scanner;
import com.chandru.mini_project.model.Game;

public class GameStarter {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		Game game = new Game(scanner);
		game.start();
		scanner.close();
	}
}