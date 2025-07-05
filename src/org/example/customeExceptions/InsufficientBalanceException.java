 package org.example.customeExceptions;
public class InsufficientBalanceException extends RuntimeException{
     public InsufficientBalanceException(String message) {
        super(message);
    }
}
