package com.bankingmanagement.bankingmanagement.card.serviceImplemenatation;

import com.bankingmanagement.bankingmanagement.card.database.NewCardRequestDao;
import com.bankingmanagement.bankingmanagement.card.exception.CardException;
import com.bankingmanagement.bankingmanagement.card.service.NewCardService;
import com.bankingmanagement.bankingmanagement.database.DatabaseConnectionDao;
import com.bankingmanagement.bankingmanagement.database.DatabaseConnectionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

@Service
public class NewCardServiceImpl implements NewCardService {
    @Autowired
    private DatabaseConnectionDao databaseConnectionDAO;

    @Autowired
    private NewCardRequestDao newCardRequestDao;

    @Override
    public boolean submitNewCardRequest(String customerId, String cardType) throws CardException {
        if(customerId==null || customerId.trim().isEmpty()) {
            throw new CardException("Please Login Again!");
        }
        if(cardType==null || cardType.isEmpty()) {
            throw new CardException("Please enter correct value for cardType");
        }
        try (final Connection connection = databaseConnectionDAO.getConnection();
             final Statement statement = connection.createStatement()) {
            String submitReqQuery = newCardRequestDao.submitNewCardRequestQuery(customerId,cardType);
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
            throw new CardException("Internal Error while new card request.");
        }
    }
}
