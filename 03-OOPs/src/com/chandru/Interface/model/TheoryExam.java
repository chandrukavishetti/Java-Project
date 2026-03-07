package com.chandru.Interface.model;

public class TheoryExam implements ExamEvaluator {

    private double marks;
    private String grade;

    @Override
    public void evaluateMarks(double marks) {
        this.marks = marks;
        System.out.println("Theory Exam Marks: " + marks);
    }

    @Override
    public void calculateGrade() {

        if (marks >= 90)
            grade = "A+";
        else if (marks >= 75)
            grade = "A";
        else if (marks >= 60)
            grade = "B";
        else if (marks >= 50)
            grade = "C";
        else
            grade = "Fail";

        System.out.println("Grade: " + grade);
    }
}