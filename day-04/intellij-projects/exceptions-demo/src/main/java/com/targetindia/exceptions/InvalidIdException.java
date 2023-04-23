package com.targetindia.exceptions;

public class InvalidIdException extends RuntimeException {
    public InvalidIdException() {
        super("Invalid id was supplied");
    }

    public InvalidIdException(String message) {
        super(message);
    }

    public InvalidIdException(Throwable cause) {
        super(cause);
    }

}
