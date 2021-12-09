package com.bankingmanagement.bankingmanagement.card.serviceImplemenatation;

import com.bankingmanagement.bankingmanagement.card.database.ModifyLimitDao;
import com.bankingmanagement.bankingmanagement.card.exception.CardException;
import com.bankingmanagement.bankingmanagement.card.service.ModifyLimitService;
import com.bankingmanagement.bankingmanagement.database.DatabaseConnectionDao;
import com.bankingmanagement.bankingmanagement.database.DatabaseConnectionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static com.bankingmanagement.bankingmanagement.card.database.CardConstants.*;

@Service
public class ModifyLimitServiceImpl implements ModifyLimitService {
    @Autowired
    private DatabaseConnectionDao databaseConnectionDAO;

    @Autowired
    private ModifyLimitDao modifyLimitDao;

    @Override
    public String checkLimit(String customerId) throws CardException{
        String cardLimit = null;
        if(customerId==null || customerId.trim().isEmpty()) {
            throw new CardException("Please Login Again!");
        }
        try (final Connection connection = databaseConnectionDAO.getConnection();
             final Statement statement = connection.createStatement()) {
            String ccLimitQuery = modifyLimitDao.checkCardLimit(customerId);
            final ResultSet card = statement.executeQuery(ccLimitQuery);
            while (card.next()) {
                cardLimit= card.getString(CARD_LIMIT);
            }
            return cardLimit;
        }
        catch (SQLException | DatabaseConnectionException sqlException) {
            sqlException.printStackTrace();
            throw new CardException("Internal Error while Modify limit check");
        }
    }

    @Override
    public boolean modifyLimitRequest(String customerId, String cardNumber, String newLimit) throws CardException{
        if(customerId==null || customerId.trim().isEmpty()) {
            throw new CardException("Please Login Again!");
        }
        if(newLimit==null || newLimit.isEmpty()) {
            throw new CardException("Please enter new limit to update");
        }
        if(cardNumber==null || cardNumber.isEmpty()) {
            throw new CardException("Please enter Card Number");
        }
        try (final Connection connection = databaseConnectionDAO.getConnection();
             final Statement statement = connection.createStatement()) {
            String submitReqQuery = modifyLimitDao.modifyLimitQuery(customerId, cardNumber, newLimit);
            System.out.println("submitReqQuery" + submitReqQuery);
            final int dataUpdated = statement.executeUpdate(submitReqQuery, Statement.RETURN_GENERATED_KEYS);
            System.out.println("dataUpdated - " + dataUpdated);
            if(dataUpdated>0){
                System.out.println("Inside");
                return true;
            }
            else{
                return false;
            }
        }
        catch (SQLException | DatabaseConnectionException sqlException) {
            sqlException.printStackTrace();
            throw new CardException("Internal Error while Modify limit");
        }
    }
}
