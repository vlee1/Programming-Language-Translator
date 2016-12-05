package com.matc.persistence;

import com.matc.entity.Message;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import java.util.ArrayList;
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
     * Returns an id
     *
     * @param message   the message
     * @return          an id
     */
    public int create(Message message) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = null;
        int id = -1;

        List<Message> messages = session.createCriteria(Message.class)
                .add(Restrictions.eq("userid", message.getUserId()))
                .list();

        if (messages.size() > 0) {
            Message parentMessage = messages.get(0);

            message.setParent(parentMessage);

            try {
                tx = session.beginTransaction();
                id = (Integer) session.save(message);

                tx.commit();
                session.close();

                return id;

            } catch (HibernateException he) {
                if (tx != null) tx.rollback();
                log.error(he);

            } finally {
                session.close();
            }
        } else {
            tx = session.beginTransaction();
            message.setParent(getLastestParentId());

            id = (Integer) session.save(message);

            update(message);

        }

        return id;
    }

    /**
     * Returns the latest parent id
     *
     * @return  parent id
     */
    private Message getLastestParentId() {
        Message message = null;

        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        List<Message> messages = session.createCriteria(Message.class)
                    .addOrder(Order.desc("parent_id"))
                    .list();

        if (messages.size() > 0) {
            message = messages.get(0);

            return message;
        }

        return message;
    }
}
