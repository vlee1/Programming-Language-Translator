package com.matc.persistence;

import com.matc.entity.User;
import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by student on 9/26/16.
 */
public class UserDao extends GenericDao{

    private final Logger logger = Logger.getLogger(this.getClass());

    public UserDao() { super(User.class); }

    public User getUserByUserName(String username) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        List<User> users = session.createCriteria(User.class)
                    .add(Restrictions.eq("username", username))
                    .list();
        User user = users.get(0);

        return user;
    }

}
