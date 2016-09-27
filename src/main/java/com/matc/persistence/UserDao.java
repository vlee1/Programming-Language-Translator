package com.matc.persistence;

import com.matc.entity.User;
import org.apache.log4j.Logger;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by student on 9/26/16.
 */
public class UserDao {
    private final Logger logger = Logger.getLogger(this.getClass());

    public List<User>getAllUsers() {

        List<User> users = new ArrayList<User>();
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        users = session.createCriteria(User.class).list();

        return users;
    }


}
