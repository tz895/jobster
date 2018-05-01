package com.zty.jobster.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.time.LocalDateTime;

@Embeddable
public class JobForwardId implements Serializable{


    private static final long serialVersionUID = 8905127851609517364L;

    @ManyToOne
    @JsonIgnoreProperties("password")
    private Student sender;

    @ManyToOne
    @JsonIgnoreProperties("password")
    private Student receiver;

    @ManyToOne
    private Job job;


    public JobForwardId(Student sender, Student receiver, Job job) {
        this.sender = sender;
        this.receiver = receiver;
        this.job = job;
    }

    public JobForwardId() {
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

    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
    }

}
