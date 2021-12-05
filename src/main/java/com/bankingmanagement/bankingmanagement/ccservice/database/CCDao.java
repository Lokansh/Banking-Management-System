package com.bankingmanagement.bankingmanagement.ccservice.database;

public interface CCDao {

     String fetchAllCCTableQuery(String userId);

    String fetchCreditScoreQuery(String sin);

    String submitCCIncReqQuery(String userId, String salary);

    String getOldSalary(String userId);
}
