package com.aalifadesigns.matatatraveller.exception;

public class InputMismatchException extends RuntimeException{
    @Override
    public String getMessage(){
        return ("Input data does not match the expected format");
    }
}
