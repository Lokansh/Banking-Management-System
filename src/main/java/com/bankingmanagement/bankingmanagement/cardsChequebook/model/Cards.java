package com.bankingmanagement.bankingmanagement.cardsChequebook.model;

public class Cards {

    private String cardNumber;
    private String cardType;
    private String cardStatus;

    public Cards(String cardNumberInput, String cardTypeInput, String cardStatusInput){
        this.cardNumber = cardNumberInput;
        this.cardType = cardTypeInput;
        this.cardStatus = cardStatusInput;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    public String getCardStatus() {
        return cardStatus;
    }

    public void setCardStatus(String cardStatus) {
        this.cardStatus = cardStatus;
    }
}
