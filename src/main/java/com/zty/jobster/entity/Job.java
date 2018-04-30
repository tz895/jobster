package com.zty.jobster.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.zty.jobster.entity.Enum.JobStatus;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "job")
public class Job implements Serializable{


    private static final long serialVersionUID = -6146804341985810735L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "jid")
    private int jobId;

    @ManyToOne
    @JoinColumn(name = "cid")
    private Company company;

    @Column(name="jname")
    private String name;

    @Column(name="location")
    private String location;

    @Column(name="title")
    private String title;

    @Column(name="salary")
    private String salary;

    @Column(name="diploma")
    private String diploma;

    @Column(name="major")
    private String major;

    @Column(name="description")
    private String description;

    @Column(name="post_time")
    private LocalDateTime post_time;

    @Column(name="due_time")
    private LocalDateTime due_time;

    @Enumerated(EnumType.STRING)
    @Column(name="status")
    private JobStatus status;

    @OneToMany(mappedBy = "pk.job",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Jobapply> jobapplyList;
    public int getJobId() {
        return jobId;
    }

    public List<Jobapply> getJobapplyList() {
        return jobapplyList;
    }

    public void setJobapplyList(List<Jobapply> jobapplyList) {
        this.jobapplyList = jobapplyList;
    }

    public void setJobId(int jobId) {
        this.jobId = jobId;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getDiploma() {
        return diploma;
    }

    public void setDiploma(String diploma) {
        this.diploma = diploma;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getPost_time() {
        return post_time;
    }

    public void setPost_time(LocalDateTime post_time) {
        this.post_time = post_time;
    }

    public LocalDateTime getDue_time() {
        return due_time;
    }

    public void setDue_time(LocalDateTime due_time) {
        this.due_time = due_time;
    }

    public JobStatus getStatus() {
        return status;
    }

    public void setStatus(JobStatus status) {
        this.status = status;
    }
}
