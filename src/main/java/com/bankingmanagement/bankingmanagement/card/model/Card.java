package com.bankingmanagement.bankingmanagement.card.model;

public class Card {

    private String customerID;
    private String cardNumber;
    private String cardType;
    private String cardStatus;
    private String cardLimit;
    private Integer cardPin;

    public Card (){}

    public Card(String customerIDInput, String cardNumberInput, String cardTypeInput,
                String cardStatusInput, String cardLimitInput, Integer cardPinInput){
        this.customerID = customerIDInput;
        this.cardNumber = cardNumberInput;
        this.cardType = cardTypeInput;
        this.cardStatus = cardStatusInput;
        this.cardLimit = cardLimitInput;
        this.cardPin = cardPinInput;
    }
    public String getCustomerID() {
        return customerID;
    }
    public void setCustomerID(String customerID) {
        this.customerID = customerID;
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

    public String getCardLimit() {
        return cardLimit;
    }
    public void setCardLimit(String cardLimit) {
        this.cardLimit = cardLimit;
    }

    public Integer getCardPin() {
        return cardPin;
    }
    public void setCardPin(Integer cardPin) {
        this.cardPin = cardPin;
    }
}
