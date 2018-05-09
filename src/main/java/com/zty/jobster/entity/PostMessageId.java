package com.zty.jobster.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.time.LocalDateTime;

@Embeddable
public class PostMessageId implements Serializable{

    private static final long serialVersionUID = -7253818895027446532L;

    @ManyToOne
    @JsonIgnoreProperties("password")
    private Student sender;

    @ManyToOne
    @JsonIgnoreProperties("password")
    private Student receiver;

    @Column(name = "message_time")
    private LocalDateTime message_time;

    public PostMessageId(Student sender, Student receiver, LocalDateTime message_time) {
        this.sender = sender;
        this.receiver = receiver;
        this.message_time = message_time;
    }

    public PostMessageId() {
    }

    public Student getSender() {
        return sender;
    }

    public void setSender(Student sender) {
        this.sender = sender;
    }

    public Student getReceiver() {
        return receiver;
    }

    public void setReceiver(Student receiver) {
        this.receiver = receiver;
    }

    public LocalDateTime getMessage_time() {
        return message_time;
    }

    public void setMessage_time(LocalDateTime message_time) {
        this.message_time = message_time;
    }
}
