package com.aalifadesigns.matatatraveller.exception;

public class InvalidThreadDateException extends RuntimeException {
    @Override
    public String getMessage() {
        return ("No threads exists for date entered.");
    }
}
