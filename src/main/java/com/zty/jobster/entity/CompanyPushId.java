package com.zty.jobster.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Embeddable
public class CompanyPushId implements Serializable {

    private static final long serialVersionUID = 5323132188650754111L;

    @ManyToOne
    @JsonIgnoreProperties("password")
    private Student student;

    @ManyToOne
    private Job job;

    public CompanyPushId(Student student, Job job) {
        this.student = student;
        this.job = job;
    }

    public CompanyPushId() {
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
    }
}