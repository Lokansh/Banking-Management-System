package com.bankingmanagement.bankingmanagement.card.database;

import org.springframework.stereotype.Component;
import static com.bankingmanagement.bankingmanagement.card.database.CardConstants.*;

@Component
public class CardEligibilityCheckDaoImpl implements CardEligibilityCheckDao{
    @Override
    public String checkEligibilityQuery(String customerId, String sin) {
        return "SELECT * FROM " +
                CREDIT_TABLE +
                " WHERE " +
                CREDIT_SIN + "=\"" + sin + "\"" + " AND " +
                CUSTOMER_ID + "=\"" + customerId + "\";";
    }
}
