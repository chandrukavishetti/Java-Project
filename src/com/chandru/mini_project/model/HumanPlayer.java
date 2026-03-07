package com.chandru.mini_project.model;

public class HumanPlayer extends Player {

    public HumanPlayer(MarkType mark) {
        super(mark);
    }

    @Override
    public int choosePosition(Board board, InputValidator validator) {

        int maxPosition = board.getSize() * board.getSize();

        return validator.getValidPosition(maxPosition, mark);
    }
}