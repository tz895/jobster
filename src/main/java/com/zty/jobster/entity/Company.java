package com.zty.jobster.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "company")
public class Company implements Serializable{


    private static final long serialVersionUID = -2999576053384540956L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "cid")
    private int companyId;

    @OneToMany(mappedBy = "company",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Job> jobList;

    @OneToMany(mappedBy = "pk.company",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JsonIgnore
    private List<CompanySub> companySubList;


    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "cname")
    private String name;

    @Column(name = "location")
    private String location;

    @Column(name = "industry")
    private String industry;

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
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

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    public List<Job> getJobList() {
        return jobList;
    }

    public void setJobList(List<Job> jobList) {
        this.jobList = jobList;
    }

    public List<CompanySub> getCompanySubList() {
        return companySubList;
    }

    public void setCompanySubList(List<CompanySub> companySubList) {
        this.companySubList = companySubList;
    }

}
