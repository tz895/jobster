package com.zty.jobster.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Embeddable
public class FriendRequestId implements Serializable{

    private static final long serialVersionUID = 3404060410724416239L;

    @ManyToOne
    @JsonIgnoreProperties("password")
    private Student sender;

    @ManyToOne
    @JsonIgnoreProperties("password")
    private Student receiver;

    public FriendRequestId(Student sender, Student receiver) {
        this.sender = sender;
        this.receiver = receiver;
    }

    public FriendRequestId() {
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
}
