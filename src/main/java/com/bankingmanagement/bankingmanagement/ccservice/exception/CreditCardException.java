<<<<<<< HEAD:src/main/java/com/bankingmanagement/bankingmanagement/ccservice/exception/CreditCardException.java
package com.bankingmanagement.bankingmanagement.ccservice.exception;

public class CreditCardException extends Exception{
    private final String errorMessage;

    public CreditCardException(String errorMessage) {
=======
package com.bankingmanagement.bankingmanagement.card.exception;

public class CardException extends Throwable {
    private final String errorMessage;

    public CardException(String errorMessage) {
>>>>>>> 914bb5c0d17f14b02de6ec26856ec41d510c087d:src/main/java/com/bankingmanagement/bankingmanagement/card/exception/CardException.java
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    @Override
    public String toString() {
<<<<<<< HEAD:src/main/java/com/bankingmanagement/bankingmanagement/ccservice/exception/CreditCardException.java
        return "CreditCardException{" +
=======
        return "CardException{" +
>>>>>>> 914bb5c0d17f14b02de6ec26856ec41d510c087d:src/main/java/com/bankingmanagement/bankingmanagement/card/exception/CardException.java
                "errorMessage='" + errorMessage + '\'' +
                '}';
    }
}
