package com.chandru.abstract_interface_exception.model3;

import java.util.Scanner;

public class OrderServiceSystem {

	private Scanner scanner = new Scanner(System.in);
	private OrderValidator validator = new OrderValidator();
	private GeneralOrder[] orders = new GeneralOrder[100];
	private int count = 0;

	public void startOrderProcessing() {
		boolean running = true;
		while (running) {
			System.out.println("Order services fullfillment  --------");
			System.out.println("1.make order ");
			System.out.println("2.Display order");
			System.out.println("3. exit");
			System.out.print("select Option  : ");

			String choice = scanner.nextLine();

			switch (choice) {
			case "1":
				registerOrder();
				break;
			case "2":
				displayOrders();
				break;
			case "3":
				running = false;
				System.out.println("exiting Order");
				break;
			default:
				System.out.println("Invalid input");

			}

		}
	}

	private void registerOrder() {
		if (count >= orders.length) {
			System.out.println("error : storage is full");
			return;
		}
		try {
			GeneralOrder order = createOrderFromUser();
			orders[count++] = order;
		} catch (InvalidOrderScenariosException e) {
			System.out.println("error : " + e.getMessage());
		}

	}

	private GeneralOrder createOrderFromUser() throws InvalidOrderScenariosException {
		int type = getOrderType();
		int id = getOrderId();
		String name = getCustomerName();
		double fee = getOrderAmount();

		validator.validate(fee);

		GeneralOrder order = createOrder(type, id, name, fee);
		checkOrderVerification(order, fee);
		return order;
	}

	private int getOrderType() {
		while (true) {
			try {
				System.out.println("select the order type : ");
				System.out.println("1. Standard order");
				System.out.println("2. Express Order");
				System.out.println("3. International Order ");
				int type = Integer.parseInt(scanner.nextLine());
				return validator.serviceType(type);
			} catch (NumberFormatException e) {
				System.out.println("invlaid input pleas enter the number only");
			} catch (InvalidOrderScenariosException e) {
				System.out.println("error : " + e.getMessage());
			}
		}
	}

	private int getOrderId() {
		while (true) {
			try {
				System.out.println("enter the order id : ");
				int id = Integer.parseInt(scanner.nextLine());
				if (id <= 0) {
					System.out.println("enter the id positive integer only");
					continue;
				}
				return id;
			} catch (NumberFormatException e) {
				System.out.println("enter the number only");
			}

		}
	}

	private String getCustomerName() {
		while (true) {
			System.out.println("enter the customer name ");
			String name = scanner.nextLine();
			if (name.isEmpty() || !name.matches("[a-zA-Z\\s]+")) {
				System.out.println("error :  name mustcontains the alphabets only");
				continue;
			}
			return name;
		}

	}

	private double getOrderAmount() {
		while (true) {
			try {
				System.out.println("enter the order amount : ");
				double fee = Double.parseDouble(scanner.nextLine());
				if (fee < 0) {
					System.out.println("error : amount must be positive");
					continue;
				}
				return fee;
			} catch (NumberFormatException e) {
				System.out.println("enter the number only");
			}
		}
	}

	private GeneralOrder createOrder(int type, int id, String name, double fee) {
		if (type == 1)
			return new StandardOrder(id, name, fee);
		if (type == 2)
			return new ExpressOrder(id, name, fee);
		return new InterNationalOrder(id, name, fee);
	}

	private void checkOrderVerification(GeneralOrder order, double fee) {
		OrderVerification verification = (OrderVerification) order;
		if (verification.checkOrderVerification(fee)) {
			System.out.println("status Order is processessable");
		}
		System.out.println("status : order is not processable ");
	}

	private void displayOrders() {
		if (count == 0) {
			System.out.println("no order are processing");
			return;
		}
		for (int i = 0; i < count; i++) {
			System.out.println("------------------------");
			orders[i].displayOrder();
			System.out.println("total fee : " + orders[i].calculateTotalOrderFee());
		}
	}
}
