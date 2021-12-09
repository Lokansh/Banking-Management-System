package com.bankingmanagement.bankingmanagement.card.serviceImplemenatation;

import com.bankingmanagement.bankingmanagement.card.database.BlockCardRequestDao;
import com.bankingmanagement.bankingmanagement.card.exception.CardException;
import com.bankingmanagement.bankingmanagement.card.service.BlockCardService;
import com.bankingmanagement.bankingmanagement.database.DatabaseConnectionDao;
import com.bankingmanagement.bankingmanagement.database.DatabaseConnectionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Connection;

import java.sql.SQLException;
import java.sql.Statement;

@Service
public class BlockCardServiceImpl implements BlockCardService {
    @Autowired
    private DatabaseConnectionDao databaseConnectionDAO;

    @Autowired
    private BlockCardRequestDao blockCardRequestDao;

    @Override
    public boolean submitBlockCardRequest(String customerId, String cardNumber,String cardType) throws CardException {
        if(customerId==null || customerId.trim().isEmpty()) {
            throw new CardException("Please Login Again!");
        }
        if(cardType==null || cardType.isEmpty()) {
            throw new CardException("Please enter correct value for cardType");
        }
        if(cardNumber==null || cardNumber.isEmpty()) {
            throw new CardException("Please enter Card Number");
        }
        try (final Connection connection = databaseConnectionDAO.getConnection();
             final Statement statement = connection.createStatement()) {
            String submitReqQuery = blockCardRequestDao.submitBlockCardRequestQuery(customerId,cardType);
            final int dataInserted = statement.executeUpdate(submitReqQuery, Statement.RETURN_GENERATED_KEYS);
            String blockCardQuery = blockCardRequestDao.blockCard(customerId,cardNumber);

            if(dataInserted>0){
                final int cardBlocked = statement.executeUpdate(blockCardQuery, Statement.RETURN_GENERATED_KEYS);
                if(cardBlocked>0) {
                    return true;
                }
                else{
                    return false;
                }
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
