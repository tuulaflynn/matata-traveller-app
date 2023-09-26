package com.aalifadesigns.matatatraveller.exception;

public class EntityAlreadyExistsException extends RuntimeException{

    @Override
    public String getMessage(){
        return ("The data could not be added to the database because there is already a record with this ID in use.");
    }
}