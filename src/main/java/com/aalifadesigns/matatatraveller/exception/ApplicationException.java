package com.aalifadesigns.matatatraveller.exception;

public class ApplicationException extends RuntimeException{
    @Override
    public String getMessage() {
        return "Attraction does not exist!";
    }
}
