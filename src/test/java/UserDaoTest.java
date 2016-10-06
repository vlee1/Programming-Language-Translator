
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;

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

        //Assert.assertNotNull(dao.getAllUsers());
        //Assert.assertNull("No data in database", dao.getAllUsers());

    }


}