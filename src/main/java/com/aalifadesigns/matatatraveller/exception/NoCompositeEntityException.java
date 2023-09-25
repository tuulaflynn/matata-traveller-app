package com.aalifadesigns.matatatraveller.exception;

public class NoCompositeEntityException extends RuntimeException{
    @Override
    public String getMessage() {
        return ("There is data missing in one of the properties for the data are trying to add.");
    }
}

