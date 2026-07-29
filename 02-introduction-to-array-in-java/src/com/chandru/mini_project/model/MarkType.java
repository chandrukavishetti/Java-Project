package com.chandru.mini_project.model;

public enum MarkType {
	X, O;

	public MarkType switchMark() {
		return this == X ? O : X;
	}
}
