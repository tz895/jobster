package com.zty.jobster.entity;

import com.zty.jobster.entity.Enum.StudentAccessType;
import org.hibernate.annotations.Type;

import javax.persistence.*;

@Entity
@Table(name = "student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="sid")
    private int studentId;

    @Column(name="username")
    private String username;

    @Column(name="password")
    private String password;

    @Column(name="sname")
    private String name;

    @Column(name="email")
    private String studentEmail;

    @Column(name="university")
    private String university;

    @Column(name="major")
    private String major;

    @Column(name="gpa")
    private double gpa;

    @Column(name="resume")
    @Type(type = "text")
    private String resume;

    @Enumerated(EnumType.STRING)
    @Column(name="saccess")
    private StudentAccessType access;

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStudentEmail() {
        return studentEmail;
    }

    public void setStudentEmail(String studentEmail) {
        this.studentEmail = studentEmail;
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    public String getResume() {
        return resume;
    }

    public void setResume(String resume) {
        this.resume = resume;
    }

    public StudentAccessType getAccess() {
        return access;
    }

    public void setAccess(StudentAccessType access) {
        this.access = access;
    }
}
