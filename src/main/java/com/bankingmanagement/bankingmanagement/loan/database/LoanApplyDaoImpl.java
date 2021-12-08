package com.bankingmanagement.bankingmanagement.loan.database;

import com.bankingmanagement.bankingmanagement.loan.exception.LoanException;
import com.bankingmanagement.bankingmanagement.loan.model.Loan;
import com.bankingmanagement.bankingmanagement.loan.exception.LoanException;
import org.springframework.stereotype.Component;

import java.util.regex.Pattern;

import static com.bankingmanagement.bankingmanagement.loan.database.LoanConstants.*;


@Component
public class LoanApplyDaoImpl implements LoanApplyDao {


    @Override
    public String insertLoanReqTableQuery(Loan loan, String UserId) {
        return "INSERT INTO " + LOAN_TABLE + "(" +
                CUSTOMER_ID + ", " +
                CUSTOMER_FIRST_NAME + ", " +
                CUSTOMER_LAST_NAME + ", " +
                CUSTOMER_ADDRESS1 + ", " +
                CUSTOMER_ADDRESS2 + ", " +
                CUSTOMER_CITY + ", " +
                CUSTOMER_ZIPCODE + ", " +
                CUSTOMER_EMAIL + ", " +
                CUSTOMER_PHONE_NUMBER + ", " +
                CUSTOMER_SIN + ", " +
                CUSTOMER_SALARY + ", " +
                CUSTOMER_AGE + ", " +
                CUSTOMER_LOANAMOUNT + ", " +
                CUSTOMER_LOANTYPE  +
                ") " +
                "VALUES (" +
                "\"" + UserId+ "\", " +
                "\"" + loan.getFirstName() + "\", " +
                "\"" + loan.getLastName() + "\", " +
                "\"" + loan.getAddress1() + "\", " +
                "\"" + loan.getAddress2() + "\", " +
                "\"" + loan.getCity() + "\", " +
                "\"" + loan.getZipCode() + "\", " +
                "\"" + loan.getEmail() + "\", " +
                "\"" + loan.getContactNumber() + "\", " +
                "\"" + loan.getSin() + "\", " +
                "\"" + loan.getSalary() + "\", " +
                "\"" + loan.getAge() + "\", " +
                "\"" + loan.getLoanAmount() + "\", " +
                "\"" + loan.getLoanType() + "\"" +
                ");";
    }

    @Override
    public String fetchLoanReqTableQuery(String userId) {
        return " SELECT * FROM " + LOAN_TABLE +" WHERE CustomerID = "+ "\"" + userId + "\"; ";
    }





}
