package com.bankingmanagement.bankingmanagement.signup.exception;

public class NewPasswordException extends Exception {

    private final String errorMessage;

    public String getErrorMessage() {
        return errorMessage;
    }

    public NewPasswordException(String errorMessage) {
        this.errorMessage = errorMessage;
    }
    @Override
    public String toString() {
        return "NewPasswordException{" +
                "errorMessage='" + errorMessage + '\'' +
                '}';
    }
}
