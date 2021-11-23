package com.bankingmanagement.bankingmanagement.loan.exception;

public class LoanException extends Throwable {
    private final String errorMessage;

    public LoanException(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    @Override
    public String toString() {
        return "LoanException{" +
                "errorMessage='" + errorMessage + '\'' +
                '}';
    }
}
