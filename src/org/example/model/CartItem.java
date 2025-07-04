 package org.example.model;

import java.math.BigDecimal;
import org.example.model.Product;

public class CartItem {
    private Product product;
    private  int quantity;

    public CartItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
   public BigDecimal getSubtotal() {
    return (product.getPrice()).multiply(BigDecimal.valueOf(quantity));
}
     
    
}
