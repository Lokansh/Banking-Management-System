package com.bankingmanagement.bankingmanagement.authentication.exception;

public class UserAuthenticationException extends Exception{
    private final String errorMessage;

    public UserAuthenticationException(String errorMessage) {
        super(errorMessage);
        this.errorMessage = errorMessage;
    }

    @Override
    public String toString() {
        return "userAuthenticationException{" +
                "errorMessage='" + errorMessage + '\'' +
                '}';
    }
}
