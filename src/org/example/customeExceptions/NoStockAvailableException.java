 package org.example.customeExceptions;
public class NoStockAvailableException extends RuntimeException {
    public NoStockAvailableException(String message){
        super(message);
    }
}
