package com.src.pruebaCelsia.Exception;

public class DuplicateException extends RuntimeException{
    private int statusCode;

    public DuplicateException(String message, int statusCode) {
        super(message);
        this.statusCode = statusCode;
    }

    public DuplicateException(String message, Throwable cause, int statusCode) {
        super(message, cause);
        this.statusCode = statusCode;
    }

    public int getStatusCode() {
        return statusCode;
    }
}
