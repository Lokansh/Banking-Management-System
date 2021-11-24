package com.bankingmanagement.bankingmanagement.cardsChequebook.serviceImplemenatation;

import static com.bankingmanagement.bankingmanagement.cardsChequebook.database.CardsChequeBookConstants.LOGIN_PASSWORD;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.bankingmanagement.bankingmanagement.cardsChequebook.service.CardsChequeBookService;
import org.springframework.beans.factory.annotation.Autowired;

import com.bankingmanagement.bankingmanagement.database.DatabaseConnectionDao;
import com.bankingmanagement.bankingmanagement.database.DatabaseConnectionException;
import org.springframework.beans.factory.annotation.Autowired;
import com.bankingmanagement.bankingmanagement.database.DatabaseConnectionException;
import com.bankingmanagement.bankingmanagement.cardsChequebook.database.CardsChequeBookDao;
import com.bankingmanagement.bankingmanagement.cardsChequebook.database.CardsChequeBookDaoImpl;
import com.bankingmanagement.bankingmanagement.cardsChequebook.exception.CardsChequeBookException;
import com.bankingmanagement.bankingmanagement.cardsChequebook.service.CardsChequeBookService;

//import javax.smartcardio.CardException;


public class CardsChequeBookServiceImpl implements CardsChequeBookService {
    @Autowired
    private DatabaseConnectionDao databaseConnectionDAO;

    @Autowired
    private CardsChequeBookDao cardsChequeBookDao;

    @Override
    public String getCardsDetails(String id) throws CardsChequeBookException {
        try (final Connection connection = databaseConnectionDAO.getConnection();
             final Statement statement = connection.createStatement();
             final ResultSet empResultSet = statement.executeQuery(cardsChequeBookDao.cardsChequeBookData(id))) {

            if (empResultSet == null) {
                throw new CardsChequeBookException("Invalid request");
            }
            if (empResultSet.next()) {
                return "";
            }
            else {
                throw new CardsChequeBookException("Invalid email and/or password");
            }

        } catch (SQLException | DatabaseConnectionException sqlException) {
            sqlException.printStackTrace();
            throw new CardsChequeBookException("Internal Error while fetching employee data");
        }

    }

}
