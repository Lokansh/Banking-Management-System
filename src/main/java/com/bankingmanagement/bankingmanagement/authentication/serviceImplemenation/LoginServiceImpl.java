package com.bankingmanagement.bankingmanagement.authentication.serviceImplemenation;

import com.bankingmanagement.bankingmanagement.authentication.exception.UserAuthenticationException;
import com.bankingmanagement.bankingmanagement.authentication.model.UserLogin;
import com.bankingmanagement.bankingmanagement.authentication.service.LoginService;
import com.bankingmanagement.bankingmanagement.database.DatabaseConnectionDao;
import com.bankingmanagement.bankingmanagement.database.DatabaseConnectionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bankingmanagement.bankingmanagement.authentication.database.LoginDao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.regex.Pattern;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import static com.bankingmanagement.bankingmanagement.authentication.database.LoginConstants.LOGIN_PASSWORD;

@Service
public class LoginServiceImpl implements LoginService {

    // Database connection instance.
    @Autowired
    private DatabaseConnectionDao databaseConnectionDAO;

    @Autowired
    private LoginDao loginDao;

    @Override
    public boolean validateUser(UserLogin userLogin) throws UserAuthenticationException {

        //validate userId and password against valid format/characters
        String userid = userLogin.getUserLoginID();
        String password = userLogin.getPassword();

        validateUserType(userid, password);
        try (
                final Connection connection = databaseConnectionDAO.getConnection();
                final Statement statement = connection.createStatement();
                final ResultSet userResultSet = statement.executeQuery(loginDao.selectUserByUsername(userid))) {

                    if (userResultSet == null) {
                        throw new UserAuthenticationException("Invalid email and/or password");
                    }
                    if (userResultSet.next()) {
                        final boolean isPasswordValid =
                                validateSHA256Hash(password, userResultSet.getString(LOGIN_PASSWORD));

                        //Mananamin@123
                        if (!isPasswordValid) {
                            throw new UserAuthenticationException("Invalid email and/or password");
                        }

        //               TODO: implement to check whether account is active or not using AcocuntStatusType Table
                        final boolean isAccountActive = true;
                        if (!isAccountActive) {
                            throw new UserAuthenticationException("Account not active");
                        }
                        return true;
                    }
                    else {
                        throw new UserAuthenticationException("Invalid email and/or password");
                    }
                } catch (SQLException | DatabaseConnectionException sqlException) {
                    sqlException.printStackTrace();
                    throw new UserAuthenticationException("Internal Error while validating user");
        }
    }

    private void validateUserType(String userid, String password) throws UserAuthenticationException {
        final boolean isUserValid = (userid != null) &&
                (!userid.trim().isEmpty()) && Pattern.matches("^[a-zA-Z0-9._-]{3,}$", userid);
        final boolean isUserPasswordValid = (password != null) &&
                (!password.trim().isEmpty()) && Pattern.matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,20}$",
                password);

        if (!isUserValid || !isUserPasswordValid) {
            throw new UserAuthenticationException("Invalid format of email and/or password");
        }
    }

    public boolean validateSHA256Hash(final String source,
                                             final String targetHash) {
        final String sourceHash = getSHA256Hash(source);
        if (sourceHash == null || targetHash == null) {
            return false;
        }
        return sourceHash.equals(targetHash);
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