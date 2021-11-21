package com.bankingmanagement.bankingmanagement.cardsChequebook.database;

import static com.bankingmanagement.bankingmanagement.cardsChequebook.database.CardsChequeBookConstants.*;

import org.springframework.stereotype.Component;

@Component
public class CardsChequeBookDaoImpl implements com.bankingmanagement.bankingmanagement.cardsChequebook.database.CardsChequeBookDao {

    @Override
    public String cardsChequeBookData(String username) {
        return "SELECT " +
                LOGIN_ID + ", " +
                LOGIN_PASSWORD +
                " FROM " +
                USERLOGIN_TABLE +
                " WHERE " +
                LOGIN_ID + "=\"" + username + "\";";

    }

}
