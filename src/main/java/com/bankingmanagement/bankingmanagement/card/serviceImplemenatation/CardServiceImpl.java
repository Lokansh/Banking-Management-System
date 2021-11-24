package com.bankingmanagement.bankingmanagement.card.serviceImplemenatation;

import static com.bankingmanagement.bankingmanagement.card.database.CardConstants.LOGIN_PASSWORD;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.bankingmanagement.bankingmanagement.card.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;

import com.bankingmanagement.bankingmanagement.database.DatabaseConnectionDao;
import com.bankingmanagement.bankingmanagement.database.DatabaseConnectionException;
import org.springframework.beans.factory.annotation.Autowired;
import com.bankingmanagement.bankingmanagement.database.DatabaseConnectionException;
import com.bankingmanagement.bankingmanagement.card.database.CardDao;
import com.bankingmanagement.bankingmanagement.card.database.CardDaoImpl;
import com.bankingmanagement.bankingmanagement.card.exception.CardException;
import com.bankingmanagement.bankingmanagement.card.service.CardService;

//import javax.smartcardio.CardException;


public class CardServiceImpl implements CardService {
    @Autowired
    private DatabaseConnectionDao databaseConnectionDAO;

    @Autowired
    private CardDao cardsChequeBookDao;

    @Override
    public String getCardsDetails(String id) throws CardException {
        try (final Connection connection = databaseConnectionDAO.getConnection();
             final Statement statement = connection.createStatement();
             final ResultSet empResultSet = statement.executeQuery(cardsChequeBookDao.cardData(id))) {

            if (empResultSet == null) {
                throw new CardException("Invalid request");
            }
            if (empResultSet.next()) {
                return "";
            }
            else {
                throw new CardException("Invalid email and/or password");
            }

        } catch (SQLException | DatabaseConnectionException sqlException) {
            sqlException.printStackTrace();
            throw new CardException("Internal Error while fetching employee data");
        }

    }

}
