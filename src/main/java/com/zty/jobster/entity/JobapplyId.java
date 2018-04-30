package com.zty.jobster.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.context.annotation.Bean;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Embeddable
public class JobapplyId implements Serializable {


    private static final long serialVersionUID = -3399214282117995636L;

    @ManyToOne
    @JsonIgnoreProperties("password")
    private Student student;

    @ManyToOne
    @JsonIgnoreProperties("password")
    private Job job;

    public JobapplyId(Student student, Job job) {
        this.student = student;
        this.job = job;
    }

    public JobapplyId() {
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
