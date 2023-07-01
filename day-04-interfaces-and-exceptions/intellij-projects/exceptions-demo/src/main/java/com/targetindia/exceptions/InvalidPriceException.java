package com.targetindia.exceptions;

public class InvalidPriceException extends RuntimeException{
    public InvalidPriceException() {
    }

    public InvalidPriceException(String message) {
        super(message);
    }

    public InvalidPriceException(Throwable cause) {
        super(cause);
    }
}
