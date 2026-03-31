package com.chandru.Inventory_mng_sys.test;

import java.util.*;
import com.chandru.Inventory_mng_sys.model.*;

public class InventoryTest {

    public static void main(String[] args) {

        InputHandler input = new InputHandler();

        List<Notifier> notifiers = List.of(
                new EmailNotifier(),
                new SMSNotifier()
        );

        ReorderService reorderService = new ReorderService(notifiers);
        InventoryService service = new InventoryService(reorderService);

        while (true) {
            System.out.println("\n1. Add Product\n2. Add Stock\n3. Remove Stock\n4. Show\n5. Value\n6. Exit");

            int choice = input.getInt("Enter choice: ");

            switch (choice) {
                case 1 -> {
                    String name = input.getString("Name: ");
                    int qty = input.getInt("Qty: ");
                    double price = input.getDouble("Price: ");
                    int reorder = input.getInt("Reorder level: ");

                    service.addProduct(new Product(name, qty, price, reorder));
                }

                case 2 -> {
                    String name = input.getString("Name: ");
                    int qty = input.getInt("Qty: ");
                    service.addStock(name, qty);
                }

                case 3 -> {
                    String name = input.getString("Name: ");
                    int qty = input.getInt("Qty: ");
                    service.removeStock(name, qty);
                }

                case 4 -> service.showProducts();

                case 5 -> {
                    double value = service.calculateValue(new FIFOValuation());
                    System.out.println("Total value: " + value);
                }

                case 6 -> {
                    System.out.println("Exiting...");
                    return;
                }

                default -> System.out.println("Invalid choice!");
            }
        }
    }
}