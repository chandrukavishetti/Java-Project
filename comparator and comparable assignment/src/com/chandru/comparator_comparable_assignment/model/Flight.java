package com.chandru.comparator_comparable_assignment.model;

public class Flight {
	private String airline;
	private double fare;

	public Flight(String airline, double fare) {
		this.airline = airline;
		this.fare = fare;
	}

	public String getAirline() {
		return airline;
	}

	public double getFare() {
		return fare;
	}

	public void setAirline(String airline) {
		this.airline = airline;
	}

	public void setFare(double fare) {
		this.fare = fare;
	}

	@Override
	public String toString() {
		return airline + "- $" + fare;
	}

}
