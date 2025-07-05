 package org.example.customeExceptions;
public class ExpiredException extends RuntimeException {
    public ExpiredException(String message){
        super(message);
    }
}
