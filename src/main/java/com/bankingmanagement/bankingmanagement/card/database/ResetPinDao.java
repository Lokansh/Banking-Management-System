package com.bankingmanagement.bankingmanagement.card.database;

public interface ResetPinDao {
    String resetPinQuery(String customerId, String cardNumber, String cardPin);
}
