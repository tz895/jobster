package com.zty.jobster.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Embeddable
public class FriendRelationId implements Serializable{

    private static final long serialVersionUID = 8786529037924189404L;

    @ManyToOne
    @JsonIgnoreProperties("password")
    private Student student;

    @ManyToOne
   @JsonIgnoreProperties("password")
    private Student friend;

    public FriendRelationId(Student student, Student friend) {
        this.student = student;
        this.friend = friend;
    }

    public FriendRelationId() {
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Student getFriend() {
        return friend;
    }

    public void setFriend(Student friend) {
        this.friend = friend;
    }
}
