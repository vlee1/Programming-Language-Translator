import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

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
    private int userId;

    @Column(name = "username")
    private String userName;

    @Column(name = "password")
    private String userPassword;

    @Column(name = "email")
    private String userEmail;

    @Convert(converter = LocalDateAttributeConverter.class)
    @Column(name = "act_date")
    private LocalDate userActDate;

    @Convert(converter = LocalDateAttributeConverter.class)
    @Column(name = "deact_date")
    private LocalDate userDeactDate;

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
    public User(String userName, String userPassword, String userEmail) {

        this.userName = userName;
        this.userPassword = userPassword;
        this.userEmail = userEmail;
        this.userActDate = LocalDate.now();
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
    public LocalDate getUserActivatedDate() { return userActDate; }

    /**
     * set userActDate
     * @param date user's activated date
     */
    public void setUserActDate(LocalDate date) { this.userActDate = date; }

    /**
     *
     * @return user's deactivated date
     */
    public LocalDate getUserDeactivatedDate() { return userDeactDate; }

    /**
     * sets userDeactDate
     * @param date the date
     */
    public void setUserDeactDate(LocalDate date) { this.userDeactDate = date; }



}
