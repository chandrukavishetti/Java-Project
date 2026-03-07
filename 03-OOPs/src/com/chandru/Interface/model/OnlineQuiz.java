package com.chandru.Interface.model;

public class OnlineQuiz implements ExamEvaluator {

    private double marks;
    private String grade;

    @Override
    public void evaluateMarks(double marks) {
        this.marks = marks;
        System.out.println("Online Quiz Marks: " + marks);
    }

    @Override
    public void calculateGrade() {

        if (marks >= 80)
            grade = "A";
        else if (marks >= 60)
            grade = "B";
        else if (marks >= 40)
            grade = "C";
        else
            grade = "Fail";

        System.out.println("Grade: " + grade);
    }
}