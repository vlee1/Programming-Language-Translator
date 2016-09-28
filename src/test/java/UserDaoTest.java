
import org.junit.Before;
import org.junit.Test;

import java.util.Date;

/**
 * Created by student on 9/26/16.
 */
public class UserDaoTest {

    User user;

    @Before
    public void setUp() {
        user = new User();
        user.setUserId(2);
        user.setUserName("johnDoe");
        user.setUserPassword("Changed");
        user.setUserEmail("newJohnD@mad.com");
        //user.setUserActDate(new Date());
    }

    @Test
    public void getAllUsers() {
        UserDao dao = new UserDao();
        dao.getAllUsers();
    }

    @Test
    public void getUserId() {

    }

    @Test
    public void addUser() {
        UserDao dao = new UserDao();
        dao.addUser(user);
    }

    @Test
    public void delete() {
        UserDao dao = new UserDao();
        dao.deleteUser(4);
    }

    @Test
    public void updateUser() {
        User user = new User();
        user.setUserId(3);
        user.setUserPassword("ChangedPassword");
        user.setUserEmail("NewJohn@Mad.com");

        UserDao dao = new UserDao();
        dao.updateUser(user);
    }

}