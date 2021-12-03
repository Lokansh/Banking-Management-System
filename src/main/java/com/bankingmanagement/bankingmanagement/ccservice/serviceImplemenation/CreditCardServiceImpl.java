package com.bankingmanagement.bankingmanagement.ccservice.serviceImplemenation;

import com.bankingmanagement.bankingmanagement.ccservice.database.CCDao;
import com.bankingmanagement.bankingmanagement.ccservice.exception.CreditCardException;
import com.bankingmanagement.bankingmanagement.ccservice.model.CreditCardInfo;
import com.bankingmanagement.bankingmanagement.ccservice.service.CreditCardService;
import com.bankingmanagement.bankingmanagement.database.DatabaseConnectionDao;
import com.bankingmanagement.bankingmanagement.database.DatabaseConnectionException;
import com.bankingmanagement.bankingmanagement.loan.model.LoanInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


@Service
public class CreditCardServiceImpl implements CreditCardService {
    @Autowired
    private DatabaseConnectionDao databaseConnectionDAO;
    @Autowired
    private CCDao ccDao;

    private static List<CreditCardInfo> ccList = new ArrayList<CreditCardInfo>();


    @Override
    public List<CreditCardInfo> getCCList(String userId) throws CreditCardException {
        ccList.clear();
        if(userId==null || userId.trim().isEmpty()) {
            throw new CreditCardException("Please Login Again to fetch details");
        }
        try (final Connection connection = databaseConnectionDAO.getConnection();
             final Statement statement = connection.createStatement())
        {
            String fetchAllCCQuery = ccDao.fetchAllCCTableQuery(userId);
            final ResultSet allCC = statement.executeQuery(fetchAllCCQuery);
            if (allCC == null) {
                return null;
            }
            while (allCC.next()) {
                CreditCardInfo cc=new CreditCardInfo(allCC.getString("CustomerID"),
                        allCC.getString("CardNumber"),
                        allCC.getString("CardType"),
                        allCC.getBoolean("CardStatus"),
                        allCC.getString("CardLimit"));
                ccList.add(cc);
            }
            return ccList;
        }catch (SQLException | DatabaseConnectionException sqlException) {
            sqlException.printStackTrace();
            throw new CreditCardException("Internal Error while loan,");
        }
    }
}