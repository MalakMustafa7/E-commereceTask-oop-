 package e.commerecesystem;

import java.time.LocalDate;

public class ECommereceSystem {
    public static void main(String[] args) {
        Product book = new ShippableProduct("Java Book", 100.0, 10, 1.5);
        Product phone = new ShippableProduct("Smartphone", 5000.0, 5, 0.5);
        Product expiredFood = new ExpirableProduct("Milk", 20.0, 3, LocalDate.of(2024, 7, 1));  
        Product card = new NonShippableProduct("Mobile scratch cards ", 300.0, 2);

         Cart cart = new Cart();
         try{
             cart.addProduct(book, 2);              
             cart.addProduct(phone, 1);              
             cart.addProduct(expiredFood, 1);        
             cart.addProduct(card, 1);
         }catch(Exception ex){
             System.out.println(ex.getMessage());
         }
        Customer customer = new Customer(10000.0); 
        ShippingService shippingService = new ShippingService();
        Checkout checkout = new Checkout(cart, shippingService, customer);
        
        try {
            checkout.performCheckout();
        } catch (IllegalStateException ex) {
            System.out.println("Checkout failed: " + ex.getMessage());
        }

    }
    
}
