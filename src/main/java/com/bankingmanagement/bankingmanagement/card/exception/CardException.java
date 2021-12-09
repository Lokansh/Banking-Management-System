package com.bankingmanagement.bankingmanagement.card.exception;

public class CardException extends Throwable {
    private final String errorMessage;

    public CardException(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    @Override
    public String toString() {
        return "CardException{" +
                "errorMessage='" + errorMessage + '\'' +
                '}';
    }
}
