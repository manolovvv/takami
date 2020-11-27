package com.takami.rest.Exceptions;

public class EmailExistException extends Exception {
    public EmailExistException(String errorMessage){
        super(errorMessage);
    }
}
