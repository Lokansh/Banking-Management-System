package com.bankingmanagement.bankingmanagement.signup.service_implementation;

import com.bankingmanagement.bankingmanagement.database.DatabaseConnectionDao;
import com.bankingmanagement.bankingmanagement.database.DatabaseConnectionException;
import com.bankingmanagement.bankingmanagement.signup.database.ForgetDao;
import com.bankingmanagement.bankingmanagement.signup.exception.NewPasswordException;
import com.bankingmanagement.bankingmanagement.signup.service.NewPasswordService;
import com.bankingmanagement.bankingmanagement.util.HashAlgorithm;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.regex.Pattern;

@Service
public class NewPasswordServiceImpl implements NewPasswordService {

    private final DatabaseConnectionDao databaseConnectionDAO;

    private final ForgetDao forgetDao;

    public NewPasswordServiceImpl(DatabaseConnectionDao databaseConnectionDAO, ForgetDao forgetDao) {
        this.databaseConnectionDAO = databaseConnectionDAO;
        this.forgetDao = forgetDao;
    }

    @Override
    public String saveNewPassword(String username,String password) throws NewPasswordException {

        validatePassword(password);
        String passwordHash= HashAlgorithm.getSHA256Hash(password);
        try (final Connection connection = databaseConnectionDAO.getConnection();
             final Statement statement = connection.createStatement()) {

            final int customerFinalRowInserted = statement.executeUpdate(forgetDao.updatePasswordQuery(username,passwordHash), Statement.RETURN_GENERATED_KEYS);
            if (customerFinalRowInserted>0){
                return username;
            }
            throw new NewPasswordException("Error while saving new password");
        }
        catch (SQLException | DatabaseConnectionException sqlException) {
            sqlException.printStackTrace();
            throw new NewPasswordException("Error while saving new password");
        }
    }

    private void validatePassword(String password) throws NewPasswordException {
        final boolean isUserPasswordValid = (password != null) &&
                (!password.trim().isEmpty()) && Pattern.matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,20}$",
                password);
        if (!isUserPasswordValid) {
            throw new NewPasswordException("Invalid format of password");
        }
    }

}
