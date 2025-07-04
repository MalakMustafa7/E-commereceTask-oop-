 package e.commerecesystem;

import java.util.List;

public class ShippingService {
    public double calculateShippingFees(List<Shippable> items){
        if(items == null ||items.isEmpty()){
            throw new IllegalStateException("No shippable items found ");
        }
        double fees=0;
        for(Shippable item:items){
            fees+=(item.getWeight()*5);
        }
        return fees;
    }
    public void shipItems(List<Shippable> items){
        if(items.isEmpty()){
            return ;
        }
         for(Shippable item:items){
              System.out.println("Shipping item: " + item.getName() +
                               ", Weight: " + item.getWeight() + " kg");
         }
        
    }
}
