package com.aalifadesigns.matatatraveller.exception;

public class UpdateCategoryException extends RuntimeException{

    @Override
    public String getMessage(){
        return ("You cannot update a category without specifying any threads' IDs. " +
                "Otherwise, all threads in that category will be lost.Consider creating a new category instead.\n" +
                "Similarly, all threads' Id which are not added will be lost. ");
    }
}
