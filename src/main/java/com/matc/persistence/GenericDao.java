package com.matc.persistence;

import com.matc.entity.Message;
import com.matc.entity.SessionCud;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Vang Lee on 11/16/16.
 */
 public class GenericDao<T> {

    private Class<T> type;
    private final Logger log = Logger.getLogger(this.getClass());

    private Session getSession() { return SessionFactoryProvider.getSessionFactory().openSession(); }

    public GenericDao(Class<T> type) { this.type = type; }

    public GenericDao() {}

    public int create(T object) { log.info("Creating..."); return genericTransaction(object, SessionCud.CREATE); }

    public void update(T object) {
        genericTransaction(object, SessionCud.UPDATE);
    }

    public void delete(T object) {
        genericTransaction(object, SessionCud.DELETE);
    }

    private int genericTransaction(T object, SessionCud sessionCud) {
        Transaction tx = null;
        Session session = getSession();
        int id = -1;

        try {
            tx = session.beginTransaction();

            switch (sessionCud) {
                case CREATE:
                    id = (Integer) session.save(object);
                    log.debug(id + " is created.");
                    tx.commit();
                    return id;
                case UPDATE:
                    session.update(object);
                    tx.commit();
                    break;
                case DELETE:
                    session.delete(object);
                    tx.commit();
                    break;
            }

        } catch (HibernateException he) {
            if (tx != null) tx.rollback();
            log.error(he);
        } finally {
            session.close();
        }

        return id;
    }

    public List<T> getAll() { return (ArrayList<T>) getSession().createCriteria(type).list(); }

    public T getById(int id) { return (T) getSession().get(type, id); }



}
