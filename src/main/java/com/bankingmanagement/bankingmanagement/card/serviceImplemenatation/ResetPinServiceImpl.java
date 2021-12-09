package com.bankingmanagement.bankingmanagement.card.serviceImplemenatation;

import com.bankingmanagement.bankingmanagement.card.database.ResetPinDao;
import com.bankingmanagement.bankingmanagement.card.exception.CardException;
import com.bankingmanagement.bankingmanagement.card.service.ResetPinService;
import com.bankingmanagement.bankingmanagement.database.DatabaseConnectionDao;
import com.bankingmanagement.bankingmanagement.database.DatabaseConnectionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

@Service
public class ResetPinServiceImpl implements ResetPinService {
    @Autowired
    private DatabaseConnectionDao databaseConnectionDAO;

    @Autowired
    private ResetPinDao resetPinDao;

    @Override
    public boolean resetPinRequest(String customerId, String cardNumber, String cardPin) throws CardException{
        if(customerId==null || customerId.trim().isEmpty()) {
            throw new CardException("Please Login Again!");
        }
        if(cardPin==null || cardPin.isEmpty()) {
            throw new CardException("Please enter new 4 digit pin");
        }
        if(cardNumber==null || cardNumber.isEmpty()) {
            throw new CardException("Please enter Card Number");
        }
        try (final Connection connection = databaseConnectionDAO.getConnection();
             final Statement statement = connection.createStatement()) {
            String submitReqQuery = resetPinDao.resetPinQuery(customerId, cardNumber, cardPin);
            final int dataUpdated = statement.executeUpdate(submitReqQuery, Statement.RETURN_GENERATED_KEYS);

            if(dataUpdated>0){
                return true;
            }
            else{
                return false;
            }
        }
        catch (SQLException | DatabaseConnectionException sqlException) {
            sqlException.printStackTrace();
            throw new CardException("Internal Error while card,");
        }
    }
}
