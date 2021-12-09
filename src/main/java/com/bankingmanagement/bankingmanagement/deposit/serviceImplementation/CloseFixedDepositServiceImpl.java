package com.bankingmanagement.bankingmanagement.deposit.serviceImplementation;

import com.bankingmanagement.bankingmanagement.database.DatabaseConnectionDao;
import com.bankingmanagement.bankingmanagement.database.DatabaseConnectionException;
import com.bankingmanagement.bankingmanagement.deposit.database.CloseFixedDepositDao;
import com.bankingmanagement.bankingmanagement.deposit.exception.DepositException;
import com.bankingmanagement.bankingmanagement.deposit.model.CustomerAccount;
import com.bankingmanagement.bankingmanagement.deposit.model.Deposit;
import com.bankingmanagement.bankingmanagement.deposit.service.CloseFixedDepositService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import static com.bankingmanagement.bankingmanagement.deposit.database.DepositConstants.*;

@Service
public class CloseFixedDepositServiceImpl implements CloseFixedDepositService {
    @Autowired
    private DatabaseConnectionDao databaseConnectionDAO;

    @Autowired
    private CloseFixedDepositDao closeFixedDepositDao;

    @Override
    public List<Deposit> getAllDeposit(String customerId) throws DepositException {
        List<Deposit> allDeposits = new ArrayList<Deposit>();
        try (final Connection connection = databaseConnectionDAO.getConnection();
             final Statement statement = connection.createStatement()) {
            String getDepositDetails = closeFixedDepositDao.getAllDepositDetailsQuery(customerId);
            final ResultSet resultSet = statement.executeQuery(getDepositDetails);
            if (resultSet == null) {
                throw new DepositException("No data found with this user");
            } else {
                allDeposits = saveDataIntoDepositList(resultSet);
            }

        }catch (SQLException | DatabaseConnectionException sqlException) {
            sqlException.printStackTrace();
            throw new DepositException("Internal Error while fetching customer data");
        }
        return allDeposits;
    }

    @Override
    public List<Deposit> saveDataIntoDepositList(ResultSet requestResultSet) throws SQLException {
        List<Deposit> depositsList = new ArrayList<Deposit>();
        while (requestResultSet.next()) {
            Deposit req = new Deposit(requestResultSet.getString(DEPOSIT_ID),
                                        requestResultSet.getString(CUSTOMER_ID),
                                        requestResultSet.getString(AMOUNT),
                                        requestResultSet.getString(DEPOSIT_TYPE),
                                        requestResultSet.getString(TENURE),
                                        requestResultSet.getString(INTEREST),
                                        requestResultSet.getString(OPEN_DATE),
                                        requestResultSet.getString(MATURITY_DATE));
            depositsList.add(req);
        }
        return depositsList;
    }

    @Override
    public boolean liquidateDeposit(Deposit deposit, CustomerAccount customerAccount) throws DepositException {
        try (final Connection connection = databaseConnectionDAO.getConnection();
             final Statement statement = connection.createStatement()) {
            String closeFDQuery = closeFixedDepositDao.closeDeposit(deposit.getDepositId());
            System.out.println("closeFDQuery " + closeFDQuery);
            String updateCAQuery = closeFixedDepositDao.addBalanceToAccount(deposit, customerAccount);
            final int dataDeleted = statement.executeUpdate(closeFDQuery, Statement.RETURN_GENERATED_KEYS);
            System.out.println("updateCAQuery " + updateCAQuery);
            final int dataUpdated = statement.executeUpdate(updateCAQuery, Statement.RETURN_GENERATED_KEYS);

            if(dataDeleted > 0 && dataUpdated > 0){
                return true;
            }
            else{
                return false;
            }
        }
        catch (SQLException | DatabaseConnectionException sqlException) {
            sqlException.printStackTrace();
            throw new DepositException("Internal Error while fixed deposit liquidating.");
        }
    }

}
