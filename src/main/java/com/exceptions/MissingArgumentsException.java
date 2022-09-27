package com.exceptions;

public class MissingArgumentsException extends Exception {
    public MissingArgumentsException(String errorMessage) {
        super(errorMessage);
    }
    public MissingArgumentsException(String errorMessage, Throwable err) {
        super(errorMessage, err);
    }
}
