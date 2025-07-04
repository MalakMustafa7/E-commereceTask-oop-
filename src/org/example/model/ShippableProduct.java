 package org.example.model;

import org.example.interfaces.Shippable;
import java.math.BigDecimal;
import org.example.model.Product;

public class ShippableProduct extends Product  implements Shippable {
    double weight;

    public ShippableProduct(String name, BigDecimal price, int quantity,double weight) {
        super(name, price, quantity);
        if (weight <= 0) throw new IllegalArgumentException("Weight must be positive");
        this.weight=weight;
    }
    
    @Override
    public String getName() {
         return super.getName();
    }

    @Override
    public double getWeight() {
         return this.weight;
    }

    @Override
    public boolean isExpired() {
        return false;
    }
    
}
 