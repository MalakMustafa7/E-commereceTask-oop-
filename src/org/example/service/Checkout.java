 package org.example.service;

import org.example.service.ShippingService;
import org.example.interfaces.Shippable;
import java.math.BigDecimal;
import org.example.model.Customer;
import org.example.model.CartItem;
import org.example.model.Cart;
import org.example.model.Product;
import java.util.List;
import org.example.customeExceptions.InsufficientBalanceException;

public class Checkout {
    Cart cart;
    ShippingService shippingservice;
    Customer customer;

    public Checkout(Cart cart, ShippingService shippingservice, Customer customer) {
        this.cart = cart;
        this.shippingservice = shippingservice;
        this.customer = customer;
    }

    
    public void performCheckout(){
        if(cart.isEmpty()){
            throw new IllegalStateException("Cart is empty");
        }
        List<Shippable>items = cart.getShippableItems();
        BigDecimal fees = shippingservice.calculateShippingFees(items);
        BigDecimal price = cart.getSubtotal();
        BigDecimal totalPrice= price.add(fees);
        if(customer.getBalance().compareTo(totalPrice) < 0){
            throw new InsufficientBalanceException("Insufficient balance: " + customer.getBalance() + " < " + totalPrice);
        }
        customer.deductBalance(totalPrice);
        List<CartItem>cartItems = cart.getItems();
        for(CartItem item:cartItems){
            Product product = item.getProduct();
            product.updateQuantity(item.getQuantity());
        }
        shippingservice.shipItems(items);
        System.out.println("Checkout Details:");
        System.out.println("Order Subtotal: $" + price);
        System.out.println("Shipping Fees: $" + fees);
        System.out.println("Paid Amount: $" + totalPrice);
        System.out.println("Customer Balance After Payment: $" + customer.getBalance());
        cart.clearCart();
        
        
        
    }
}
