package com.matc.persistence;

import com.matc.entity.User;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * Created by student on 9/22/16.
 */
public class UserData {

    private final Logger logger = Logger.getLogger(this.getClass());
    private List<User> users;
    private Database database;
    private Connection connection;
    private Properties properties;

    public UserData() {

        users = new ArrayList<User>();
        database = Database.getInstance();
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

    public void addUser(String sql) {
        try {
            database.connect();
            connection = database.getConnection();
            Statement selectStatement = connection.createStatement();
            ResultSet results = selectStatement.executeQuery(sql);

            while (results.next()) {
                User user = createUserFromResults(results);
                users.add(user);
            }

            database.disconnect();

        } catch (SQLException e) {
            logger.debug("SearchUser.getMatchingLastName()...SQL Exception: " + e);
        } catch (Exception e) {
            logger.debug("SearchUser.getMatchingLastName()...Exception: " + e);
        }
    }

    public List<User> getAllUsers() {

        String sql = "SELECT * FROM users";

        addUser(sql);

        return users;
    }


}
