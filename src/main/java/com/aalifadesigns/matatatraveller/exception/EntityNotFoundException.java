package com.aalifadesigns.matatatraveller.exception;

public class EntityNotFoundException extends RuntimeException {
    @Override
    public String getMessage() {
        return ("Data doesn't exist");
    }
}


