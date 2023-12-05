package com.manusoft.ecommerce.exception;

public class PriceNotFoundException extends RuntimeException {
    public PriceNotFoundException(String message){
        super(message);
    }
}
