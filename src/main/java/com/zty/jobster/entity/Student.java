package com.zty.jobster.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.zty.jobster.entity.Enum.StudentAccessType;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.List;

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

    @OneToMany(mappedBy = "pk.student",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Jobapply> jobapplyList;

    @OneToMany(mappedBy = "pk.student",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JsonIgnore
    private List<CompanySub> companySubList;

    @OneToMany(mappedBy = "pk.student",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JsonIgnore
    private List<CompanyPush> companyPushList;

    @OneToMany(mappedBy = "pk.sender",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JsonIgnore
    private List<FriendRequest> senderRequests;

    @OneToMany(mappedBy = "pk.receiver",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JsonIgnore
    private List<FriendRequest> receiverRequests;

    @OneToMany(mappedBy = "pk.sender",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JsonIgnore
    private List<JobForward> senderjobForwards;

    @OneToMany(mappedBy = "pk.receiver",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JsonIgnore
    private List<JobForward> receiverjobForwards;

    @OneToMany(mappedBy = "pk.student",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JsonIgnore
    private List<FriendRelation> friendRelationList;

    @OneToMany(mappedBy = "pk.friend",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JsonIgnore
    private List<FriendRelation> friendRelations;

    @OneToMany(mappedBy = "pk.sender",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JsonIgnore
    private List<PostMessage> senderMessageList;

    @OneToMany(mappedBy = "pk.receiver",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JsonIgnore
    private List<PostMessage> receiverMessageList;

    public List<PostMessage> getSenderMessageList() {
        return senderMessageList;
    }

    public void setSenderMessageList(List<PostMessage> senderMessageList) {
        this.senderMessageList = senderMessageList;
    }

    public List<PostMessage> getReceiverMessageList() {
        return receiverMessageList;
    }

    public void setReceiverMessageList(List<PostMessage> receiverMessageList) {
        this.receiverMessageList = receiverMessageList;
    }

    public List<FriendRelation> getFriendRelationList() {
        return friendRelationList;
    }

    public void setFriendRelationList(List<FriendRelation> friendRelationList) {
        this.friendRelationList = friendRelationList;
    }

    public List<JobForward> getSenderjobForwards() {
        return senderjobForwards;
    }

    public void setSenderjobForwards(List<JobForward> senderjobForwards) {
        this.senderjobForwards = senderjobForwards;
    }

    public List<JobForward> getReceiverjobForwards() {
        return receiverjobForwards;
    }

    public void setReceiverjobForwards(List<JobForward> receiverjobForwards) {
        this.receiverjobForwards = receiverjobForwards;
    }

    public List<FriendRequest> getSenderRequests() {
        return senderRequests;
    }

    public void setSenderRequests(List<FriendRequest> senderRequests) {
        this.senderRequests = senderRequests;
    }

    public List<FriendRequest> getReceiverRequests() {
        return receiverRequests;
    }

    public void setReceiverRequests(List<FriendRequest> receiverRequests) {
        this.receiverRequests = receiverRequests;
    }

    public List<CompanyPush> getCompanyPushList() {
        return companyPushList;
    }

    public void setCompanyPushList(List<CompanyPush> companyPushList) {
        this.companyPushList = companyPushList;
    }

    public List<CompanySub> getCompanySubList() {
        return companySubList;
    }

    public void setCompanySubList(List<CompanySub> companySubList) {
        this.companySubList = companySubList;
    }

    public List<Jobapply> getJobapplyList() {
        return jobapplyList;
    }

    public void setJobapplyList(List<Jobapply> jobapplyList) {
        this.jobapplyList = jobapplyList;
    }

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
