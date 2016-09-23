package com.matc.persistence;

import com.matc.entity.User;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by student on 9/22/16.
 */
public class UserData {

    private final Logger logger = Logger.getLogger(this.getClass());

    private Database database;
    private Connection connection;
    private List<User> users;

    public UserData() {
        database = Database.getInstance();
        users = new ArrayList<User>();
    }


    public void addUserToDatabase(User user) {

        String sql = "INSERT INTO User(user_name, user_password, user_email, user_actDate) " +
                "VALUES(" + user.getUserName() + ", " + user.getUserPassword() + ", " + user.getUserEmail() +
                ", NOW())";

        try {
            database.connect();
            connection = database.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.executeUpdate();
            database.disconnect();

        } catch (SQLException e) {
            database.disconnect();

            logger.error(e.getStackTrace());

        } catch (Exception e) {
            database.disconnect();

            logger.error(e.getStackTrace());
        }

    }

    public void addUserToList(String sql) {

        try {
            database.connect();
            connection = database.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet results = preparedStatement.executeQuery(sql);

            while (results.next()) {

                User user = createUserFromResults(results);
                users.add(user);
            }

        } catch (SQLException e) {
            database.disconnect();

            logger.error(e.getStackTrace());

        } catch (Exception e) {
            database.disconnect();

            logger.error(e.getStackTrace());
        }
    }

    public void getAllUsers() {
        String allUsers = "SELECT * FROM User";

        addUserToList(allUsers);
    }

    private User createUserFromResults(ResultSet results) throws SQLException {
        User user = new User(results.getString("user_name"), results.getString("user_email"),
                results.getDate(4), results.getDate(5));

        return user;
    }

}
