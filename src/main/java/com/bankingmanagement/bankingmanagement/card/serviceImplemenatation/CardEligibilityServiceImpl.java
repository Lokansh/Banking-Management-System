package com.bankingmanagement.bankingmanagement.card.serviceImplemenatation;

import com.bankingmanagement.bankingmanagement.card.database.CardEligibilityCheckDao;
import com.bankingmanagement.bankingmanagement.card.exception.CardException;
import com.bankingmanagement.bankingmanagement.card.model.CreditScore;
import com.bankingmanagement.bankingmanagement.card.service.CardEligibilityService;
import com.bankingmanagement.bankingmanagement.database.DatabaseConnectionDao;
import com.bankingmanagement.bankingmanagement.database.DatabaseConnectionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

@Service
public class CardEligibilityServiceImpl implements CardEligibilityService {
    @Autowired
    private DatabaseConnectionDao databaseConnectionDAO;

    @Autowired
    private CardEligibilityCheckDao cardEligibilityCheckDao;

    private static CreditScore creditScore;

    @Override
    public CreditScore checkCreditScore(String customerId, String sin) throws CardException{
        if(customerId==null || customerId.trim().isEmpty()) {
            throw new CardException("Please Login Again!");
        }
        if(sin==null || sin.trim().isEmpty()) {
            throw new CardException("Please enter a SIN number");
        }
        try (final Connection connection = databaseConnectionDAO.getConnection();
             final Statement statement = connection.createStatement()) {
            String fetchCreditScoreQuery = cardEligibilityCheckDao.checkEligibilityQuery(customerId, sin);
            final ResultSet score = statement.executeQuery(fetchCreditScoreQuery);
            while (score.next()) {
                creditScore = new CreditScore(score.getString("customerID"),score.getString("sin")
                        ,score.getString("Credit_Score"),score.getString("Last_Update"));
            }
            return creditScore;
        }
        catch (SQLException | DatabaseConnectionException sqlException) {
            sqlException.printStackTrace();
            throw new CardException("Internal Error while credit card eligibility check,");
        }
    }
}
