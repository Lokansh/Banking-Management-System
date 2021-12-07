package com.bankingmanagement.bankingmanagement.card.database;

public interface NewCardRequestDao {
    String submitNewCardRequestQuery(String customerId, String cardType);
}
