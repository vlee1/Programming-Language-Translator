
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by student on 9/26/16.
 */
public class UserDaoTest {

    User user;
    List<User> users;

    @Before
    public void setUp() {
        user = new User("vang", "SomePassword", "vang@email.com");

        users = new ArrayList<User>();
    }

    @Test
    public void getAllUsers() {
        UserDao dao = new UserDao();

        //Assert.assertNotNull(dao.getAllUsers());
        Assert.assertEquals(0, dao.getAllUsers().size());
    }

    @Test
    public void getUser() {
        UserDao dao = new UserDao();

        Assert.assertNull(dao.getUser(1));
    }

    @Test
    public void addUser() {
        UserDao dao = new UserDao();

        Assert.assertTrue(0 < dao.addUser(user));
    }

    @Test
    public void deleteUser() {
        UserDao dao = new UserDao();

        Assert.assertNull(dao.deleteUser(1));
    }

    @Test
    public void updateUser() {
        UserDao dao = new UserDao();
        user.setUserPassword("NewPassword");
        user.setUserEmail("ChangedEmail");
        Assert.assertEquals(user.getUserEmail(), dao.updateUser(user));
    }

}