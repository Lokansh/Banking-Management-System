package com.bankingmanagement.bankingmanagement.card.database;

public interface CardEligibilityCheckDao {
    String checkEligibilityQuery(String customerId, String sin);
}
