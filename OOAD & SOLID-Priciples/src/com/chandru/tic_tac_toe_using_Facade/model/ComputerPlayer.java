package com.chandru.tic_tac_toe_using_Facade.model;

import java.util.Random;

public class ComputerPlayer extends Player {

    private final Random random = new Random();

    public ComputerPlayer(MarkType mark) {
        super(mark);
    }

    @Override
    public int choosePosition(Board board, InputValidator validator) {

        int size = board.getSize();
        int maxPosition = size * size;

        int position;

        while (true) {
            position = random.nextInt(maxPosition) + 1;

            int row = (position - 1) / size;
            int col = (position - 1) % size;

            if (board.getBoard()[row][col] == null) {
                System.out.println("Computer chooses position: " + position);
                return position;
            }
        }
    }
}