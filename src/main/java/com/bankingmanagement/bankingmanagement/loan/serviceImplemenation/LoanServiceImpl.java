package com.bankingmanagement.bankingmanagement.loan.serviceImplemenation;

import com.bankingmanagement.bankingmanagement.database.DatabaseConnectionDao;
import com.bankingmanagement.bankingmanagement.database.DatabaseConnectionException;

import com.bankingmanagement.bankingmanagement.loan.database.LoanApplyDao;
import com.bankingmanagement.bankingmanagement.loan.exception.LoanException;
import com.bankingmanagement.bankingmanagement.loan.model.Loan;
import com.bankingmanagement.bankingmanagement.loan.model.LoanInfo;
import com.bankingmanagement.bankingmanagement.loan.service.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

@Service
public class LoanServiceImpl implements LoanService {
    private static List<LoanInfo> loans = new ArrayList<LoanInfo>();
    // Database connection instance.
    @Autowired
    private DatabaseConnectionDao databaseConnectionDAO;

    @Autowired
    private LoanApplyDao loanapplydao;


    @Override
    public String applyLoan(Loan loan,String userId) throws LoanException {
          validateLoanData(loan);
          validateUserId(userId);
        try (final Connection connection = databaseConnectionDAO.getConnection();
             final Statement statement = connection.createStatement()) {
            String insertLoanQuery = loanapplydao.insertLoanReqTableQuery(loan,userId);
            System.out.println("Inserted Successfully"+ insertLoanQuery);
            final int loanRowInserted = statement.executeUpdate(loanapplydao.insertLoanReqTableQuery(loan, userId), Statement.RETURN_GENERATED_KEYS);
            if (loanRowInserted > 0) {
               return "viewallApplication";
            }
            throw new LoanException("Internal Error while loan,");

        } catch (SQLException | DatabaseConnectionException sqlException) {
            // TODO handle database incosientancy while insering data
            sqlException.printStackTrace();
            throw new LoanException("Internal Error while loan,");
        }

    }

    @Override
    public List<LoanInfo> getAppliedLoans(String userId) throws LoanException {

        loans.clear();
        if(userId==null || userId.trim().isEmpty()) {
            throw new LoanException("Please Login Again to fetch details");
        }
        try (final Connection connection = databaseConnectionDAO.getConnection();
             final Statement statement = connection.createStatement()) {
            String fetchAllLoansQuery = loanapplydao.fetchLoanReqTableQuery(userId);
            final ResultSet allLoan = statement.executeQuery(fetchAllLoansQuery);
            if (allLoan == null) {
                return null;
            }
            while (allLoan.next()) {
                LoanInfo l=new LoanInfo(allLoan.getInt("idLoanRequest"),allLoan.getString("CustomerID"),
                        allLoan.getString("CustomerFirstName"),
                        allLoan.getString("CustomerLastName"),allLoan.getString("CustomerAddress1"),
                        allLoan.getString("CustomerAddress2"),allLoan.getString("City"),
                        allLoan.getString("Zipcode"),allLoan.getString("CustomerEmail"),
                        allLoan.getString("PhoneNumber"),allLoan.getString("SIN"),
                        allLoan.getString("SALARY"),allLoan.getString("AGE"),
                        allLoan.getString("LoanAmount"),
                        allLoan.getString("LOANTYPE"),allLoan.getBoolean("LoanStatus"));
//                Loan l=null;
//                l.setFirstName(allLoan.getString("CustomerFirstName"));
//                l.setLastName(allLoan.getString("CustomerLastName"));
//                l.setSalary(allLoan.getString("SALARY"));
//                l.setAddress1(allLoan.getString("CustomerAddress1"));
//                l.setAddress2(allLoan.getString("CustomerAddress2"));
//                l.setAge(allLoan.getString("AGE"));
//                l.setCity(allLoan.getString("City"));
//                l.setContactNumber(allLoan.getString("PhoneNumber"));
//                l.setEmail(allLoan.getString("CustomerEmail"));
//                l.setSin(allLoan.getString("SIN"));
//                l.setZipCode(allLoan.getString("Zipcode"));
//                l.setLoanType(allLoan.getString("LOANTYPE"));
                loans.add(l);
            }
            return loans;
        } catch (SQLException | DatabaseConnectionException sqlException) {
            // TODO handle database incosientancy while insering data
            sqlException.printStackTrace();
            throw new LoanException("Internal Error while loan,");
        }


    }

    private void validateUserId(String userId) throws LoanException {
        if(userId==null || userId.trim().isEmpty() || !Pattern.matches("[A-Za-z ]+", userId)){
            throw new LoanException("userId is Invalid Please Login");
        }
    }

    private void validateLoanData(Loan loan) throws LoanException {
        String firstName = loan.getFirstName();

        if(firstName==null || firstName.trim().isEmpty() || !Pattern.matches("[A-Za-z ]+", firstName)){
            throw new LoanException("FirstName is empty or Invalid ");
        }
        String lastName = loan.getLastName();

        if(lastName==null || lastName.trim().isEmpty() || !Pattern.matches("[A-Za-z ]+", lastName)){
            throw new LoanException("LastName is empty or Invalid ");
        }

        String address1 = loan.getAddress1();

        if(address1==null || address1.trim().isEmpty()){
            throw new LoanException("Address1 is empty ");
        }

        String address2 = loan.getAddress2();

        if(address2==null || address2.trim().isEmpty()){
            throw new LoanException("Address2 is empty ");
        }

        String email = loan.getEmail();

        if(email==null || email.trim().isEmpty() || !Pattern.matches("^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,}$",
                email)){
            throw new LoanException("Email is empty or Invalid ");
        }



        String city = loan.getCity();

        if(city==null || city.trim().isEmpty() || !Pattern.matches("[A-Za-z ]+", city)){
            throw new LoanException("City is empty or Invalid ");
        }

        String zipCode = loan.getZipCode();

        if(false&&(zipCode==null || zipCode.trim().isEmpty() || !Pattern.matches("^\\d{5}(?:[-\\s]\\d{4})?$", zipCode))){
            throw new LoanException("Zipcode is empty or Invalid ");
        }

        String contactNumber = loan.getContactNumber();

        if(contactNumber==null || contactNumber.trim().isEmpty()){
            throw new LoanException("ContactNumber is empty  ");
        }

        //TODO : update sin to string regex: ^(\d{3}-\d{3}-\d{3})|(\d{9})$
        String sin = loan.getSin();
        if(sin==null || sin.trim().isEmpty()){
            throw new LoanException("sin is empty  ");
        }
        String salary =loan.getSalary();
        if(salary==null || sin.trim().isEmpty()|| salary=="0"){
            throw new LoanException("Salary is empty  ");
        }
        String loanType =loan.getLoanType();
        if(loanType==null || loanType.trim().isEmpty()||loanType=="loanType"){
            throw new LoanException("Please select loanType  ");
        }
        String age =loan.getAge();
        if(age==null || age.trim().isEmpty()||age=="0"){
            throw new LoanException("Age is empty ");
        }
    }
}