package com.matc.persistence;

/**
 * Created by student on 11/30/16.
 */
public class MessageDao {

    public void create(int userid, String description, String subject, String recipientemail) {
        String recipientEmail = recipientEmail(recipientemail);
    }

    public void send() {

    }

    /**
     * Returns recipient's email
     * @return  the recipient's email
     */
    private String recipientEmail(String recipientemail) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();

    }
}
