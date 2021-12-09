package com.bankingmanagement.bankingmanagement.database;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

@Component
public class DatabaseConnection implements DatabaseConnectionDao {

    private static final String DATABASE_CONFIG_FILE = "./databaseConfiguration.properties";
    private Connection connection = null;
    private static DatabaseConnection databaseConnection;

    private DatabaseConnection() {
        //Required private constructor
    }

    public static DatabaseConnection getInstance() {
        if (databaseConnection == null) {
            databaseConnection = new DatabaseConnection();
        }
        return databaseConnection;
    }

    private Connection connectToDatabase() throws DatabaseConnectionException {

        try (final InputStream inputStream = new FileInputStream(DATABASE_CONFIG_FILE)) {
            final Properties databaseConfigProperties = new Properties();
            databaseConfigProperties.load(inputStream);

            Class.forName(databaseConfigProperties.getProperty("mysqlJDBCDriver")).getDeclaredConstructor().newInstance();

            final String databaseType = databaseConfigProperties.getProperty("databaseType");
            final String databaseURL = databaseConfigProperties.getProperty("databaseURL") +
                    databaseConfigProperties.getProperty(databaseType + "Database")+"?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";


            final String databaseUserName = databaseConfigProperties.getProperty(databaseType + "Username");
            final String databasePassword = databaseConfigProperties.getProperty(databaseType + "Password");

            return DriverManager.getConnection(databaseURL, databaseUserName, databasePassword);

        } catch (IOException | ClassNotFoundException | NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException | SQLException e) {
            throw new DatabaseConnectionException(e.getMessage(), e);
        }
    }

    @Override
    public Connection getConnection() throws DatabaseConnectionException {
        closeConnection();
        connection = connectToDatabase();
        return connection;
    }

    @Override
    public void closeConnection() {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            connection = null;
        }
    }
}
