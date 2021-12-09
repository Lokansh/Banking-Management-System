package com.bankingmanagement.bankingmanagement.fundManipulation.exception;

public class StatementException extends Exception {
	private final String errorMessage;

    public StatementException(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    @Override
    public String toString() {
        return "statementException{" +
                "errorMessage='" + errorMessage + '\'' +
                '}';
    }
}
