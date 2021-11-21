package com.bankingmanagement.bankingmanagement.signup.serviceImplemenation;

import com.bankingmanagement.bankingmanagement.authentication.model.UserLogin;
import com.bankingmanagement.bankingmanagement.signup.exception.UserRegistrationException;
import com.bankingmanagement.bankingmanagement.signup.model.Customer;
import com.bankingmanagement.bankingmanagement.signup.model.SecurityAnswer;
import com.bankingmanagement.bankingmanagement.signup.model.UserInfo;
import com.bankingmanagement.bankingmanagement.signup.service.RegistrationService;
import com.bankingmanagement.bankingmanagement.database.DatabaseConnectionDao;
import com.bankingmanagement.bankingmanagement.database.DatabaseConnectionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bankingmanagement.bankingmanagement.signup.database.RegisterDao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.regex.Pattern;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Service
public class RegistrationServiceImpl implements RegistrationService {

    // Database connection instance.
    @Autowired
    private DatabaseConnectionDao databaseConnectionDAO;

    @Autowired
    private RegisterDao registerDao;

    @Override
    public String registerUser(UserInfo userInfo) throws UserRegistrationException {
        Customer customer = userInfo.getCustomer();
        validateUser(customer);
        String username = customer.getCustomerID();
        UserLogin userLogin = userInfo.getUserLogin();
        String rawPassword = userLogin.getPassword();

        //validating username and password
        validatUserLogin(username,rawPassword);

        SecurityAnswer securityAnswer = userInfo.getSecurityAnswer();
        int questionID = securityAnswer.getQuestionID();
        String secAnswer = securityAnswer.getQuestionAnswer();
        //validating security ques and answer
        validateSecurityAnswer(questionID,secAnswer);

        String password = getSHA256Hash(userLogin.getPassword());

        try (final Connection connection = databaseConnectionDAO.getConnection();
             final Statement statement = connection.createStatement()) {

                final String insertCustomerQuery = registerDao.insertUserTableQuery(customer);
                final int customerRowInserted = statement.executeUpdate(insertCustomerQuery, Statement.RETURN_GENERATED_KEYS);
                if (customerRowInserted > 0) {

                    final String securityQuestionQuery = registerDao.insertSecurityQuestionTableQuery(username,questionID,secAnswer);
                        final int userQARowsInserted = statement.executeUpdate(securityQuestionQuery);
                        if (userQARowsInserted > 0) {
                            final String loginInfoQuery = registerDao.insertLoginTableQuery(username,password);
                            final int customerfinalRowInserted = statement.executeUpdate(loginInfoQuery, Statement.RETURN_GENERATED_KEYS);

                            if (customerfinalRowInserted!=0){
                                return username;
                            }
                            throw new UserRegistrationException("Error While registration");
                    }
                }
                } catch (SQLException | DatabaseConnectionException sqlException) {
            //      TODO handle database incosientancy while insering data
                    sqlException.printStackTrace();
                    throw new UserRegistrationException("Internal Error while Registration, try with new username");
        }
        throw new UserRegistrationException("Error While registration");
    }


    private void validateSecurityAnswer(int questionID,String securityAnswer) throws UserRegistrationException {
        if(questionID==0){
            throw new UserRegistrationException("Select Security Question ");
        }
        if(securityAnswer==null || securityAnswer.trim().isEmpty() ){
            throw new UserRegistrationException("Security Answer is empty ");
        }
    }

    private void validateUser(Customer customer) throws UserRegistrationException {
        String firstName = customer.getFirstName();

        if(firstName==null || firstName.trim().isEmpty() || !Pattern.matches("[A-Za-z ]+", firstName)){
            throw new UserRegistrationException("FirstName is empty or Invalid ");
        }
        String lastName = customer.getLastName();

        if(lastName==null || lastName.trim().isEmpty() || !Pattern.matches("[A-Za-z ]+", lastName)){
            throw new UserRegistrationException("LastName is empty or Invalid ");
        }

        String address1 = customer.getAddress1();

        if(address1==null || address1.trim().isEmpty()){
            throw new UserRegistrationException("Address1 is empty ");
        }

        String address2 = customer.getAddress2();

        if(address2==null || address2.trim().isEmpty()){
            throw new UserRegistrationException("Address2 is empty ");
        }

        String email = customer.getEmail();

        if(email==null || email.trim().isEmpty() || !Pattern.matches("^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,}$",
                email)){
            throw new UserRegistrationException("Email is empty or Invalid ");
        }

        String userName = customer.getCustomerID();

        if(userName==null || userName.trim().isEmpty() || !Pattern.matches("^[a-zA-Z0-9._-]{3,}$", userName)){
            throw new UserRegistrationException("username is empty or Invalid ");
        }

        String city = customer.getCity();

        if(city==null || city.trim().isEmpty() || !Pattern.matches("[A-Za-z ]+", city)){
            throw new UserRegistrationException("City is empty or Invalid ");
        }

        String zipCode = customer.getZipCode();

        if(zipCode==null || zipCode.trim().isEmpty() || !Pattern.matches("^\\d{5}(?:[-\\s]\\d{4})?$", zipCode)){
            throw new UserRegistrationException("Zipcode is empty or Invalid ");
        }

        String contactNumber = customer.getContactNumber();

        if(contactNumber==null || contactNumber.trim().isEmpty()){
            throw new UserRegistrationException("ContactNumber is empty  ");
        }

        //TODO : update sin to string regex: ^(\d{3}-\d{3}-\d{3})|(\d{9})$
        int sin = customer.getSin();

    }

    private void validatUserLogin(String userid, String password) throws UserRegistrationException {
        final boolean isUserValid = (userid != null) &&
                (!userid.trim().isEmpty()) && Pattern.matches("^[a-zA-Z0-9._-]{3,}$", userid);

        if(!isUserValid){
            throw new UserRegistrationException("Invalid format of username");
        }

        final boolean isUserPasswordValid = (password != null) &&
                (!password.trim().isEmpty()) && Pattern.matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,20}$",
                password);

        if (!isUserPasswordValid) {
            throw new UserRegistrationException("Invalid format of password");
        }
    }

    // ToDO : Add commmon util method to avoid code duplication
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