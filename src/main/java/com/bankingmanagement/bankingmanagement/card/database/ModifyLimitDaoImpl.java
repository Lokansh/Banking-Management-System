package com.bankingmanagement.bankingmanagement.card.database;

import org.springframework.stereotype.Component;

import static com.bankingmanagement.bankingmanagement.card.database.CardConstants.*;

@Component
public class ModifyLimitDaoImpl implements ModifyLimitDao{

    @Override
    public String checkCardLimit(String customerId){
        return "SELECT * FROM " +
                CARD_TABLE +
                " WHERE " +
                CUSTOMER_ID + "=\"" + customerId + "\";";
    }

    @Override
    public String modifyLimitQuery(String customerId, String cardNumber, String newlimit){
        return "UPDATE " + CARD_TABLE +
                " SET " + CARD_LIMIT + "=\"" + newlimit + "\"" + " WHERE " +
                CARD_NUMBER + "=\"" + cardNumber + "\"" + " AND " +
                CUSTOMER_ID + "=\"" + customerId + "\";";
    }


}
