package com.bankingmanagement.bankingmanagement.authentication.database;

import org.springframework.stereotype.Component;
import static com.bankingmanagement.bankingmanagement.authentication.database.LoginConstants.*;

@Component
public class LoginDaoImpl implements LoginDao {
    public LoginDaoImpl() {
    }

    @Override
    public String selectUserByUsername(String username) {
        return "SELECT " +
                LOGIN_ID + ", " +
                LOGIN_PASSWORD +
                " FROM " +
                USERLOGIN_TABLE +
                " WHERE " +
                LOGIN_ID + "=\"" + username + "\";";
    }
}
