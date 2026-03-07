package com.chandru.Interface.model;

public class PracticalExam implements ExamEvaluator {

    private double marks;
    private String grade;

    @Override
    public void evaluateMarks(double marks) {
        this.marks = marks;
        System.out.println("Practical Exam Marks: " + marks);
    }

    @Override
    public void calculateGrade() {

        if (marks >= 85)
            grade = "A";
        else if (marks >= 70)
            grade = "B";
        else if (marks >= 55)
            grade = "C";
        else
            grade = "Fail";

        System.out.println("Grade: " + grade);
    }
}