package com.bankingmanagement.bankingmanagement.employeeDashboard.exception;

public class RequestException extends Exception{

	private final String errorMessage;

    public RequestException(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    @Override
    public String toString() {
        return "requestsException{" +
                "errorMessage='" + errorMessage + '\'' +
                '}';
    }

}

