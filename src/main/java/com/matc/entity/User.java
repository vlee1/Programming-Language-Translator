package com.matc.entity;

import java.util.Date;

/**
 * Created by student on 9/22/16.
 */
public class User {
    private String userName;
    private String userPassword;
    private String userEmail;
    private Date userActDate;
    private Date userDeactDate;

    public User (String userName, String userPassword, String userEmail) {

        this.userName = userName;
        this.userPassword = userPassword;
        this.userEmail = userEmail;
    }
    public User (String userName, String userEmail, Date userActDate, Date userDeactDate) {

        this.userName = userName;
        this.userEmail = userEmail;
        this.userActDate = userActDate;
        this.userDeactDate = userDeactDate;
    }

    public User (){}

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
    public Date getUserActivatedDate() { return userActDate; }
    public Date getUserDeactivatedDate() { return userDeactDate; }

    public String toString()
    {
        return "Username: " + userName + "\nEmail:" + userEmail + " Activated Date:" + getUserActivatedDate() +
                " Deactivated Date:" + getUserDeactivatedDate();
    }

}
