package com.bankingmanagement.bankingmanagement.authentication.database;

public final class LoginConstants {

    // User-Login table.
    public static final String USERLOGIN_TABLE = "User_Login";

    // User-Login unique id column
    public static final String LOGIN_ID = "CustomerID";

    public static final String LOGIN_PASSWORD = "Password";
    // Constant for RoleType
    public static final String USER_ROLE = "user";
    public static final String ADMIN_ROLE = "admin";
    public static final String EMPLOYEE_ROLE = "employee";

    public static final String USER_ROLE_TYPE = "0";
    public static final String ADMIN_ROLE_TYPE = "2";
    public static final String EMPLOYEE_ROLE_TYPE = "1";
}