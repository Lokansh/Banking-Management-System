package com.bankingmanagement.bankingmanagement.signup.service_implementation;

import com.bankingmanagement.bankingmanagement.database.DatabaseConnectionDao;
import com.bankingmanagement.bankingmanagement.database.DatabaseConnectionException;
import com.bankingmanagement.bankingmanagement.signup.database.ForgetDao;
import com.bankingmanagement.bankingmanagement.signup.exception.UserForgetPasswordException;
import com.bankingmanagement.bankingmanagement.signup.model.SecurityAnswer;
import com.bankingmanagement.bankingmanagement.signup.service.ForgetPasswordService;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static com.bankingmanagement.bankingmanagement.signup.database.SecurityConstants.SECURITY_ANSWER;
import static com.bankingmanagement.bankingmanagement.signup.database.SecurityConstants.SECURITY_QUESTION_ID;


@Service
public class ForgetPasswordServiceImpl implements ForgetPasswordService {

    private final DatabaseConnectionDao databaseConnectionDAO;

    private final ForgetDao forgetDao;

    public ForgetPasswordServiceImpl(DatabaseConnectionDao databaseConnectionDAO, ForgetDao forgetDao) {
        this.databaseConnectionDAO = databaseConnectionDAO;
        this.forgetDao = forgetDao;
    }

    @Override
    public String handleForgetPassword(SecurityAnswer securityAnswer) throws UserForgetPasswordException {

        validateSecurityAnswer(securityAnswer);

        int actualQuestionID =securityAnswer.getQuestionID();
        String actualAnswer = securityAnswer.getQuestionAnswer().trim();
        String userID = securityAnswer.getUserLoginID();

        try (final Connection connection = databaseConnectionDAO.getConnection();
             final Statement statement = connection.createStatement()) {

            final ResultSet userResultSet = statement.executeQuery(forgetDao.getSecurityQuestionQuery(userID));
            if(userResultSet.next()){
                int expectedQuestionID = userResultSet.getInt(SECURITY_QUESTION_ID);
                String expectedAnswer = userResultSet.getString(SECURITY_ANSWER).trim();

                if(expectedQuestionID==actualQuestionID && expectedAnswer.equals(actualAnswer)){
                    return userID;
                }
            }
            throw new UserForgetPasswordException("Invalid Security Question or Answer or username");

        } catch (SQLException | DatabaseConnectionException | UserForgetPasswordException throwable) {
            throwable.printStackTrace();
            throw new UserForgetPasswordException("Invalid Security Question or Answer or username");
        }

    }

    private void validateSecurityAnswer(SecurityAnswer securityAnswer) throws UserForgetPasswordException {
        if(securityAnswer.getQuestionID()>5||securityAnswer.getQuestionID()<0){
            throw new UserForgetPasswordException("Select Security Question ");
        }
        String secAnswer = securityAnswer.getQuestionAnswer();
        if(secAnswer==null || secAnswer.trim().isEmpty() ){
            throw new UserForgetPasswordException("Security Answer is empty.");
        }
    }


}