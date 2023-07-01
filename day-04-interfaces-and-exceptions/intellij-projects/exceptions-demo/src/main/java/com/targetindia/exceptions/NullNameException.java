package com.targetindia.exceptions;

public class NullNameException extends RuntimeException {
    public NullNameException() {
    }

    public NullNameException(String message) {
        super(message);
    }

    public NullNameException(Throwable cause) {
        super(cause);
    }
}
