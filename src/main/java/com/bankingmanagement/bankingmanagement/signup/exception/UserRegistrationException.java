package com.bankingmanagement.bankingmanagement.signup.exception;

public class UserRegistrationException extends Exception{
    private final String errorMessage;

    public UserRegistrationException(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    @Override
    public String toString() {
        return "UserRegistrationException{" +
                "errorMessage='" + errorMessage + '\'' +
                '}';
    }
}
