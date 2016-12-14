package com.matc.persistence;

import com.matc.entity.Message;
import com.matc.entity.MessageStatus;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by student on 12/4/16.
 */
public class GenericDaoTest {

    private final Logger log = Logger.getLogger(this.getClass());
    private Message message;

    @Before
    public  void setCurrentMessage() {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();

        List<Message> messageList = session.createCriteria(Message.class)
                    .add(Restrictions.eq("messageid", 3))
                    .list();
        this.message = messageList.get(0);

        session.close();
    }

    @Test
    public void create() throws Exception {
        GenericDao<Message> messageGenericDao = new GenericDao<>(Message.class);
        Message newMessage = new Message(1, "test", "Catch-up", "Hello there friend! Let's go out sometime.");
        assertTrue(messageGenericDao.create(newMessage) > -1);

        messageGenericDao.delete(newMessage);
    }

    @Test
    public void update() throws Exception {
        GenericDao<Message> messageGenericDao = new GenericDao<>(Message.class);
        message.markMessageStatus(MessageStatus.READ);
        messageGenericDao.update(message);
        assertEquals(MessageStatus.READ, message.getStatus());
    }

    @Test
    public void getAll() throws Exception {
        GenericDao<Message> messageGenericDao = new GenericDao<>(Message.class);
        assertTrue(messageGenericDao.getAll().size() > 0);
    }

    @Test
    public void getById() throws Exception {
        GenericDao<Message> messageGenericDao = new GenericDao<>(Message.class);

        assertTrue(messageGenericDao.getById(3).getMessageId() == message.getMessageId());
    }
}
