package com.chandru.Inventory_mng_sys.model;

import java.util.*;

public class InventoryService {

    private Map<String, Product> inventory = new HashMap<>();
    private ReorderService reorderService;

    public InventoryService(ReorderService reorderService) {
        this.reorderService = reorderService;
    }

    public void addProduct(Product product) {
        inventory.put(product.getName(), product);
        System.out.println("Product added.");
    }

    public void addStock(String name, int qty) {
        Product p = inventory.get(name);
        if (p != null) {
            p.addStock(qty);
            System.out.println("Stock added.");
        } else {
            System.out.println("Product not found.");
        }
    }

    public void removeStock(String name, int qty) {
        Product p = inventory.get(name);
        if (p != null) {
            if (qty > p.getQuantity()) {
                System.out.println("Not enough stock!");
                return;
            }

            p.removeStock(qty);
            System.out.println("Stock removed.");

            reorderService.checkAndReorder(p);
        } else {
            System.out.println("Product not found.");
        }
    }

    public void showProducts() {
        inventory.values().forEach(p ->
            System.out.println(p.getName() + " | Qty: " + p.getQuantity())
        );
    }

    public double calculateValue(ValuationStrategy strategy) {
        return strategy.calculateValue(new ArrayList<>(inventory.values()));
    }
}