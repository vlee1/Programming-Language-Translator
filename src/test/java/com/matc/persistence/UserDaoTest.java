package com.matc.persistence;

import com.matc.entity.User;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by student on 12/7/16.
 */
public class UserDaoTest {
    @Test
    public void getUsersByUserName() throws Exception {
        UserDao userDao = new UserDao();

        assertTrue(userDao.getUsersByUserName("joe2").size() > 0);
    }

    @Test
    public void testCreate() throws Exception {
        UserDao userDao = new UserDao();
        User user = new User("test01","test@gmail.com","password");

        assertTrue(userDao.create(user) > -1);
        userDao.delete(user);
    }
}