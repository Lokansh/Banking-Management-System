package com.bankingmanagement.bankingmanagement.card.database;

import static com.bankingmanagement.bankingmanagement.card.database.CardConstants.*;

import org.springframework.stereotype.Component;

@Component
public class CardDaoImpl implements com.bankingmanagement.bankingmanagement.card.database.CardDao {

    @Override
    public String cardData(String username) {
        return "SELECT " +
                LOGIN_ID + ", " +
                LOGIN_PASSWORD +
                " FROM " +
                USERLOGIN_TABLE +
                " WHERE " +
                LOGIN_ID + "=\"" + username + "\";";

    }

}
