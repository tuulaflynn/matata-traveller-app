package com.aalifadesigns.matatatraveller.exception;

public class InvalidIdException extends RuntimeException {
    @Override
    public String getMessage(){
        return ("Error. Invalid id given.");
    }
}
