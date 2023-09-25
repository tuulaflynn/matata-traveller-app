package com.aalifadesigns.matatatraveller.exception;

public class DataMismatchException extends RuntimeException{
    @Override
    public String getMessage() {
        return ("Data stored in the system does not match expected values");
    }
}
