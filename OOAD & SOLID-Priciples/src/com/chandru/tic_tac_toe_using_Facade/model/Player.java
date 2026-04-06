package com.chandru.tic_tac_toe_using_Facade.model;

public abstract class Player {

	protected final MarkType mark;

	public Player(MarkType mark) {
		this.mark = mark;
	}

	public MarkType getMark() {
		return mark;
	}

	public abstract int choosePosition(Board board, InputValidator validator);
}