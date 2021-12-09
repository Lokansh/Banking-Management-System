
package com.bankingmanagement.bankingmanagement.ccservice.exception;

public class CreditCardException extends Exception{
    private final String errorMessage;

    public CreditCardException(String errorMessage) {
 this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    @Override
    public String toString() {

        return "CardException{" + "errorMessage='" + errorMessage + '\'' +
                '}';
    }
}
