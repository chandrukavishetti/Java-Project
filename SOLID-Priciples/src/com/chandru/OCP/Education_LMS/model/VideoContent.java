package com.chandru.OCP.Education_LMS.model;

public class VideoContent implements Content {

	private String title;
	private int duration;

	public VideoContent(String title, int duration) {
		this.title = title;
		this.duration = duration;
	}

	@Override
	public void render() {
		System.out.println("Playing Video: " + title + " (" + duration + " mins)");
	}
}