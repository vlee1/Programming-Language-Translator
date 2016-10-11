
import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.cfg.QuerySecondPass;
//import org.hibernate.criterion.Restrictions;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by student on 9/26/16.
 */
public class UserDao {
    private final Logger logger = Logger.getLogger(this.getClass());

    /**
     * get all users from database
     *
     * @return users
     */
    public List<User>getAllUsers() {
        // TODO need to fix WARNING: "Unchecked assignment: 'java.util.List' to 'java.util.List<User>'"
        List<User> users = new ArrayList<User>();
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        users = session.createCriteria(User.class).list();

        return users;
    }

    /**
     * get a specific user
     *
     * @param id user's id
     * @return user
     */
    public User getUser(int id) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();

        User user = (User) session.get(User.class, id);

        return user;
    }

    /**
     * add new user
     *
     * @param user new user
     * @return user's id
     */
    public int addUser(User user) {
        int id = 0;

        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Query query = session.createQuery("SELECT userId FROM User ORDER BY userId DESC");
        session.beginTransaction();
        session.save(user);
        session.getTransaction().commit();
        query.setMaxResults(1);
        id = Integer.parseInt(query.uniqueResult().toString());
        session.close();

        logger.info(id);
        return id;
    }

    /**
     * deletes user
     *
     * @param id user's id
     */
    public User deleteUser(int id) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();

        session.beginTransaction();

        User user = (User) session.get(User.class, id);
        session.delete(user);

        //Junit query testing

        Query query = session.createQuery("SELECT userId FROM User");
        query.setMaxResults(1);
        user = (User) query.uniqueResult();

        // End of junit query testing


        session.getTransaction().commit();
        session.close();

        // Testing for junit

        return user;

        // End of junit testing
    }

    /**
     * updates user
     *
     * @param user the user
     */
    public String updateUser(User user) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        session.beginTransaction();

        User selectedUser = (User) session.get(User.class, user.getUserId());

        logger.info(selectedUser.getUserEmail());
        selectedUser.setUserPassword(user.getUserPassword());
        selectedUser.setUserEmail(user.getUserEmail());

        session.update(selectedUser);
        session.getTransaction().commit();

        Query query = session.createQuery("SELECT email FROM User");
        query.setMaxResults(1);
        String changedEmail = (String) query.uniqueResult();
        session.close();

        return changedEmail;

    }

}
