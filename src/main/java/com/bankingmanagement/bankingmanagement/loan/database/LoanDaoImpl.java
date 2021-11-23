package com.bankingmanagement.bankingmanagement.loan.database;

import com.bankingmanagement.bankingmanagement.loan.database.LoanDao;
import org.springframework.stereotype.Component;

import static com.bankingmanagement.bankingmanagement.loan.database.LoanConstants.*;

@Component
public class LoanDaoImpl implements LoanDao {

    @Override
    public String getLoanData(String id) {
        return "SELECT " +
                USER_FIRST_NAME + ", " +
                USER_LAST_NAME +
                USER_LOAN_AMOUNT + ", " +
                USER_CIBIL + ", " +
                USER_SALARY +
                " FROM " +
                LOAN_TABLE +
                " WHERE " +
                USER_ID + "=\"" + id + "\";";
    }

}
