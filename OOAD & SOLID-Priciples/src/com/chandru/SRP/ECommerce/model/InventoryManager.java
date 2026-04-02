package com.chandru.SRP.ECommerce.model;

public class InventoryManager {

    public void addStock(Product product, int quantity) {
        product.setQuantity(product.getQuantity() + quantity);
    }

    public boolean reduceStock(Product product, int quantity) {
        if (quantity > product.getQuantity()) {
            return false;
        }
        product.setQuantity(product.getQuantity() - quantity);
        return true;
    }
}