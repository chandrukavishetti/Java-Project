package com.chandru.Inventory_mng_sys.model;

import java.util.List;

public class Valuation implements ValuationStrategy {

    public double calculateValue(List<Product> products) {
        double total = 0;
        for (Product p : products) {
            total += p.getQuantity() * p.getPrice();
        }
        return total;
    }
}