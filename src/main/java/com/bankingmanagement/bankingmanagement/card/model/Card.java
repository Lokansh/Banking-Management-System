package com.bankingmanagement.bankingmanagement.card.model;

public class Card {

    private String cardNumber;
    private String cardType;
    private String cardStatus;

    public Card(String cardNumberInput, String cardTypeInput, String cardStatusInput){
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
