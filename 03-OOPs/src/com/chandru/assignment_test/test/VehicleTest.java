package com.chandru.assignment_test.test;

import com.chandru.assignment_test.model.Vehicle;
import com.chandru.assignment_test.model.Car;
import com.chandru.assignment_test.model.Bike;
import com.chandru.assignment_test.model.VehicleInputHandler;
import com.chandru.assignment_test.model.VehicleRepository;
import com.chandru.assignment_test.model.VehicleService;
import com.chandru.assignment_test.model.VehicleValidator;

//import com.chandru.assignment_test.model.Vehicle;
//import com.chandru.assignment_test.model.Car;
//import com.chandru.assignment_test.model.Bike;
//import com.chandru.assignment_test.model.VehicleInputHandler;
//import com.chandru.assignment_test.model.VehicleRepository;
//import com.chandru.assignment_test.model.VehicleService;
//import com.chandru.assignment_test.model.VehicleValidator;

public class VehicleTest {

	public static void main(String[] args) {

		VehicleInputHandler input = new VehicleInputHandler();

		VehicleRepository repository = new VehicleRepository(10);

		VehicleService service = new VehicleService(repository);

		boolean running = true;

		while (running) {

			System.out.println("\nVehicle Registration System");
			System.out.println("1 Register Car");
			System.out.println("2 Register Bike");
			System.out.println("3 Display Vehicles");
			System.out.println("4 Exit");

			int choice = (int) input.getDouble("Enter choice: ");

			try {

				switch (choice) {

				case 1:

					int reg = input.getInt("Enter registration number: ");
					String owner = input.getString("Enter owner name: ");
					double charge = input.getDouble("Enter base charge: ");
					String model = input.getString("Enter car model: ");

					Vehicle car = new Car(reg, owner, charge, model);

					service.addVehicle(car);

					break;

				case 2:

					int reg2 = input.getInt("Enter registration number: ");
					String owner2 = input.getString("Enter owner name: ");
					double charge2 = input.getDouble("Enter base charge: ");
					String type = input.getString("Enter bike type: ");

					Vehicle bike = new Bike(reg2, owner2, charge2, type);

					service.addVehicle(bike);

					break;

				case 3:

					service.displayVehicles();
					break;

				case 4:

					running = false;
					System.out.println("Program Ended");
					break;

				default:

					System.out.println("Invalid choice");
				}

			} catch (IllegalArgumentException e) {

				System.out.println("Error: " + e.getMessage());
			}
		}
	}
}