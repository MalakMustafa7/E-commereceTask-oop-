 package e.commerecesystem;

import java.math.BigDecimal;
import org.example.service.Checkout;
import org.example.service.ShippingService;
import org.example.model.Customer;
import org.example.model.Cart;
import org.example.model.ShippableProduct;
import org.example.model.NonShippableProduct;
import org.example.model.ExpirableProduct;
import org.example.model.Product;
import java.time.LocalDate;

public class ECommereceSystem {
    public static void main(String[] args) {
        Product book = new ShippableProduct("Java Book",new BigDecimal("100"), 10, 1.5);
        Product phone = new ShippableProduct("Smartphone", new BigDecimal("5000"), 5, 0.5);
        Product expiredFood = new ExpirableProduct("Milk", new BigDecimal("20"), 3, LocalDate.of(2024, 7, 1));  
        Product card = new NonShippableProduct("Mobile scratch cards ", new BigDecimal("300"), 2);

         Cart cart = new Cart();
         try{
             cart.addProduct(book, 2);              
             cart.addProduct(phone, 1);              
             cart.addProduct(expiredFood, 1);        
             cart.addProduct(card, 1);
         }catch(Exception ex){
             System.out.println(ex.getMessage());
         }
        Customer customer = new Customer(new BigDecimal("10000")); 
        ShippingService shippingService = new ShippingService();
        Checkout checkout = new Checkout(cart, shippingService, customer);
        
        try {
            checkout.performCheckout();
        } catch (IllegalStateException ex) {
            System.out.println("Checkout failed: " + ex.getMessage());
        }

    }
    
}
