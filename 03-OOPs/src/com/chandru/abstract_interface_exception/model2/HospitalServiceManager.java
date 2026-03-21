package com.chandru.abstract_interface_exception.model2;

import java.util.Scanner;

public class HospitalServiceManager {

	private Scanner scanner = new Scanner(System.in);
	private ServiceValidator validator = new ServiceValidator();
	private HospitalService[] services = new HospitalService[100];
	private int count = 0;

	public void startServiceProcessing() {
		boolean running = true;
		while (running) {
			System.out.println("\n--- Hospital Service System ---");
			System.out.println("1. Register Service");
			System.out.println("2. Display Services");
			System.out.println("3. Exit");
			System.out.print("Select an option: ");

			String choice = scanner.nextLine();

			switch (choice) {
			case "1":
				registerService();
				break;
			case "2":
				displayServices();
				break;
			case "3":
				running = false;
				System.out.println("Exiting system...");
				break;
			default:
				System.out.println("Invalid option. Please choose 1, 2, or 3.");
			}
		}
	}

	private void registerService() {
		if (count >= services.length) {
			System.out.println("Error: System storage full.");
			return;
		}
		try {
			HospitalService service = createServiceFromUser();
			services[count++] = service;
		} catch (InvalidServiceException e) {
			System.out.println("Error: " + e.getMessage());
		}
	}

	private HospitalService createServiceFromUser() throws InvalidServiceException {
		int type = getServiceType();
		int id = getServiceId();
		String name = getPatientName();
		double fee = getConsultationFee();

		// Final check via validator
		validator.validate(fee);

		HospitalService service = createService(type, id, name, fee);
		checkEligibility(service, fee);
		return service;
	}

	private int getServiceType() {
		while (true) {
			try {
				System.out.println("Select Service Type:\n1 General Consultation\n2 Surgery\n3 Diagnostic Test");
				int type = Integer.parseInt(scanner.nextLine());
				return validator.serviceType(type);
			} catch (NumberFormatException e) {
				System.out.println("Invalid input. Please enter a number (1, 2, or 3).");
			} catch (InvalidServiceException e) {
				System.out.println("Error: " + e.getMessage());
			}
		}
	}

	private int getServiceId() {
		while (true) {
			try {
				System.out.println("Enter Service ID:");
				int id = Integer.parseInt(scanner.nextLine());
				if (id <= 0) {
					System.out.println("Error: ID must be a positive number.");
					continue;
				}
				return id;
			} catch (NumberFormatException e) {
				System.out.println("Invalid input. Please enter a numeric ID.");
			}
		}
	}

	private String getPatientName() {
		while (true) {
			System.out.println("Enter Patient Name:");
			String name = scanner.nextLine().trim();
			if (name.isEmpty() || !name.matches("[a-zA-Z\\s]+")) {
				System.out.println("Error: Name must contain only letters and cannot be empty.");
				continue;
			}
			return name;
		}
	}

	private double getConsultationFee() {
		while (true) {
			try {
				System.out.println("Enter Consultation Fee:");
				double fee = Double.parseDouble(scanner.nextLine());
				if (fee < 0) {
					System.out.println("Error: Fee cannot be negative.");
					continue;
				}
				return fee;
			} catch (NumberFormatException e) {
				System.out.println("Invalid input. Please enter a valid decimal amount.");
			}
		}
	}

	private HospitalService createService(int type, int id, String name, double fee) {
		if (type == 1) return new GeneralConsultation(id, name, fee);
		if (type == 2) return new Surgery(id, name, fee);
		return new DiagnosticTest(id, name, fee);
	}

	private void checkEligibility(HospitalService service, double fee) {
		ServiceEligibility eligibility = (ServiceEligibility) service;
		if (eligibility.checkEligibility(fee)) {
			System.out.println("Status: Service Eligible");
		} else {
			System.out.println("Status: Service Not Eligible");
		}
	}

	private void displayServices() {
		if (count == 0) {
			System.out.println("No services registered yet.");
			return;
		}
		for (int i = 0; i < count; i++) {
			System.out.println("----------------");
			services[i].displayService();
			System.out.println("Total Fee: " + services[i].calculateTotalFee());
		}
	}
}