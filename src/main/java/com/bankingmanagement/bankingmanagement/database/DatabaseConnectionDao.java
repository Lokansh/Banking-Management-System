package com.bankingmanagement.bankingmanagement.database;

import java.sql.Connection;

public interface DatabaseConnectionDao {
    Connection getConnection() throws DatabaseConnectionException;

    void closeConnection();
}
