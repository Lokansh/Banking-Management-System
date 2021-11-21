package com.bankingmanagement.bankingmanagement.cardsChequebook.database;

import static com.bankingmanagement.bankingmanagement.cardsChequebook.database.CardsChequeBookConstants..*;

import org.springframework.stereotype.Component;

@Component
public class CardsChequeBookDaoImpl implements com.bankingmanagement.bankingmanagement.employeeDashboard.database.CardsChequeBookDao {

    @Override
    public String getEmployeeDetailsData(String id) {
        return "SELECT " +
                EMP_FIRST_NAME + ", " +
                EMP_LAST_NAME +
                EMP_MANAGER + ", " +
                EMP_SALARY +
                " FROM " +
                EMPLOYEE_TABLE +
                " WHERE " +
                EMP_ID + "=\"" + id + "\";";
    }

}
