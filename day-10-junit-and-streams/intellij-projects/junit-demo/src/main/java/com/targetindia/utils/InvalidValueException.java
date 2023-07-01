package com.targetindia.utils;

public class InvalidValueException extends RuntimeException{
    public InvalidValueException() {
    }

    public InvalidValueException(String message) {
        super(message);
    }

    public InvalidValueException(Throwable cause) {
        super(cause);
    }
}
