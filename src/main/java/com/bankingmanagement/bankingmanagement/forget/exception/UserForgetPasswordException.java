package com.bankingmanagement.bankingmanagement.forget.exception;

public class UserForgetPasswordException extends Exception{
    private final String errorMessage;

    public UserForgetPasswordException(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    @Override
    public String toString() {
        return "UserForgetPasswordException{" +
                "errorMessage='" + errorMessage + '\'' +
                '}';
    }
}
