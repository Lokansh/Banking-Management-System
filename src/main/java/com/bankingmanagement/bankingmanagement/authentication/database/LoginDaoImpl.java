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
                LOGIN_FAILED_ATTEMPT + ", " +
                LOGIN_PASSWORD + ", " +
                LOGIN_ROLE_TYPE + ", " +
                LOGIN_BLOCK_TIMESTAMP +
                " FROM " +
                USER_LOGIN_TABLE +
                " WHERE " +
                LOGIN_ID + "=\"" + username + "\";";
    }

    @Override
    public String storeDatetimeQuery(String username,String datetime) {
        return "UPDATE " +
                USER_LOGIN_TABLE
                + " SET "+
                LOGIN_BLOCK_TIMESTAMP+" ="+"\"" + datetime + "\"," +
                LOGIN_FAILED_ATTEMPT+" ="+"\"" + 0 + "\" "+
                " WHERE " +
                LOGIN_ID + "=\"" + username + "\";";
    }

    @Override
    public String storeFailedAttemptQuery(String username, int failedAttempt) {
        return "UPDATE " +
                USER_LOGIN_TABLE
                + " SET "+
                LOGIN_FAILED_ATTEMPT+" ="+"\"" + failedAttempt + "\" "+
                " WHERE " +
                LOGIN_ID + "=\"" + username + "\";";
    }

}
