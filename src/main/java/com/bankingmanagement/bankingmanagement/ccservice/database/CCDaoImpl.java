package com.bankingmanagement.bankingmanagement.ccservice.database;

import org.springframework.stereotype.Component;

import static com.bankingmanagement.bankingmanagement.ccservice.database.CreditCardConstants.*;
import static com.bankingmanagement.bankingmanagement.ccservice.database.CreditCardConstants.CUSTOMER_ID;
import static com.bankingmanagement.bankingmanagement.signup.database.CustomerConstants.*;

@Component
public class CCDaoImpl implements CCDao{
    @Override
    public String fetchAllCCTableQuery(String userId) {
        return " SELECT * FROM " + CARD_TABLE +" WHERE CustomerID = "+ "\"" + userId + "\"; ";
    }

    @Override
    public String fetchCreditScoreQuery(String sin) {
        return " SELECT * FROM " + CREDIT_TABLE +" WHERE SIN = "+ "\"" + sin + "\"; ";
    }

    @Override
    public String submitCCIncReqQuery(String userId, String salary) {
        return "INSERT INTO " + CARDREQUEST_TABLE + "(" +
                CUSTOMER_ID + ", " +
                NEWSALARY  +
                 ") " +
                "VALUES (" +
                "\"" + userId + "\", " +
                "\"" + salary  + "\""+
                ");";

    }

    @Override
    public String getOldSalary(String userId){
        return " SELECT Salary FROM " + CUSTOMER_TABLE +" WHERE"+ CUSTOMER_ID+ "= "+ "\"" + userId + "\"; ";
    }

}
