package com.bankingmanagement.bankingmanagement.forget.database;

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
        return "UPDATE " +
                USERLOGIN_TABLE
                + " SET "+
                LOGIN_PASSWORD+" ="+"\"" + password + "\" " +
                " WHERE " +
                LOGIN_ID + "=\"" + username + "\";";
    }

}

