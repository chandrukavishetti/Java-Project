package com.chandru.Inventory_mng_sys.model;

import java.util.List;

public class ReorderService {

    private List<Notifier> notifiers;

    public ReorderService(List<Notifier> notifiers) {
        this.notifiers = notifiers;
    }

    public void checkAndReorder(Product product) {
        if (product.getQuantity() <= product.getReorderLevel()) {
            System.out.println("Reorder triggered for: " + product.getName());

            for (Notifier notifier : notifiers) {
                notifier.notifyUser("Low stock alert for " + product.getName());
            }
        }
    }
}