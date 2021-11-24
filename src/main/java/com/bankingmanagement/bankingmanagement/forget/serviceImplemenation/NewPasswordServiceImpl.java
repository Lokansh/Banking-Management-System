package com.bankingmanagement.bankingmanagement.forget.serviceImplemenation;

import com.bankingmanagement.bankingmanagement.database.DatabaseConnectionDao;
import com.bankingmanagement.bankingmanagement.database.DatabaseConnectionException;
import com.bankingmanagement.bankingmanagement.forget.database.ForgetDao;
import com.bankingmanagement.bankingmanagement.forget.exception.NewPasswordException;
import com.bankingmanagement.bankingmanagement.forget.service.NewPasswordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.regex.Pattern;

@Service
public class NewPasswordServiceImpl implements NewPasswordService {

    @Autowired
    private DatabaseConnectionDao databaseConnectionDAO;

    @Autowired
    private ForgetDao forgetDao;

    @Override
    public String saveNewPassword(String username,String password) throws NewPasswordException {

        validatePassword(password);
        String passwordHash= getSHA256Hash(password);

        try (final Connection connection = databaseConnectionDAO.getConnection();
             final Statement statement = connection.createStatement()) {

            final int customerfinalRowInserted = statement.executeUpdate(forgetDao.updatePasswordQuery(username,passwordHash), Statement.RETURN_GENERATED_KEYS);
            if (customerfinalRowInserted>0){
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

    public String getSHA256Hash(final String str) {
        if (str == null) {
            return null;
        }
        try {
            final MessageDigest messageDigest =
                    MessageDigest.getInstance("SHA-256");
            return String.format("%064x",
                    new BigInteger(1,
                            messageDigest.digest(str.getBytes(StandardCharsets.UTF_8))));
        } catch (final NoSuchAlgorithmException e) {
            return null;
        }
    }
}
