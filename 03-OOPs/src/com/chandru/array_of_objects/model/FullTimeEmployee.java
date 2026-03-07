package com.chandru.array_of_objects.model;

public class FullTimeEmployee extends Employee {

    private double monthlySalary;

    public FullTimeEmployee(int id, String name, double monthlySalary) {
        super(id, name);  
        this.monthlySalary = monthlySalary;
    }

    @Override
    public double calculateSalary() {
        return calculateSalary(monthlySalary);
    }
}