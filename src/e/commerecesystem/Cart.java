 package e.commerecesystem;

import java.util.ArrayList;
import java.util.List;

public class Cart {
   private List<CartItem> items = new ArrayList();

     
    public boolean isEmpty(){
        return items.isEmpty();
    }
    public void addProduct(Product p,int quantity){
        if(quantity>p.getQuantity()){
            throw new IllegalArgumentException("Requested quantity is not available");
        }
        if(p.isExpired()){
              throw new IllegalStateException("Cannot add expired product to cart");
        }
        CartItem item = new CartItem(p,quantity);
        items.add(item);
         System.out.println("product added successfully");
    }

    public List<CartItem> getItems() {
        return items;
    }
    public double getSubtotal(){
        if(items.isEmpty()){
            return -1;
        }
        double total=0;
        for(CartItem item : items){
            total+=item.getSubtotal();
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
