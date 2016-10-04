
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;


/**
 * Created by student on 9/26/16.
 */
public class UserDaoTest {

    User user;

    @Before
    public void setup() {
        user = new User();
        user.setUserName("Testname");
        user.setUserPassword("TestPassword");
        user.setUserEmail("test@mail.com");
        user.setUserActDate(LocalDate.now());
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
        List<Integer> id = new ArrayList<Integer>();

        UserDao dao = new UserDao();
        id.add(dao.addUser(this.user));

        assertEquals("must be at least one user", 1, id.size());
    }

}