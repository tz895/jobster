package com.zty.jobster.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Embeddable
public class CompanySubId implements Serializable{


    private static final long serialVersionUID = -7037657499452123605L;

    @ManyToOne
    @JsonIgnoreProperties("password")
    private Student student;

    @ManyToOne
//    @JsonIgnoreProperties("company.password")
    private Company company;

    public CompanySubId(Student student, Company company) {
        this.student = student;
        this.company = company;
    }

    public CompanySubId() {
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }
}
