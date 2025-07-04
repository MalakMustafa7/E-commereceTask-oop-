 package e.commerecesystem;
public abstract class Product {
    private String name;
    private double price;
    private int quantity;
    public Product(String name,double price,int quantity){
        if (price <= 0) throw new IllegalArgumentException("Price must be positive");
        if (quantity < 0) throw new IllegalArgumentException("Quantity cannot be negative"); 
        this.name=name;
        this.price=price;
        this.quantity=quantity;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
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