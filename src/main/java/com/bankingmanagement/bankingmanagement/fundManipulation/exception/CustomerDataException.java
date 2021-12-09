package com.bankingmanagement.bankingmanagement.fundManipulation.exception;

public class CustomerDataException extends Exception{
	
    private final String errorMessage;

    public CustomerDataException(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    @Override
    public String toString() {
        return "CustomerDataException{" +
                "errorMessage='" + errorMessage + '\'' +
                '}';
    }

}
