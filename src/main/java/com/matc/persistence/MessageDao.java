package com.matc.persistence;

import com.matc.entity.Message;
import com.matc.entity.MessageStatus;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import java.util.List;

/**
 * Created by student on 12/4/16.
 */
public class MessageDao extends GenericDao {

    private final Logger log = Logger.getLogger(this.getClass());

    public MessageDao() {
        super(Message.class);
    }

    /**
     * Returns messages created by user
     * @param id    user's id
     * @return      messages
     */
    public List<Message> getMessagesByUserId(int id) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();

        List<Message> messages = session.createCriteria(Message.class)
                    .add(Restrictions.eq("userid", id))
                    .addOrder(Order.desc("createdDate"))
                    .list();

        session.close();

        return messages;
    }

    /**
     * Returns messages based on status
     * @param username          recipient username
     * @param messageStatus     status
     * @return                  messages
     */
    public List<Message> getMessagesByStatus(String username, MessageStatus messageStatus) {
        Session session;
        List<Message> messages = null;

        switch(messageStatus) {
            case UNREAD:
                session = SessionFactoryProvider.getSessionFactory().openSession();

                messages = session.createCriteria(Message.class)
                        .add(Restrictions.eq("status", messageStatus))
                        .add(Restrictions.eq("username", username))
                        .list();

                session.close();
                return messages;

            case READ:
                session = SessionFactoryProvider.getSessionFactory().openSession();

                messages = session.createCriteria(Message.class)
                        .add(Restrictions.eq("status", messageStatus))
                        .add(Restrictions.eq("username", username))
                        .list();

                session.close();
                return messages;
        }

        return messages;
    }

    /**
     * Returns messages by username
     * @param username  recipient (username)
     * @return          messages
     */
    public List<Message> getMessagesByUserName(String username) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        List<Message> messages = session.createCriteria(Message.class)
                    .add(Restrictions.eq("username", username))
                    .addOrder(Order.desc("createdDate"))
                    .list();

        session.close();
        return messages;
    }


}
