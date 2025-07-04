 package e.commerecesystem;

import java.util.List;

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
        double fees = shippingservice.calculateShippingFees(items);
        double price = cart.getSubtotal();
        double totalPrice= price+fees;
        if(customer.getBalance()<totalPrice){
            throw new IllegalStateException("Insufficient balance: " + customer.getBalance() + " < " + totalPrice);
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
