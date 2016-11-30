package com.matc.persistence;

/**
 * Created by student on 11/30/16.
 */
public class MessageDao {

    public void create(int userid, String description, String subject, String recipientemail) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        SQLQuery query = session.createSQLQuery("INSERT INTO message (subject, description, creator_id)"
                + "VALUES (:subject, :desc, :userid)");

        query.setParameter("userid" , userid);
        query.setParameter("description" , desc);
        query.setParameter("subject" , subject);
        query.setParameter("recipient" , recipientemail);

    }

    public void send() {

    }

    public void update() {

    }

    public Message getMessage() {

    }

    public ArrayList<Message> getAllMessages() {

    }

}
