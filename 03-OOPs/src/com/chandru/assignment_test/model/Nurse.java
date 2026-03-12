package com.chandru.assignment_test.model;

public class Nurse extends Staff {
	private String shift;
	
	public Nurse (int id,String name,String department,String shift) {
		super(id,name,department );
		StaffValidator.validateShift(shift);
		this.shift=shift;
	}
	@Override
	public void displayDetails() {
		System.out.println("\nnurse details ");
		System.out.println("ID : "+getId());
		System.out.println("Name  : "+getName());
		System.out.println("department  : "+getDepartment());
		System.out.println("shift : "+shift);
	}

}
