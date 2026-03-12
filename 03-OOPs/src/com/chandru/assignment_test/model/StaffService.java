package com.chandru.assignment_test.model;

public class StaffService {
	
	private StaffRepository repository;
	
	public StaffService(StaffRepository repository) {
		this.repository=repository;
	}
	
	public void addStaff(Staff staff) {
		repository.addStaff(staff);
	}
	
	public void displayAllStaff() {
		Staff[] list=repository.getAllStaff();
		for(Staff s:list) {
			if(s != null) {
				s.displayDetails();
			}
		}
	}

}
