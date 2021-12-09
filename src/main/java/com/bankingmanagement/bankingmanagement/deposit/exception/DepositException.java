package com.bankingmanagement.bankingmanagement.deposit.exception;

public class DepositException extends Throwable{
    private final String errorMessage;

    public DepositException(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    @Override
    public String toString() {
        return "DepositException{" +
                "errorMessage='" + errorMessage + '\'' +
                '}';
    }
}
