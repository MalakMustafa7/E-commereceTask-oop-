 package org.example.model;

import java.math.BigDecimal;
import org.example.model.Product;

public class NonShippableProduct extends Product{

    public NonShippableProduct(String name,  BigDecimal price, int quantity) {
        super(name, price, quantity);
    }

    @Override
    public boolean isExpired() {
        return false;
    }
    
}
