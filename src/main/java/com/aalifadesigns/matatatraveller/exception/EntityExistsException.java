package com.aalifadesigns.matatatraveller.exception;

public class EntityExistsException extends RuntimeException{
    @Override
    public String getMessage() {
        return ("Entity exists");
    }
}

