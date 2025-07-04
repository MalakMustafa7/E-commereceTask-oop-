 package e.commerecesystem;
public class ShippableProduct extends Product  implements Shippable {
    double weight;

    public ShippableProduct(String name, double price, int quantity,double weight) {
        super(name, price, quantity);
        if (weight <= 0) throw new IllegalArgumentException("Weight must be positive");
        this.weight=weight;
    }
    
    @Override
    public String getName() {
         return super.getName();
    }

    @Override
    public double getWeight() {
         return this.weight;
    }

    @Override
    public boolean isExpired() {
        return false;
    }
    
}
 