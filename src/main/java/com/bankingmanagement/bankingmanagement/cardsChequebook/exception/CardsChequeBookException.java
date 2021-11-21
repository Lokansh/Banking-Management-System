package com.bankingmanagement.bankingmanagement.cardsChequebook.exception;

public class CardsChequeBookException {
    private final String errorMessage;

    public CardsChequeBookException(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    @Override
    public String toString() {
        return "CardsChequeBookException{" +
                "errorMessage='" + errorMessage + '\'' +
                '}';
    }
}
