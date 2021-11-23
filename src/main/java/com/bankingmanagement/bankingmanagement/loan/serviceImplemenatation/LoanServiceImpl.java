package com.bankingmanagement.bankingmanagement.loan.serviceImplemenatation;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.bankingmanagement.bankingmanagement.cardsChequebook.service.CardsChequeBookService;
import com.bankingmanagement.bankingmanagement.loan.database.LoanDao;
import com.bankingmanagement.bankingmanagement.loan.exception.LoanException;
import com.bankingmanagement.bankingmanagement.loan.service.LoanService;
import org.springframework.beans.factory.annotation.Autowired;

import com.bankingmanagement.bankingmanagement.database.DatabaseConnectionDao;
import com.bankingmanagement.bankingmanagement.database.DatabaseConnectionException;
import org.springframework.beans.factory.annotation.Autowired;
import com.bankingmanagement.bankingmanagement.database.DatabaseConnectionException;


public class LoanServiceImpl implements LoanService {
    @Autowired
    private DatabaseConnectionDao databaseConnectionDAO;

    @Autowired
    private LoanDao getLoanDetailsDao;

    @Override
    public String getLoanDetails(String id) throws LoanException {
        try (final Connection connection = databaseConnectionDAO.getConnection();
             final Statement statement = connection.createStatement();
             final ResultSet empResultSet = statement.executeQuery(getLoanDetailsDao.getLoanData(id))) {

            if (empResultSet == null) {
                throw new LoanException("Invalid request");
            }
            if (empResultSet.next()) {
                return "";
            }
            else {
                throw new LoanException("Invalid email and/or password");
            }

        } catch (SQLException | DatabaseConnectionException sqlException) {
            sqlException.printStackTrace();
            throw new LoanException("Internal Error while fetching employee data");
        }

    }

}
