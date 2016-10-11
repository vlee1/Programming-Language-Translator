package com.matc.persistence;

import com.matc.entity.User;
import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.List;

//import org.hibernate.criterion.Restrictions;

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
    public void deleteUser(int id) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();

        session.beginTransaction();

        User user = (User) session.get(User.class, id);
        session.delete(user);

        session.getTransaction().commit();
        session.close();
    }

    /**
     * updates user
     *
     * @param user the user
     */
    public void updateUser(User user) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        session.beginTransaction();

        User selectedUser = (User) session.get(User.class, user.getUserId());

        selectedUser.setUserPassword(user.getUserPassword());
        selectedUser.setUserEmail(user.getUserEmail());

        session.update(selectedUser);
        session.getTransaction().commit();

        session.close();

    }

}
