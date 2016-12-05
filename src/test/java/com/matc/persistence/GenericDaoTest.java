package com.matc.persistence;

import com.matc.entity.Message;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by student on 12/4/16.
 */
public class GenericDaoTest {

    private final Logger log = Logger.getLogger(this.getClass());

    @Test
    public void testCreate() {
        GenericDao<Message> messageDao = new GenericDao<>(Message.class);
        Message message = new Message(1,"Testing", "johnDoe@java.com", "TestCreate");
        messageDao.create(message);
        Assert.assertTrue(message.getMessageId() > -1);
    }
}
