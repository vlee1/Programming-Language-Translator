package com.matc.entity;

import com.matc.persistence.LocalDateAttributeConverter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;

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

    @Column(name="creator_id")
    private int userid;

    @Column(name="recipient")
    private String username;

    @Column(name="subject")
    private String subject;

    @Column(name="create_date")
    @Convert(converter = LocalDateAttributeConverter.class)
    private LocalDate createdDate;

    @Column(name="message_status")
    private MessageStatus status;

    public Message(int userid, String username, String subject) {

        LocalDate localDate = LocalDate.now();

        this.userid = userid;
        this.username = username;
        this.subject = subject;
        this.createdDate = localDate;
        this.status = MessageStatus.UNREAD;
    }

    public Message() {}

    public int getMessageId() { return this.messageid; }
    public LocalDate getCreatedDate() { return  this.createdDate; }
    public int getUserId() { return this.userid; }
    public String getUsername() { return this.username; }
    public String getSubject() { return this.subject; }
    @Enumerated(EnumType.ORDINAL)
    public MessageStatus getStatus() { return status; }
    private void setStatus(MessageStatus status) { this.status = status; }

    public void markMessageStatus(MessageStatus status) {
        if (this.status != status) {
            setStatus(status);
        }
    }
}
