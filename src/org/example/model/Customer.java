 package org.example.model;

import java.math.BigDecimal;
import org.example.exception.InsufficientBalanceException;

public class Customer {
    private BigDecimal balance;

    public Customer(BigDecimal balance) {
        this.balance = balance;
    }

    public BigDecimal getBalance() {
        return balance;
    }
    public void deductBalance(BigDecimal amount){
        if(amount.compareTo(BigDecimal.ZERO) <= 0){
             throw new IllegalArgumentException("Amount must be greater than zero.");
        }
        else if(amount.compareTo(balance) > 0){
             throw new InsufficientBalanceException("Insufficient balance. Available: " + balance + ", Required: " + amount);
        }
         balance = balance.subtract(amount);
        
    }
}
