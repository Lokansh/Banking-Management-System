package com.bankingmanagement.bankingmanagement.fundManipulation.exception;

public class FundTransferException extends Exception{
	
    private final String errorMessage;

    public FundTransferException(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    @Override
    public String toString() {
        return "FundTransferException{" +
                "errorMessage='" + errorMessage + '\'' +
                '}';
    }

}
