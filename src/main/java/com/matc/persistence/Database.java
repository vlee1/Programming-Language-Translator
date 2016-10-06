package com.matc.persistence;

import org.apache.log4j.Logger;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Created by student on 9/22/16.
 */
public class Database {
    private static Database instance;
    private Properties properties;
    private Connection connection;
    private final Logger logger = Logger.getLogger(this.getClass());

    private Database() {
        loadProperties();
    }

    private void loadProperties() {
        properties = new Properties();

        try {
            properties.load (this.getClass().getResourceAsStream("/database.properties"));
        } catch (IOException ioe) {
            logger.info("Database.loadProperties()...Cannot load the properties file");
            logger.info("io.PrintStackTrace()");
        } catch (Exception e) {
            logger.info("Database.loadProperties()..." + e);
            logger.info("e.printStackTrace()");
        }
    }

    // get the only Database object available
    public static Database getInstance() {
        return instance;
    }

    public Connection getConnection() {
        return connection;
    }

    public void connect() throws Exception {
        if (connection != null)
            return;

        try {
            Class.forName(properties.getProperty("driver"));
        } catch (ClassNotFoundException e) {
            throw new Exception("Database.connect()... Error: MySQL Driver not found");
        }

        String url = properties.getProperty("url");
        connection = DriverManager.getConnection(url, properties.getProperty("username"),  properties.getProperty("password"));
    }

    public void disconnect() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                logger.info("Cannot close connection" + e);
            }
        }

        connection = null;
    }
}
