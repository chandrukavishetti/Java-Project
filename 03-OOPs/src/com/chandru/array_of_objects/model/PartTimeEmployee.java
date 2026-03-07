package com.chandru.array_of_objects.model;

public class PartTimeEmployee extends Employee {

    private double hoursWorked;
    private double hourlyRate;

    public PartTimeEmployee(int id, String name, double hoursWorked, double hourlyRate) {
        super(id, name);
        this.hoursWorked = hoursWorked;
        this.hourlyRate = hourlyRate;
    }

    @Override
    public double calculateSalary() {
        return calculateSalary(hoursWorked * hourlyRate);
    }
}