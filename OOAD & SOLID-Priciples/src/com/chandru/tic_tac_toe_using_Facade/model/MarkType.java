package com.chandru.tic_tac_toe_using_Facade.model;


public enum MarkType {
	X, O;

	public MarkType switchMark() {
		return this == X ? O : X;
	}
}
