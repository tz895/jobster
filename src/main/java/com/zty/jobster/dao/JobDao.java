package com.zty.jobster.dao;

import com.zty.jobster.entity.Company;
import com.zty.jobster.entity.Job;
import com.zty.jobster.entity.Student;

import java.util.List;

public interface JobDao {
    List<Job> getAllJobs();
    List<Job> getJobsByCompany(Company company);
    Job getJobById(int jid);
    void addJob(Job job);
    void updateJob(Job job);
    void deleteJob(int jid);
}
