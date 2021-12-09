package com.bankingmanagement.bankingmanagement.chequebook.serviceImplementation;

import com.bankingmanagement.bankingmanagement.chequebook.database.NewChequeBookRequestDao;
import com.bankingmanagement.bankingmanagement.chequebook.exception.ChequeBookException;
import com.bankingmanagement.bankingmanagement.chequebook.service.NewChequeBookService;
import com.bankingmanagement.bankingmanagement.database.DatabaseConnectionDao;
import com.bankingmanagement.bankingmanagement.database.DatabaseConnectionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

@Service
public class NewChequeBookServiceImpl implements NewChequeBookService {
    @Autowired
    private DatabaseConnectionDao databaseConnectionDAO;

    @Autowired
    private NewChequeBookRequestDao newChequeBookRequestDao;

    @Override
    public boolean submitNewChequeRequest(String customerId) throws ChequeBookException{
        if(customerId==null || customerId.trim().isEmpty()) {
            throw new ChequeBookException("Please Login Again!");
        }
        try (final Connection connection = databaseConnectionDAO.getConnection();
             final Statement statement = connection.createStatement()) {
            String submitReqQuery = newChequeBookRequestDao.submitNewChequeRequestQuery(customerId);
            final int dataInserted = statement.executeUpdate(submitReqQuery, Statement.RETURN_GENERATED_KEYS);

            if(dataInserted>0){
                return true;
            }
            else{
                return false;
            }
        }
        catch (SQLException | DatabaseConnectionException sqlException) {
            sqlException.printStackTrace();
            throw new ChequeBookException("Internal Error while new chequebook request");
        }
    }
}
