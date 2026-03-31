package com.chandru.Inventory_mng_sys.model;

import java.util.List;

public interface ValuationStrategy {
    double calculateValue(List<Product> products);
}

//OCP