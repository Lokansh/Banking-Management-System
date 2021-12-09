package com.bankingmanagement.bankingmanagement.chequebook.exception;

public class ChequeBookException extends Throwable {
    private final String errorMessage;

    public ChequeBookException(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    @Override
    public String toString() {
        return "ChequeBookException{" +
                "errorMessage='" + errorMessage + '\'' +
                '}';
    }
}
