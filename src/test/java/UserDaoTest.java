
import org.junit.Test;

/**
 * Created by student on 9/26/16.
 */
public class UserDaoTest {

    @Test
    public void display() {
        UserDao dao = new UserDao();

        for (User users: dao.getAllUsers()) {
            dao.displayUsers(users);
        }
    }
}