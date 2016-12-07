package com.matc.entity;

import com.matc.persistence.LocalDateAttributeConverter;
import org.hibernate.annotations.GenericGenerator;

import java.time.LocalDate;
import javax.persistence.*;

/**
 * Created by student on 9/22/16.
 */

@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
    @Column(name = "u_id")
    private int userid;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String userpassword;

    @Column(name = "email")
    private String useremail;

    @Column(name = "act_date")
    @Convert(converter = LocalDateAttributeConverter.class)
    private LocalDate useractdate;

    @Column(name = "deact_date")
    @Convert(converter = LocalDateAttributeConverter.class)
    private LocalDate userdeactdate;

    /**
     *  An empty constructor
     */
    public User (){}

    /**
     * Constructor retrieves general user information
     *
     * @param userName user's uername
     * @param userEmail user's email
     */
    public User (String userName, String userEmail, String userPassword) {

        this.username = userName;
        this.userpassword = userPassword;
        this.useremail = userEmail;
        this.useractdate = LocalDate.now();
    }

    /**
     * @return user's id
     */
    public int getUserId() { return userid; }

    /**
     * @return user's username
     */

    public String getUserName()
    {
        return username;
    }

    /**
     * @return user's password
     */
    public String getUserPassword()
    {
        return userpassword;
    }

    /**
     * @return user's email
     */
    public String getUserEmail()
    {
        return useremail;
    }

    /**
     *
     * @return user's activated date
     */
    public LocalDate getUserActivatedDate() { return useractdate; }

    /**
     *
     * @return user's deactivated date
     */
    public LocalDate getUserDeactivatedDate() { return userdeactdate; }

    public void setDeactivateUser(LocalDate date) {
        this.userdeactdate = date;
    }
}
