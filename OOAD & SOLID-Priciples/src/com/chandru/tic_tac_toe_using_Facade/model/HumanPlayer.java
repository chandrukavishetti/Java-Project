package com.chandru.tic_tac_toe_using_Facade.model;

import com.chandru.tic_tac_toe_using_Facade.model.Player;

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