package com.bankingmanagement.bankingmanagement.authentication.service_implementation;

import com.bankingmanagement.bankingmanagement.authentication.database.LoginDao;
import com.bankingmanagement.bankingmanagement.authentication.exception.InvalidRoleException;
import com.bankingmanagement.bankingmanagement.authentication.exception.UserAuthenticationException;
import com.bankingmanagement.bankingmanagement.authentication.model.UserLogin;
import com.bankingmanagement.bankingmanagement.authentication.service.LoginService;
import com.bankingmanagement.bankingmanagement.database.DatabaseConnectionDao;
import com.bankingmanagement.bankingmanagement.database.DatabaseConnectionException;
import com.bankingmanagement.bankingmanagement.util.HashAlgorithm;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

import static com.bankingmanagement.bankingmanagement.authentication.database.LoginConstants.*;

@Service("loginService")
public class LoginServiceImpl implements LoginService {

    // Database connection instance.
    private final DatabaseConnectionDao databaseConnectionDAO;
    private final LoginDao loginDao;

    public LoginServiceImpl(DatabaseConnectionDao databaseConnectionDAO, LoginDao loginDao) {
        this.databaseConnectionDAO = databaseConnectionDAO;
        this.loginDao = loginDao;
    }

    @Override
    public boolean validateUser(UserLogin userLogin) throws UserAuthenticationException, InvalidRoleException {

        //validate userId and password against valid format/characters
        String userid = userLogin.getUserLoginID();
        String password = userLogin.getPassword();
        String role =userLogin.getRole();
        int failedAttempt;

        validateUserType(userid, password);
        try (
                final Connection connection = databaseConnectionDAO.getConnection();
                final Statement statement = connection.createStatement();
                final ResultSet userResultSet = statement.executeQuery(loginDao.selectUserByUsername(userid))) {

                    if (userResultSet.next()) {
                        failedAttempt = userResultSet.getInt(LOGIN_FAILED_ATTEMPT);
                        String time=userResultSet.getString(LOGIN_BLOCK_TIMESTAMP);
                        String expectedRole = userResultSet.getString(LOGIN_ROLE_TYPE);

                        validateUserRole(role,expectedRole);

                        if(time!=null) {
                            SimpleDateFormat simpleDateformat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss", Locale.ENGLISH);

                            Date blockedTime = simpleDateformat.parse(time);
                            Date currentTime = new Date();
                            long diffInMilliseconds = Math.abs(currentTime.getTime() - blockedTime.getTime());
                            long hours = TimeUnit.HOURS.convert(diffInMilliseconds, TimeUnit.MILLISECONDS);

                            if (hours < 24) {
                                throw new UserAuthenticationException("Username blocked, try again after " + (24 - hours) + " hours or reset the password.");
                            }
                        }

                        final boolean isPasswordValid =
                                HashAlgorithm.validateSHA256Hash(password, userResultSet.getString(LOGIN_PASSWORD));

                        if (!isPasswordValid) {
                            failedAttempt+=1;
                            if(failedAttempt==3){
                                java.util.Date dateTime = new java.util.Date();
                                java.text.SimpleDateFormat simpleDateFormat = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

                                String curTime = simpleDateFormat.format(dateTime);
                                String datetimeQuery= loginDao.storeDatetimeQuery(userid,curTime);
                                final int customerFinalRowInserted = statement.executeUpdate(datetimeQuery);

                                if(customerFinalRowInserted>0){
                                    throw new UserAuthenticationException("Username blocked for 24 hours due to 3 consecutive wrong password attempts");
                                }
                            }
                            else {
                                String failedAttemptQuery= loginDao.storeFailedAttemptQuery(userid,failedAttempt);
                                statement.executeUpdate(failedAttemptQuery);
                                throw new UserAuthenticationException("Invalid username and/or password");
                            }
                        }
                        else {
                            String failedAttemptQuery= loginDao.storeFailedAttemptQuery(userid,0);
                            statement.executeUpdate(failedAttemptQuery);
                            return true;
                        }
                    }
                    else {
                        throw new UserAuthenticationException("Invalid username and/or password");
                    }
                } catch (SQLException | DatabaseConnectionException | ParseException sqlException) {
                    sqlException.printStackTrace();
                    throw new UserAuthenticationException("Internal Error while validating user");
        }
        return false;
    }

    @Override
    public void logout(String username) throws UserAuthenticationException {
        final boolean isUserValid = (username != null) &&
                                            (!username.trim().isEmpty()) && Pattern.matches("^[a-zA-Z0-9._-]{3,}$", username);
        if(!isUserValid){
            throw new UserAuthenticationException("Invalid username");
        }
    }

    private void validateUserRole(String role, String expectedRole) throws InvalidRoleException {
        if(expectedRole==null){
            throw new InvalidRoleException("Role does not have access to this page.");
        }
        if(role.equals(USER_ROLE)&&!expectedRole.equals(USER_ROLE_TYPE)|| role.equals(ADMIN_ROLE)&&!expectedRole.equals(ADMIN_ROLE_TYPE) || !role.equals(EMPLOYEE_ROLE)&&expectedRole.equals(EMPLOYEE_ROLE_TYPE)){
            throw new InvalidRoleException("Role does not have access to this page.");
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

}