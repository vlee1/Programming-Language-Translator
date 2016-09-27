import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by student on 9/22/16.
 */

@Entity
@Table(name = "User")
public class User {

    @Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
    @Column(name = "user_id")
    private int userId;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "user_password")
    private String userPassword;

    @Column(name = "user_email")
    private String userEmail;

    @Column(name = "user_actDate")
    private Date userActDate;

    @Column(name = "user_deactDate")
    private Date userDeactDate;

    /**
     *  An empty constructor
     */
    public User(){}

    /**
     * Constructor retrieves general user information
     *
     * @param userName user's uername
     * @param userEmail user's email
     */
    public User(String userName, String userEmail) {

        this.userName = userName;
        this.userPassword = userPassword;
        this.userEmail = userEmail;
    }

    /**
     * @return user's id
     */
    public int getUserId() { return userId; }

    /**
     * sets userId
     * @param id user's id
     */
    public void setUserId(int id) { this.userId = id; };

    /**
     * @return user's username
     */

    public String getUserName()
    {
        return userName;
    }

    /**
     * sets userName
     * @param userName user's username
     */
    public void setUserName(String userName) { this.userName = userName; }

    /**
     * @return user's password
     */
    public String getUserPassword()
    {
        return userPassword;
    }

    /**
     * sets userPassword
     * @param userPassword user's password
     */
    public void setUserPassword(String userPassword) { this.userPassword = userPassword; }

    /**
     * @return user's email
     */
    public String getUserEmail()
    {
        return userEmail;
    }

    /**
     * sets userEmail
     * @param userEmail user's email
     */
    public void setUserEmail(String userEmail) { this.userEmail = userEmail; }

    /**
     *
     * @return user's activated date
     */
    public Date getUserActivatedDate() { return userActDate; }

    /**
     * set userActDate
     * @param date user's activated date
     */
    public void setUserActDate(Date date) { this.userActDate = date; }

    /**
     *
     * @return user's deactivated date
     */
    public Date getUserDeactivatedDate() { return userDeactDate; }

    /**
     * sets userDeactDate
     * @param date the date
     */
    public void setUserDeactDate(Date date) { this.userDeactDate = date; }



}
