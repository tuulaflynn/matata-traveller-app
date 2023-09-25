package com.aalifadesigns.matatatraveller.exception;

public class EntityNotFoundException extends RuntimeException {
    @Override
    public String getMessage() {
        return ("Entity doesn't exist");
    }
}


