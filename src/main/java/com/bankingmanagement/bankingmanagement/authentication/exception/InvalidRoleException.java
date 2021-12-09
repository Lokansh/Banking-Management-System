package com.bankingmanagement.bankingmanagement.authentication.exception;

public class InvalidRoleException extends Exception{

    private final String errorMessage;

    public InvalidRoleException(String errorMessage) {
        super(errorMessage);
        this.errorMessage = errorMessage;
    }

    @Override
    public String toString() {
        return "InvalidRoleException{" +
                "errorMessage='" + errorMessage + '\'' +
                '}';
    }
}
