package com.matc.entity;

/**
 * Created by student on 9/22/16.
 */
public class User {
    private String userName;
    private String userPassword;
    private String userEmail;

    User (String userName, String userPassword, String userEmail)
    {
        this.userName = userName;
        this.userPassword = userPassword;
        this.userEmail = userEmail;
    }
    User() {}

    public String getUserName()
    {
        return userName;
    }
    public String getUserPassword()
    {
        return userPassword;
    }
    public String getUserEmail()
    {
        return userEmail;
    }

    public String toString()
    {
        return "Username: " + userName + "\nEmail:" + userEmail;
    }

}
