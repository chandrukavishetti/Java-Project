package com.chandru.OCP.Education_LMS.model;

public class QuizContent implements Content {

    private String title;
    private int questions;

    public QuizContent(String title, int questions) {
        this.title = title;
        this.questions = questions;
    }

    @Override
    public void render() {
        System.out.println(" Starting Quiz: " + title + " (" + questions + " questions)");
    }
}