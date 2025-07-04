 package org.example.model;

import java.math.BigDecimal;

public abstract class Product {
    private String name;
    private  BigDecimal price;
    private int quantity;
    public Product(String name,BigDecimal price,int quantity){
        if (price.compareTo(BigDecimal.ZERO)<=0) throw new IllegalArgumentException("Price must be positive");
        if (quantity < 0) throw new IllegalArgumentException("Quantity cannot be negative"); 
        this.name=name;
        this.price=price;
        this.quantity=quantity;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }
    public int getQuantity() {
        return quantity;
    }
    
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    public void updateQuantity(int q){
        quantity-=q;
    }
     
    public abstract boolean isExpired();
}