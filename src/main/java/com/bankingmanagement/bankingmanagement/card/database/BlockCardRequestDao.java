package com.bankingmanagement.bankingmanagement.card.database;

public interface BlockCardRequestDao {
    String submitBlockCardRequestQuery(String customerId, String cardType);
    String blockCard(String customerId, String cardNumber);
}
