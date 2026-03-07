package com.chandru.array_of_objects.model;

public class Employee {

    protected int employeeId;
    protected String employeeName;
    protected static int totalEmployees = 0;

    public Employee(int employeeId, String employeeName) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        totalEmployees++;
    }

    
    public double calculateSalary() {
        return 0;
    }

    public double calculateSalary(double amount) {
        return amount;
    }

    public static int getTotalEmployees() {
        return totalEmployees;
    }

    public void displayEmployee() {
        System.out.println("-----------------------------------");
        System.out.println("Employee ID   : " + employeeId);
        System.out.println("Employee Name : " + employeeName);
    }
}