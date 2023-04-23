package com.targetindia.exceptions;

public class BlankNameException extends Exception{
    public BlankNameException() {
    }

    public BlankNameException(String message) {
        super(message);
    }

    public BlankNameException(Throwable cause) {
        super(cause);
    }
}
