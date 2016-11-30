package com.matc.persistence;

/**
 * Created by student on 11/30/16.
 */
public class Message {

    private int messageid;
    private int userid;
    private ArrayList<Message> messages;
    private String recipientemail;
    private String description;
    private String useremail;
    private String subject;

    // TODO: Add attached file if have enough time

    public Message(int userid, String document, String recipientemail, String subject) {

        this.userid = userid;
        this.document = document;
        this.recipientemail = recipientemail;
        this.subject = subject;
    }

    public int getMessageId() { return this.messageid; }
    public int getUserId() { return this.userid; }
    public String getDocument() { return this.document; }
    public String getRecipientEmail() { return this.recipientemail; }
    public String getSubject() { return this.subject; }

    public void send() {

    }

    public void write() {

    }
}
