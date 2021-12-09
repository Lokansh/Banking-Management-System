package com.bankingmanagement.bankingmanagement.deposit.serviceImplementation;

import com.bankingmanagement.bankingmanagement.database.DatabaseConnectionDao;
import com.bankingmanagement.bankingmanagement.database.DatabaseConnectionException;
import com.bankingmanagement.bankingmanagement.deposit.database.OpenFixedDepositDao;
import com.bankingmanagement.bankingmanagement.deposit.exception.DepositException;
import com.bankingmanagement.bankingmanagement.deposit.model.CustomerAccount;
import com.bankingmanagement.bankingmanagement.deposit.model.Deposit;
import com.bankingmanagement.bankingmanagement.deposit.service.OpenFixedDepositService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static com.bankingmanagement.bankingmanagement.deposit.database.DepositConstants.*;

@Service
public class OpenFixedDepositServiceImpl implements OpenFixedDepositService {
    @Autowired
    private DatabaseConnectionDao databaseConnectionDAO;

    @Autowired
    private OpenFixedDepositDao openFixedDepositDao;

    public static CustomerAccount customerAccount ;
    @Override
    public CustomerAccount getAccount(String customerId) throws DepositException {
        if(customerId==null || customerId.trim().isEmpty()) {
            throw new DepositException("Please Login Again!");
        }
        try (final Connection connection = databaseConnectionDAO.getConnection();
             final Statement statement = connection.createStatement()) {
            String getAccountDetails = openFixedDepositDao.getCustomerDetails(customerId);
            final ResultSet result = statement.executeQuery(getAccountDetails);
            while (result.next()) {
                customerAccount= new CustomerAccount(result.getString(CUSTOMER_ID),
                                                        result.getString(ACCOUNT_ID),
                                                        result.getString(BALANCE));
            }
            return customerAccount;
        }
        catch (SQLException | DatabaseConnectionException sqlException) {
            sqlException.printStackTrace();
            throw new DepositException("Internal Error while getting account details");
        }
    }

    @Override
    public boolean fdRequest(Deposit deposit, CustomerAccount customerAccount) throws DepositException {
        try (final Connection connection = databaseConnectionDAO.getConnection();
             final Statement statement = connection.createStatement()) {
            String openFDQuery = openFixedDepositDao.openFixedDepositQuery(deposit);
            System.out.println("openFDQuery " + openFDQuery);
            String updateCAQuery = openFixedDepositDao.deductBalanceFromCustomerAccount(deposit, customerAccount);
            final int dataInserted = statement.executeUpdate(openFDQuery, Statement.RETURN_GENERATED_KEYS);
            System.out.println("updateCAQuery " + updateCAQuery);
            final int dataUpdated = statement.executeUpdate(updateCAQuery, Statement.RETURN_GENERATED_KEYS);
            if(dataInserted > 0 && dataUpdated > 0){
                return true;
            }
            else{
                return false;
            }
        }
        catch (SQLException | DatabaseConnectionException sqlException) {
            sqlException.printStackTrace();
            throw new DepositException("Internal Error while fixed deposit opening.");
        }
    }

}
