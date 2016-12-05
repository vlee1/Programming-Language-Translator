package com.matc.persistence;

import com.matc.entity.Message;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by student on 12/4/16.
 */
public class MessageDaoTest {

    private Logger log = Logger.getLogger(this.getClass());
    private Message message;

    @Before
    public void setUp() {
        message = new Message(1,"testind","johnDoe@java.com","Test");
    }

    @Test
    public void testCreate() throws Exception {
        MessageDao mDao = new MessageDao();
        assertTrue(mDao.create(this.message) > -1);

    }

}