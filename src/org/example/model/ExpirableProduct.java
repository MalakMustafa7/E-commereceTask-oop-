 package org.example.model;

import java.math.BigDecimal;
import org.example.model.Product;
import java.time.LocalDate;

public class ExpirableProduct extends Product {
    LocalDate expireDate;
  

    public ExpirableProduct(String name, BigDecimal price, int quantity,LocalDate expireDate) {
        super(name, price, quantity);
        this.expireDate=expireDate;
       
    }
    
    public LocalDate getExpireDate() {
        return expireDate;
    }
    
    public boolean isExpired(){
        return expireDate.isBefore( LocalDate.now());
    }
}
