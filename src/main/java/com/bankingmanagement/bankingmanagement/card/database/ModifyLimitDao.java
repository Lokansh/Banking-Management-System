package com.bankingmanagement.bankingmanagement.card.database;

public interface ModifyLimitDao {
    String checkCardLimit(String customerId);
    String modifyLimitQuery(String customerId, String cardNumber, String newlimit);
}
