package com.bankingmanagement.bankingmanagement.signup.database;

import com.bankingmanagement.bankingmanagement.signup.model.Customer;
import org.springframework.stereotype.Component;
import static com.bankingmanagement.bankingmanagement.signup.database.CustomerConstants.*;
import static com.bankingmanagement.bankingmanagement.authentication.database.LoginConstants.*;
import static com.bankingmanagement.bankingmanagement.signup.database.SecurityConstants.*;

@Component
public class RegisterDaoImpl implements RegisterDao {
    public RegisterDaoImpl() {
    }


    @Override
    public String insertUserTableQuery(Customer user) {
        return "INSERT INTO " + CUSTOMER_TABLE + "(" +
                CUSTOMER_ID + ", " +
                CUSTOMER_FIRST_NAME + ", " +
                CUSTOMER_LAST_NAME + ", " +
                CUSTOMER_ADDRESS1 + ", " +
                CUSTOMER_ADDRESS2 + ", " +
                CUSTOMER_CITY + ", " +
                CUSTOMER_EMAIL + ", " +
                CUSTOMER_ZIPCODE + ", " +
                CUSTOMER_PHONE_NUMBER + ", " +
                CUSTOMER_SIN + ") " +
                "VALUES (" +
                "\"" + user.getCustomerId() + "\", " +
                "\"" + user.getFirstName() + "\", " +
                "\"" + user.getLastName() + "\", " +
                "\"" + user.getAddress1() + "\", " +
                "\"" + user.getAddress2() + "\", " +
                "\"" + user.getCity() + "\", " +
                "\"" + user.getEmail() + "\", " +
                "\"" + user.getZipCode() + "\", " +
                "\"" + user.getContactNumber() + "\", " +
                "\"" + user.getSin() + "\"" +
                ");";
    }


	@Override
    public String insertLoginTableQuery(String username, String password) {
        return "INSERT INTO " + USER_LOGIN_TABLE + "(" +
                LOGIN_ID + ", " +
                LOGIN_FAILED_ATTEMPT + ", " +
                LOGIN_ROLE_TYPE + ", " +
                LOGIN_PASSWORD +") " +
                "VALUES (" +
                "\"" + username + "\", " +
                "\"" + 0 + "\", " +
                "\"" + 0 + "\", " +
                "\"" + password + "\" " +
                ");";
    }

    @Override
    public String insertSecurityQuestionTableQuery(String userID,int questionID, String answer) {
        return "INSERT INTO " + SECURITY_ANSWER_TABLE + "(" +
                SECURITY_LOGIN_ID + ", " +
                SECURITY_QUESTION_ID + ", " +
                SECURITY_ANSWER + ") " +
                "VALUES (" +
                "\"" + userID + "\", " +
                "\"" + questionID + "\", " +
                "\"" + answer + "\" " +
                ");";
    }

}
