 package org.example.model;

import Interface.Shippable;
import java.math.BigDecimal;
import org.example.model.Product;
import java.util.ArrayList;
import java.util.List;
import org.example.exception.ExpiredProductException;
import org.example.exception.OutOfStockException;

public class Cart {
   private List<CartItem> items = new ArrayList();

     
    public boolean isEmpty(){
        return items.isEmpty();
    }
    public void addProduct(Product p,int quantity) {
        if(quantity>p.getQuantity()){
            throw new OutOfStockException("Requested quantity exceeds available stock");
        }
        if(p.isExpired()){
              throw new ExpiredProductException("Cannot add expired product to cart");
        }
        CartItem item = new CartItem(p,quantity);
        items.add(item);
         System.out.println("product added successfully");
    }

    public List<CartItem> getItems() {
        return items;
    }
    public BigDecimal getSubtotal(){
        if(items.isEmpty()){
            return BigDecimal.ZERO;
        }
         BigDecimal total = BigDecimal.ZERO;
        for(CartItem item : items){
             total = total.add(item.getSubtotal());
        }
        return total;
    }
    public List<Shippable> getShippableItems(){
        List<Shippable>shippableProduct = new ArrayList();
        for(CartItem item : items){
            if(item.getProduct() instanceof Shippable) {
                Shippable shippableItem = (Shippable) item.getProduct(); 
                shippableProduct.add(shippableItem);
            }
            }  
        return shippableProduct;
    }
    public void clearCart(){
        items.clear();
    }
}
