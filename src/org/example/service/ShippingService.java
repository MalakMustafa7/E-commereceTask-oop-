 package org.example.service;

import org.example.interfaces.Shippable;
import java.math.BigDecimal;
import java.util.List;

public class ShippingService {
    public BigDecimal calculateShippingFees(List<Shippable> items){
        if(items == null ||items.isEmpty()){
            throw new IllegalStateException("No shippable items found ");
        }
        BigDecimal fees= BigDecimal.ZERO;
        for(Shippable item:items){
             BigDecimal weight = BigDecimal.valueOf(item.getWeight());
             BigDecimal fee = weight.multiply(BigDecimal.valueOf(5));  
             fees = fees.add(fee);
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
