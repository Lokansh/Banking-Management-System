package com.bankingmanagement.bankingmanagement.loan.database;

import com.bankingmanagement.bankingmanagement.loan.model.Loan;
import org.springframework.stereotype.Component;

import static com.bankingmanagement.bankingmanagement.authentication.database.LoginConstants.*;
import static com.bankingmanagement.bankingmanagement.authentication.database.LoginConstants.LOGIN_ID;
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
                LOANAMOUNT + ", " +
                LOANTYPE  +
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

    @Override
    public String fetchAllPendingLoanQuery() {
        return " SELECT * FROM " + LOAN_TABLE +" WHERE LoanStatus = "+ 0 +"; ";
    }
    @Override
    public String fetchAllApprovedLoanQuery() {
        return " SELECT * FROM " + LOAN_TABLE +" WHERE LoanStatus = "+ 1 +"; ";
    }
    @Override
    public String fetchAllRejectedLoanQuery() {
        return " SELECT * FROM " + LOAN_TABLE +" WHERE LoanStatus = "+ 2 +"; ";
    }
    @Override
    public String approveLoanQuery(int loanId) {
        return "UPDATE " +
                LOAN_TABLE
                + " SET "+
                LOANSTATUS+" ="+ 1 +
                " WHERE " +
                LOAN_ID + "=" + loanId + ";";
    }
    @Override
    public String rejectLoanQuery(int loanId) {
        return "UPDATE " +
                LOAN_TABLE
                + " SET "+
                LOANSTATUS+" ="+ 2 +
                " WHERE " +
                LOAN_ID + "=" + loanId + ";";
    }
}
