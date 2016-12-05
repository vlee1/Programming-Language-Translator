package com.matc.entity;

import com.matc.persistence.LocalDateAttributeConverter;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parent;

import javax.ejb.AfterCompletion;
import javax.persistence.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by student on 11/30/16.
 */
@Entity
@Table(name="message")
public class Message {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name="increment", strategy = "increment")
    @Column(name="m_id")
    private int messageid;

    @ManyToOne(cascade={CascadeType.ALL})
    @JoinColumn(name="parent_id")
    private Message parent;

    @OneToMany(mappedBy ="parent")
    private Set<Message> childrenM = new HashSet<Message>();

    @Column(name="creator_id")
    private int userid;

    @Column(name="recipient_email")
    private String recipientEmail;

    @Column(name="description")
    private String description;

    @Column(name="subject")
    private String subject;

    @Column(name="create_date")
    @Convert(converter = LocalDateAttributeConverter.class)
    private LocalDate createdDate;

    // TODO: Add attached file if have enough time

    public Message(int userid, String description, String recipientEmail, String subject) {

        LocalDate localDate = LocalDate.now();

        this.userid = userid;
        this.description = description;
        this.recipientEmail = recipientEmail;
        this.subject = subject;
        this.createdDate = localDate;
    }

    public Message() {}

    public int getMessageId() { return this.messageid; }
    public LocalDate getCreatedDate() { return  this.createdDate; }
    public int getUserId() { return this.userid; }
    public String getDescription() { return this.description; }
    public String getRecipientEmail() { return this.recipientEmail; }
    public String getSubject() { return this.subject; }
    public void setParent(Message parent) { this.parent = parent; }
}
