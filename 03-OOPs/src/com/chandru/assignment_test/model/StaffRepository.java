package com.chandru.assignment_test.model;

public class StaffRepository {
	private Staff[] staffList;
	private int index = 0;

	public StaffRepository(int size) {
		staffList = new Staff[size];
	}

	public void addStaff(Staff staff) {
		if (index < staffList.length) {
			staffList[index++] = staff;
		} else {
			System.out.println("staff storage full");
		}
	}

	public Staff[] getAllStaff() {
		return staffList;
	}

}
