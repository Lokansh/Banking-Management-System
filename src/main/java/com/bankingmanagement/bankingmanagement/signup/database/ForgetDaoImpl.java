package com.bankingmanagement.bankingmanagement.signup.database;

import org.springframework.stereotype.Component;

import static com.bankingmanagement.bankingmanagement.authentication.database.LoginConstants.*;
import static com.bankingmanagement.bankingmanagement.signup.database.SecurityConstants.*;

@Component
public class ForgetDaoImpl implements ForgetDao {
    public ForgetDaoImpl() {
    }

    @Override
    public String getSecurityQuestionQuery(String username) {

        return "SELECT " +
                SECURITY_LOGIN_ID + ", " +
                SECURITY_QUESTION_ID + ", " +
                SECURITY_ANSWER +
                " FROM " +
                SECURITY_ANSWER_TABLE +
                " WHERE " +
                SECURITY_LOGIN_ID + "=\"" + username + "\";";
    }

    @Override
    public String updatePasswordQuery(String username,String password){
        String dummyDate = "2020-01-01 00:00:00";
        return "UPDATE " +
                USER_LOGIN_TABLE
                + " SET "+
                LOGIN_PASSWORD+" ="+"\"" + password + "\" ," +
                LOGIN_FAILED_ATTEMPT+" ="+"\"" + 0 + "\" ,"+
                LOGIN_BLOCK_TIMESTAMP+" ="+"\"" + dummyDate + "\" "+
                " WHERE " +
                LOGIN_ID + "=\"" + username + "\";";
    }

}

