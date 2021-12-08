package com.bankingmanagement.bankingmanagement.ccservice.serviceImplemenation;
import com.bankingmanagement.bankingmanagement.ccservice.database.CCDao;
import com.bankingmanagement.bankingmanagement.ccservice.exception.CreditCardException;
import com.bankingmanagement.bankingmanagement.ccservice.model.CreditCardInfo;
import com.bankingmanagement.bankingmanagement.ccservice.model.CreditScoreInfo;
import com.bankingmanagement.bankingmanagement.ccservice.service.CreditCardService;
import com.bankingmanagement.bankingmanagement.database.DatabaseConnectionDao;
import com.bankingmanagement.bankingmanagement.database.DatabaseConnectionException;
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
    private static CreditScoreInfo creditscore;

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
                        allCC.getString("CardLimit"),
                        allCC.getString("CardCurrentLimit"),
                        allCC.getString("CardCurrentOverdue"));
                ccList.add(cc);
            }
            return ccList;
        }catch (SQLException | DatabaseConnectionException sqlException) {
            sqlException.printStackTrace();
            throw new CreditCardException("Internal Error while loan,");
        }
    }

    @Override
    public CreditScoreInfo getCreditScore(String sin) throws CreditCardException {
        if(sin==null || sin.trim().isEmpty()) {
            throw new CreditCardException("Please Enter a Sin number");
        }
        try (final Connection connection = databaseConnectionDAO.getConnection();
             final Statement statement = connection.createStatement()) {
            String fetchCreditScoreQuery = ccDao.fetchCreditScoreQuery(sin);
            final ResultSet score = statement.executeQuery(fetchCreditScoreQuery);
            while (score.next()) {
                 creditscore= new CreditScoreInfo(score.getString("customerID"),score.getString("sin")
                        ,score.getString("Credit_Score"),score.getString("Last_Update"));
            }
            return creditscore;
        }
        catch (SQLException | DatabaseConnectionException sqlException) {
            sqlException.printStackTrace();
            throw new CreditCardException("Internal Error while loan,");
        }
    }

    @Override
    public String getCreditCardLimit(String userId) throws CreditCardException {
        String limit = null;
        if(userId==null || userId.trim().isEmpty()) {
            throw new CreditCardException("Please Login Again!! ");
        }
        try (final Connection connection = databaseConnectionDAO.getConnection();
             final Statement statement = connection.createStatement()) {
            String ccLimitQuery = ccDao.fetchAllCCTableQuery(userId);
            final ResultSet score = statement.executeQuery(ccLimitQuery);
            while (score.next()) {
                 limit= score.getString("CardLimit");
            }
            return limit;
        }
        catch (SQLException | DatabaseConnectionException sqlException) {
            sqlException.printStackTrace();
            throw new CreditCardException("Internal Error while loan,");
        }
    }

    @Override
    public String getSalary(String userId) throws CreditCardException {
        String salary = null;
        if(userId==null || userId.trim().isEmpty()) {
            throw new CreditCardException("Please Login Again!! ");
        }
        try (final Connection connection = databaseConnectionDAO.getConnection();
             final Statement statement = connection.createStatement()) {
            String submitReqQuery = ccDao.getOldSalary(userId);
            final ResultSet sal = statement.executeQuery(submitReqQuery);
            while (sal.next()) {
                salary= sal.getString("Salary");
            }
        }
        catch (SQLException | DatabaseConnectionException sqlException) {
            sqlException.printStackTrace();
            throw new CreditCardException("Internal Error while loan,");
        }
        return salary;
    }

    @Override
    public boolean submitRequest(String userId,String salary) throws CreditCardException{
        if(userId==null || userId.trim().isEmpty()) {
            throw new CreditCardException("Please Login Again!! ");
        }
        if(salary==null || salary.trim().isEmpty()||salary=="0") {
            throw new CreditCardException("Please enter valid salary ");
        }
        try (final Connection connection = databaseConnectionDAO.getConnection();
             final Statement statement = connection.createStatement()) {
            if(checkCustCC(userId))
            {
                String submitReqQuery = ccDao.submitCCIncReqQuery(userId,salary);
                final int RowInserted = statement.executeUpdate(submitReqQuery, Statement.RETURN_GENERATED_KEYS);
                if(RowInserted>0) {
                    return true;
                }
            }
            else {
                throw new CreditCardException("No Credit Card linked with this User,");
            }
        }
        catch (SQLException | DatabaseConnectionException sqlException) {
            sqlException.printStackTrace();
            throw new CreditCardException("Internal Error while loan,");
        }
        return false;
    }

    @Override
    public boolean checkCustCC(String userId) throws CreditCardException
    {
        if(userId==null || userId.trim().isEmpty())
        {
            throw new CreditCardException("Please Login Again!! ");
        }
        List<CreditCardInfo> list=getCCList(userId);
        if(list.isEmpty())
        {
            return false;
        }

        return true;
    }
}