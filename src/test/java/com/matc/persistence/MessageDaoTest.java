package com.matc.persistence;

import com.matc.entity.Message;
import com.matc.entity.MessageStatus;
import org.apache.log4j.Logger;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by student on 12/4/16.
 */
public class MessageDaoTest {

    private final Logger log = Logger.getLogger(this.getClass());
    @Test
    public void testCreate() {
        MessageDao messageDao = new MessageDao();
        Message message = new Message(1, "joe2", "Greetings", "Welcome to PLT!");

        assertTrue(messageDao.create(message) > -1);

        messageDao.delete(message);
    }
    @Test
    public void getMessagesByUserId() throws Exception {
        MessageDao messageDao = new MessageDao();
        assertTrue(messageDao.getMessagesByUserId(1).size() > 0);
    }

    @Test
    public void getMessagesByStatus() throws Exception {
        MessageDao messageDao = new MessageDao();
        assertTrue(messageDao.getMessagesByStatus("joe2", MessageStatus.READ).size() > 0);
    }

    @Test
    public void getMessagesByUserName() throws Exception {
        MessageDao messageDao = new MessageDao();
        assertTrue(messageDao.getMessagesByUserName("joe2").size() > 0);
    }



}