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
 import java.util.Scanner;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.example.exception.ExpiredProductException;
import org.example.exception.InsufficientBalanceException;
import org.example.exception.OutOfStockException;

public class ECommereceSystem {
    public static void main(String[] args) {
          List<Product> products = new ArrayList<>();
        products.add(new ExpirableProduct("cheese", new BigDecimal("20.0"), 10, LocalDate.now().minusDays(10)));  
        products.add(new ExpirableProduct("Biscuits", new BigDecimal("15.0"), 15, LocalDate.now().plusDays(15)));
        products.add(new ShippableProduct("tv", new BigDecimal("30.0"), 10, 100));
        products.add(new NonShippableProduct("mobileScratchCards", new BigDecimal("40.0"), 5));
        products.add(new NonShippableProduct("mobile", new BigDecimal("60.0"), 3));
        Scanner input = new Scanner(System.in);
        System.out.print("Enter customer balance: ");
        BigDecimal balance = input.nextBigDecimal();
        input.nextLine();  
        Customer customer = new Customer(balance);
        
         System.out.println("Our products:");
        for (Product p : products) {
            System.out.print(p.getName() + "  ");
        }
        System.out.println();
        
        Cart cart = new Cart();
        ShippingService shippingService = new ShippingService();
        Checkout checkout = new Checkout(cart, shippingService, customer);
        
        while (true) {
            System.out.print("enter name of product\n");
            String name = input.nextLine().trim();
            if (name.equalsIgnoreCase("end")) break;

            Product selected = null;
            for (Product p : products) {
                if (p.getName().equalsIgnoreCase(name)) {
                    selected = p;
                    break;
                }
            }

            if (selected == null) {
                System.out.println("Product not found");
                continue;
            }

            System.out.println("enter quantity of product");
            int qty = input.nextInt();
            input.nextLine();

            try {
                cart.addProduct(selected, qty);
            } catch (ExpiredProductException e) {
                System.out.println(e.getMessage());
            } catch (OutOfStockException e) {
                System.out.println(e.getMessage());
            }
        }

        try {
            checkout.performCheckout();
        } catch (IllegalStateException | InsufficientBalanceException e) {
            System.out.println("Checkout failed: " + e.getMessage());
        }
    }

    }
    


